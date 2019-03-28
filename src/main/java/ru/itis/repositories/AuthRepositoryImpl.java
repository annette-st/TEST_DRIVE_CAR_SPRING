package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.models.Auth;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.util.List;

@Component
public class AuthRepositoryImpl implements AuthRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SQL_INSERT =
            "insert into auth(user_id, cookie_value) values (?, ?)";

    private static final String SQL_SELECT_BY_COOKIE_VALUE =
            "select * from auth where cookie_value = ?";


    private RowMapper<Auth> authRowMapper = (rs, i) -> Auth.builder()
                    .id(rs.getLong("user_id"))
                    .cookieValue(rs.getString("cookie_value"))
                    .build();


    @Override
    public List<Auth> findAll() {
        return null;
    }

    @Override
    public Auth find(Long id) {
        return null;
    }

    @Override
    public void save(Auth model) {
        jdbcTemplate.update(SQL_INSERT, model.getUser().getId(), model.getCookieValue());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Auth model) {

    }

    @Override
    public Auth findByCookieValue(String cookieValue) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_COOKIE_VALUE, authRowMapper, cookieValue);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
