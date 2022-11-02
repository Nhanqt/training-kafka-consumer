package com.example.item.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    private int id;
    private String itemName;
    private String description;
    private int numberof;
    private int catalogId;
    private int accountId;
}
