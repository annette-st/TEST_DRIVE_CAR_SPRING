package ru.itis.repositories;

import org.springframework.stereotype.Component;
import ru.itis.models.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.util.List;

@Component
public class FeedbackRepositoryImpl implements FeedbackRepository {

    private JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_FEEDBACK =
            "select first_name, content from customers c inner join feedback f on c.id=f.customer_id";

    private RowMapper<Feedback> rowMapperFeedback = (rs, i) -> Feedback.builder()
                    .first_name(rs.getString("first_name"))
                    .content((rs.getString("content")))
                    .build();

    @Autowired
    public FeedbackRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Feedback> showAllFeedback() {
        return jdbcTemplate.query(SQL_GET_ALL_FEEDBACK, rowMapperFeedback);
    }

}
