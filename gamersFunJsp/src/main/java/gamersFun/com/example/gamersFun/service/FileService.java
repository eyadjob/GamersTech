package gamersFun.com.example.gamersFun.service;


import gamersFun.com.example.gamersFun.entity.FileInfo;
import gamersFun.com.example.gamersFun.exception.ImageTooSmallException;
import gamersFun.com.example.gamersFun.exception.InvalidFileException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@Service
public class FileService {

    @Value("${photo.file.extensions}")
    private String imageExtrension;

    @Value("${photo.upload.directoy}")
    private String photoDirectory;


    private Random random = new Random();

    private String getFileExtension(String fileName){
            int dot = fileName.lastIndexOf(".");
            if(dot < 0){
                return null;
            }
            return fileName.substring(dot+1).toLowerCase();
    }

    private boolean isImageExtension(String extensio){

        for(String validEx : imageExtrension.split(",")){
            if(extensio.equalsIgnoreCase(validEx)){
                return true;
            }
        }
        return false;
    }

    private boolean isImageExtensionWithString(String extensio){

        for(String validEx : imageExtrension.split(",")){
            if(extensio.equalsIgnoreCase(validEx)){
                return true;
            }
        }
        return false;
    }

    private File makedirectory(String basePath){
        File directory = new File(basePath);
        if(!directory.exists()){
            directory.mkdir();
        }
        return directory;

    }


    public FileInfo saveImageFile(MultipartFile file, String baseDirectory, String subDirPrefix, String fileprefix, int width, int height) throws InvalidFileException, IOException, ImageTooSmallException {
        int nFileName = random.nextInt(1000);
        String fileName = String.format("%s%03d",fileprefix,nFileName);
        String extension = getFileExtension(file.getOriginalFilename());
        if(extension == null){
            throw new InvalidFileException("No file extension ... ");
        }

        if(!isImageExtension(extension)){
            throw new InvalidFileException("Not image file  ... ");
        }

        File directory= makedirectory(baseDirectory);
        Path filePath =Paths.get(directory.getCanonicalPath(),fileName+"."+extension);

        BufferedImage resizeImage = resizedImage(file,width,height);

        ImageIO.write(resizeImage,extension,filePath.toFile());

        Files.deleteIfExists(filePath);
        Files.copy(file.getInputStream(),filePath);

        System.out.println("File saved here " + filePath);

        return new FileInfo(fileName,extension,directory.getName(),baseDirectory);

    }

    private BufferedImage resizedImage(MultipartFile inputFile, int width, int height) throws IOException, ImageTooSmallException {
        BufferedImage image = ImageIO.read(inputFile.getInputStream());
        if(image.getWidth() < width || image.getHeight() <height){
            throw new ImageTooSmallException("Image too small");

        }

        double widthScale = (double) width/image.getWidth();
        double heightScale = (double) height/image.getHeight();

        double scale = Math.max(widthScale,heightScale);

        BufferedImage scaledImage = new BufferedImage((int)(scale * image.getWidth()),(int)(scale * image.getHeight()),image.getType());

        Graphics2D g = scaledImage.createGraphics();

        AffineTransform transform = AffineTransform.getScaleInstance(scale,scale);

        g.drawImage(image,transform,null);


        return scaledImage.getSubimage(0,0,width,height);

    }


    public FileInfo saveImageFileWithName(MultipartFile file, String imageDirectory, String imageName, String imageExtension,int width, int height) throws InvalidFileException, IOException, ImageTooSmallException {
        if(imageExtension == null){
            throw new InvalidFileException("No file extension ... ");
        }
        if(!isImageExtension(imageExtension)){
            throw new InvalidFileException("Not image file  ... ");
        }
        File directory= makedirectory(imageDirectory);
        Path filePath =Paths.get(directory.getAbsolutePath(),imageName);
        BufferedImage resizeImage = resizedImage(file,width,height);
        ImageIO.write(resizeImage,imageExtension,filePath.toFile());
        Files.deleteIfExists(filePath);
        Files.copy(file.getInputStream(),filePath);
        return new FileInfo(imageName,imageExtension,directory.getName(),imageDirectory);

    }


}
