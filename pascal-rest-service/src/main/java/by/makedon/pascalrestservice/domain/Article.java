package by.makedon.pascalrestservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "article_id")
    private long articleId;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "date")
    private Date date;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_author_id")
    private Author author;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_resource_id")
    private Resource resource;
}