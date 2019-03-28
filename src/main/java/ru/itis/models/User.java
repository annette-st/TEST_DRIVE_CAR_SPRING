package ru.itis.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String hashPassword;
}

