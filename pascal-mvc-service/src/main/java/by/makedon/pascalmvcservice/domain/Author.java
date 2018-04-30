package by.makedon.pascalmvcservice.domain;

import lombok.Data;

@Data
public class Author {
    private long authorId;
    private String name;
    private String surname;
    private String country;
}
