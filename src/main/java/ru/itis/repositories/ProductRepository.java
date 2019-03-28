package ru.itis.repositories;

import ru.itis.models.Category;
import ru.itis.models.Feedback;
import ru.itis.models.ProductName;
import java.util.List;

public interface ProductRepository {
    List<ProductName> getAllProducts();
    List<Category> getAllCategories();
    List<ProductName> get(Long productId);
    List<ProductName> getAllByCategoryId(Long categoryId);
    List<Feedback> showAllFeedback();
}
