package com.example.app.SpringBootWebContacts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteContact {
    private int id;
    private String img;
    private String name;
    private String phone;
}
