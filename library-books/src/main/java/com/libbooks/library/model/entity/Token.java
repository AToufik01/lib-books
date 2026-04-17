package com.libbooks.library.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tokens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    @GeneratedValue
    private Integer id;
    private String token;
    private Date createdAt;
    private Date expiredAt;
    private Date validatedAt;

    @ManyToOne
    private User user;
}
