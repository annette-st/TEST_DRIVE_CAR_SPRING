package ru.itis.services;

import org.springframework.stereotype.Component;
import ru.itis.models.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.repositories.FeedbackRepository;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> showFeedback() {
        return feedbackRepository.showAllFeedback();
    }
}
