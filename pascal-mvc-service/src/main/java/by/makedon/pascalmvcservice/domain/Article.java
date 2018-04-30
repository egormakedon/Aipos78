package by.makedon.pascalmvcservice.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private long articleId;
    private String title;
    private String body;
    private Date date;
    private Author author;
    private Resource resource;
}