package com.example.item.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {
    private LocalDateTime createdDate;
    private String createBy;
    private LocalDateTime updatedDate;
    private String updatedBy;
    private LocalDateTime deletedDate;
    private String deletedBy;
}
