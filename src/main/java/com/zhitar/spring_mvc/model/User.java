package com.zhitar.spring_mvc.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 15, message = "Name shoud be form 2 to 15 symbols")
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(min = 2, max = 15, message = "Surname shoud be form 2 to 15 symbols")
    private String surname;

    @Email
    private String email;

    private String password;
}
