package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.models.ProductName;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.util.List;

@Component
public class BasketRepositoryImpl implements BasketRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BasketRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SQL_INSERT_PRODUCT =
            "INSERT INTO basket (user_id, product_id) VALUES (?, ?)";

    private static final String SQL_DELETE_PRODUCT =
            "DELETE FROM basket where user_id = ? and id = ?";

    private static final String SQL_GET_ALL =
            "SELECT * FROM basket JOIN product on basket.product_id = product.id WHERE user_id = ?";


    private RowMapper<ProductName> rowMapper = (rs, i) -> ProductName.builder()
                    .title(rs.getString("title"))
                    .id(rs.getLong("id"))
                    .image(rs.getString("img"))
                    .model(rs.getString("model"))
                    .number_of_places(rs.getInt("number_of_places"))
                    .price(rs.getInt("price"))
                    .build();


    public void add(Long userId, Long productId){
        jdbcTemplate.update(SQL_INSERT_PRODUCT, userId, productId);

    }

    public void delete(Long userId, Long productId){
        jdbcTemplate.update(SQL_DELETE_PRODUCT, userId, productId);
    }

    public List<ProductName> getAllByUserId(Long userId) {
        return jdbcTemplate.query(SQL_GET_ALL, rowMapper, userId);
    }

}
