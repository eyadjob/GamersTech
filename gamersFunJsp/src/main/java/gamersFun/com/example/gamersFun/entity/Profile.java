package gamersFun.com.example.gamersFun.entity;

import org.owasp.html.PolicyFactory;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profile")
public class Profile {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;

    @Column(name = "bio",length = 5000)
    @Size(max = 5000,message = "{editProfile.about.size}")
    private String bio;

    @Column(name = "photo_Directory",length = 10)
    private String photoDirectory;
    @Column(name = "photo_Name",length = 10)
    private String photoName;
    @Column(name = "photo_Extension",length = 10)
    private String photoExtension;


    //Bidirectional Relationship
    @OneToMany(mappedBy = "profile")
    private List<Blogs> blogsList;

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    @Transient
    private List<Tags> tags;

    public List<Blogs> getBlogsList() {
        return blogsList;
    }

    public void setBlogsList(List<Blogs> blogsList) {
        this.blogsList = blogsList;
    }


    public Profile(){

    }


    public Profile(UserEntity UserEntity){

    }

    public void setPhotoDetails(FileInfo fileInfo){
        photoDirectory = fileInfo.getSubDirectory();
        photoExtension = fileInfo.getExtesion();
        photoName = fileInfo.getBaseName();
    }

    /*
     * Create profile that suitable for saving and clear any html script text
     * */
    public void safeMergeFrom(Profile webProfile, PolicyFactory policyFactory){
        if(webProfile.bio != null){
            this.bio = policyFactory.sanitize(webProfile.bio);
        }
    }

    public Path getPhoto(String baseDiercory){
        if(photoName == null){
            return null;
        }
        return Paths.get(baseDiercory,photoDirectory,photoName.concat(".").concat(photoExtension));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity UserEntity) {
        this.user = UserEntity;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

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

    /*
     * Create profile that suitable for displaying in jsp
     * */
    public void safeCopyFrom(Profile other){
        if(other.bio != null){
            this.bio = other.bio;
        }

    }

}
