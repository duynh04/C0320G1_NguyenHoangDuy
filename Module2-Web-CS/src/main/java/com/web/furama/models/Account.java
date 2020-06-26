package com.web.furama.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private long id;

    @Column(name = "account_username")
    private String userName;

    @Column(name = "account_password")
    private String password;

    @Column(name = "account_status")
    private Boolean status;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;
}
