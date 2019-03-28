package ru.itis.models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Category {
    private Long id;
    private String image;
    private String title;
    private List<ProductName> products;
}
