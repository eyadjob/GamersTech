package gamersFun.com.example.gamersFun.entity;

public class FileInfo {
    private String baseName;
    private String extesion;
    private String subDirectory;
    private String baseDirectory;// we can get it from message.properties

    private String completeFilePath;

    public FileInfo(String fileName, String extension, String name, String baseDirectory) {
        this.extesion=extension;
        this.baseDirectory=baseDirectory;
        this.baseName=fileName;
        this.subDirectory=name;
        this.completeFilePath = baseDirectory+baseName;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getExtesion() {
        return extesion;
    }

    public void setExtesion(String extesion) {
        this.extesion = extesion;
    }

    public String getSubDirectory() {
        return subDirectory;
    }

    public void setSubDirectory(String subDirectory) {
        this.subDirectory = subDirectory;
    }

    public String getBaseDirectory() {
        return baseDirectory;
    }

    public void setBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    public String getCompleteFilePath() {
        return completeFilePath;
    }

    public void setCompleteFilePath(String completeFilePath) {
        this.completeFilePath = completeFilePath;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "baseName='" + baseName + '\'' +
                ", extesion='" + extesion + '\'' +
                ", subDirectory='" + subDirectory + '\'' +
                ", baseDirectory='" + baseDirectory + '\'' +
                '}';
    }
}
