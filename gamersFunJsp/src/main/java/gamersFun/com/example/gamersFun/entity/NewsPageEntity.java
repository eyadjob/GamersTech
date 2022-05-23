package gamersFun.com.example.gamersFun.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "news_page")
@Data
@EqualsAndHashCode
public class NewsPageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @NotBlank(message = "{new.page.subject.empty}")
    @Column(name = "subject")
    private String subject;

    @NotBlank(message = "{new.page.body.empty}")
    @Column(name = "body")
    private String body;

}
