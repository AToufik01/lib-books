package com.libbooks.library.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "booktransaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookTransactionHistory {
    @Id
    @GeneratedValue
    private Integer id;
    private boolean returned;
    private boolean returnApproved;


    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;
}
