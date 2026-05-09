package com.libbooks.library.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FeedBackDTO {
    private Integer id;
    private String note;
    private String comment;
}

