package com.web.furama.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private long id;

    @Column(name = "authority_name")
    private String name;

    @OneToMany(mappedBy = "authority")
    private List<Account> accounts;

    public Authority(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Authority(long id) {
        this.id = id;
    }
}
