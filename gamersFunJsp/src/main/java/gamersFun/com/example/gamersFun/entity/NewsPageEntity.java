package gamersFun.com.example.gamersFun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "news_page")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsPageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    //    @NotBlank(message = "{news.page.subject.empty}")
    @Column(name = "subject")
    private String subject;

    //    @NotBlank(message = "{news.page.body.empty}")
    @Column(name = "body")
    private String body;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "created_date")
    @Generated(GenerationTime.INSERT)
    private Date created_date;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "category_newspage",
                joinColumns = { @JoinColumn(name = "newspage_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
    @OrderColumn(name="created_date")
    Set<CategoryEntity> categories = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsPageEntity that = (NewsPageEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(subject, that.subject) && Objects.equals(body, that.body);
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imageUrl, subject, body);
    }
}
