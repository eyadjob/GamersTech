package gamersFun.com.example.gamersFun.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "Blogs")
public class Blogs {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Column(name = "user_id")
    private Long userId;


    @Column(name = "bio",length = 200000)
    @Size(max = 200000,message = "{blogs.body.size}")
    private String body;

    @Column(name = "Subject",length = 200)
    private String subject;

    public Date getCreatedDate() {
        return createdDate;
    }

    @Column(name = "created_date",updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
  /*  @Generated(GenerationTime.ALWAYS)*/
    private Date createdDate;

    @Column(name = "updated_date",updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    /*@Generated(GenerationTime.ALWAYS)*/
    private Date updatedDate;



    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
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

    @Column(name = "photo_Directory",length = 100)
    private String photoDirectory;
    @Column(name = "photo_Name",length = 20)
    private String photoName;
    @Column(name = "photo_Extension",length = 10)
    private String photoExtension;

    @ManyToMany()
    @JoinTable(
            name = "category_blogs",
            joinColumns = { @JoinColumn(name = "blog_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
    @OrderColumn(name="created_date")
    Set<CategoryEntity> categories = new HashSet<>();

    @Transient
    List<String> categoryNames;

    public void setCategoriesName() {
        this.categoryNames = categories.stream().map(d -> d.getName()).collect(Collectors.toList());
    }

    public List<String> getCategoriesName() {
        return categories.stream().map(CategoryEntity::getName).collect(Collectors.toList());
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }


    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        this.updatedDate = new Date();
        if (this.createdDate==null) {
            this.createdDate = new Date();
        }
    }

    public Blogs(){

    }
    public Blogs(String subject,String body,Profile profile){
        this.subject = subject;
        this.body = body;
        this.profile=profile;

    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Profile profile;


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
