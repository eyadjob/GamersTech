package gamersFun.com.example.gamersFun.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
// id pk
// text
//user_id
//blog_id
//comment_id nullable whos parent for this comment
//created_date

//Blog i love this subject
//

@Entity
@Table(name = "comments")
public class Comment implements Comparable<Comment>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "text",length = 250)
    @Size(max = 250,message = "{comments.body.size}")
    private String text;

    @ManyToOne
    private Blogs blog;

    @OneToMany(mappedBy = "comment")
    /*@OrderBy("createdDate,id") ordered using collection.sort*/
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "comment_id",nullable = true)
    private Comment comment;


    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;


    @CreatedDate
    private Date createdDate;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Blogs getBlog() {
        return blog;
    }

    public void setBlog(Blogs blog) {
        this.blog = blog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // if comments in TreeSet then this called since it stored in list we don't need this
    @Override
    public int compareTo(Comment that) {
        int compareValue = this.createdDate.compareTo(that.createdDate);
        if(compareValue == 0){
            compareValue = this.id.compareTo(that.id);
        }
        return compareValue;
    }

    @PrePersist
    private void setDate() {
        this.createdDate = new Date();
    }
}
