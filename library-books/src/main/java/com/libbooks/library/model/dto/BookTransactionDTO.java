package com.libbooks.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookTransactionDTO {
    private Integer id;
    private boolean returned;
    private boolean returnApproved;
}
