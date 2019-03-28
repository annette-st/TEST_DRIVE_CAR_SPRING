package ru.itis.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ProductName {
    private Long id;
    private String title;
    private String image;
    private String model;
    private int number_of_places;
    private int price;
}

