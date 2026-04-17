package com.libbooks.library.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private String email;
    private String password;
    private boolean accountLocked;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;


    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
    @OneToMany(mappedBy = "user")
    private List<BookTransactionHistory> bookTransactionHistories;

}
