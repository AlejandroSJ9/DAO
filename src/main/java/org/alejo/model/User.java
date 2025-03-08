package org.alejo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int id;
    private String name;
    private String email;

    public User(String nombre, String email) {
        this.name = nombre;
        this.email = email;
    }
}
