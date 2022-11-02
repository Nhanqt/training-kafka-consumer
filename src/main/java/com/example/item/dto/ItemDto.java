package com.example.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private int id;
    private String itemName;
    private String description;
    private int catalogId;
    private String catalogName;
    private String catalogDescription;
    private int accountId;
    private String email;
    private String firstName;
    private String lastName;
}
