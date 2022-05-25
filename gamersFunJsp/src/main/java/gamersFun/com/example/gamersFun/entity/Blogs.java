package gamersFun.com.example.gamersFun.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Blogs")
public class Blogs {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "bio",length = 1000)
    @Size(max = 1000,message = "{blogs.body.size}")
    private String body;

    @Column(name = "Subject",length = 200)
    private String subject;

    public Date getCreatedDate() {
        return createdDate;
    }

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public String getPhotoDirectory() {
        return photoDirectory;
    }

    public void setPhotoDirectory(String photoDirectory) {
        this.photoDirectory = photoDirectory;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoExtension() {
        return photoExtension;
    }

    public void setPhotoExtension(String photoExtension) {
        this.photoExtension = photoExtension;
    }

    @Column(name = "photo_Directory",length = 10)
    private String photoDirectory;
    @Column(name = "photo_Name",length = 10)
    private String photoName;
    @Column(name = "photo_Extension",length = 10)
    private String photoExtension;

    public Blogs(){

    }
    public Blogs(String subject,String body){
        this.subject = subject;
        this.body = body;
    }

    @PrePersist
    private void setCreatedDate(){
        Calendar calendar = Calendar.getInstance();
        this.createdDate = calendar.getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blogs blogs = (Blogs) o;
        return Objects.equals(id, blogs.id) && Objects.equals(subject, blogs.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject);
    }

    public void setPhotoDetails(FileInfo fileInfo){
        photoDirectory = fileInfo.getSubDirectory();
        photoExtension = fileInfo.getExtesion();
        photoName = fileInfo.getBaseName();
    }

    public Path getPhoto(String baseDiercory){
        if(photoName == null){
            return null;
        }
        return Paths.get(baseDiercory,photoDirectory,photoName.concat(".").concat(photoExtension));
    }
}
