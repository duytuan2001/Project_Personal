package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Date date;
    private Integer page;
    private Integer price;
    private String product;
    private String promotion;
    private Integer quality;
    private Integer rest;
    private String size;
    private String translator;
    private String writer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "customer_book",
           joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name="customer_id"))
    private Set<Customer> customers;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "account_role",
//            joinColumns = @JoinColumn(name = "account_id"),
//            inverseJoinColumns = @JoinColumn(name="role_id"))
//    private Set<Role> roles;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;

}
