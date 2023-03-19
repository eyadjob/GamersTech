package gamersFun.com.example.gamersFun.entity;

import org.springframework.security.core.userdetails.User;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/*@Embeddable
* This used to implement composite key and add @EmbeddedId annotation to the field that use it
* */
public class CommentID implements Serializable {
   /* @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    @ManyToOne
    public Blogs getBlog() {
        return blog;
    }

    public void setBlog(Blogs blog) {
        this.blog = blog;
    }

    private UserEntity user;
    private Blogs blog;*/
}
