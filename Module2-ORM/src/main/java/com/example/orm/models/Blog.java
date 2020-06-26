package com.example.orm.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private long id;

    @Column(name = "blog_title")
    private String title;

    @Column(name = "blog_datecreated")
    private LocalDateTime dateCreated;

    @Column(name = "blog_description")
    private String description;

    @Column(name = "blog_author")
    private String author;

    @Column(name = "blog_status")
    private Boolean status;
}
