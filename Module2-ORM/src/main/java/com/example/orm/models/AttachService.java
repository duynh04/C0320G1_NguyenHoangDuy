package com.example.orm.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attachservices")
@Getter
@Setter
@NoArgsConstructor
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double price;

    @ManyToMany(mappedBy = "attachServices")
    //@JoinTable(name = "contract_service")
    private Set<Contract> contracts;

}
