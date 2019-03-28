package ru.itis.repositories;

import ru.itis.models.ProductName;
import java.util.List;

public interface BasketRepository {
    void add(Long userId, Long productId);
    void delete(Long userId, Long productId);
    List<ProductName> getAllByUserId(Long userId);
}
