package com.example.deliveryspring.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @Column
    private String pw;

    @Column
    private String name;
}
