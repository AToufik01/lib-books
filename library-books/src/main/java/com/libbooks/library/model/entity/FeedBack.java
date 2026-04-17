package com.libbooks.library.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "feedbacks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedBack {
    @Id
    @GeneratedValue
    private Integer id;
    private String note;
    private String comment;

    @ManyToOne
//    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

}
