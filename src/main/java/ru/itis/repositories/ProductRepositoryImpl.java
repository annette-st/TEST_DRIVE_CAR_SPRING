package ru.itis.repositories;

import org.springframework.stereotype.Component;
import ru.itis.forms.FeedbackForm;
import ru.itis.models.Category;
import ru.itis.models.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.ProductName;
import javax.sql.DataSource;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SQL_READ_BY_ID =
            "SELECT title from product where id = ?";

    private static final String SQL_GET_ALL =
            "SELECT * FROM product";

    private static final String SQL_GET_ALL_CATEGORIES =
            "SELECT * FROM categories";

    private static final String SQL_GET_ALL_BY_CATEGORY_ID =
            "SELECT * FROM product WHERE category_id = ?";

    private static final String SQL_GET_ALL_FEEDBACK =
            "select first_name, content from customers c inner join feedback f on c.id=f.customer_id";

    private static final String SQL_INSERT =
            "insert into feedback (customer_id, content) values (?, ?)";


    private RowMapper<Feedback> rowMapperFeedback = (rs, i) -> Feedback.builder()
                    .first_name(rs.getString("first_name"))
                    .content((rs.getString("content")))
                    .build();

    private RowMapper<Category> rowMapperAllCategories = (rs, i) -> Category.builder()
            .id(rs.getLong("id"))
            .title(rs.getString("title"))
            .build();

    private RowMapper<ProductName> rowMapperAllProducts = (rs, i) -> ProductName.builder()
            .title(rs.getString("title"))
            .id(rs.getLong("id"))
            .image(rs.getString("img"))
            .model(rs.getString("model"))
            .number_of_places(rs.getInt("number_of_places"))
            .price(rs.getInt("price"))
            .build();

    private RowMapper<ProductName> rowMapper = (rs, i) -> ProductName.builder()
            .title(rs.getString("title"))
            .build();


    @Override
    public List<Feedback> showAllFeedback() {
        return jdbcTemplate.query(SQL_GET_ALL_FEEDBACK, rowMapperFeedback);
    }

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(SQL_GET_ALL_CATEGORIES, rowMapperAllCategories);
    }

    @Override
    public List<ProductName> getAllProducts() {
        return jdbcTemplate.query(SQL_GET_ALL, rowMapperAllProducts);
    }

    @Override
    public List<ProductName> getAllByCategoryId(Long categoryId) {
        return jdbcTemplate.query(SQL_GET_ALL_BY_CATEGORY_ID, rowMapperAllProducts, categoryId);
    }

    @Override
    public List<ProductName> get(Long productId) {
        return jdbcTemplate.query(SQL_READ_BY_ID, rowMapper, productId);
    }

    public void save(FeedbackForm model) {
        jdbcTemplate.update(SQL_INSERT, model.getCustomer_id(), model.getContent());
    }


}
