package by.makedon.pascalrestservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_id")
    private long resourceId;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;
}