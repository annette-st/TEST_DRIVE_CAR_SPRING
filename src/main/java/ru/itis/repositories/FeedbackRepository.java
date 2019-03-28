package ru.itis.repositories;

import ru.itis.models.Feedback;
import java.util.List;

public interface FeedbackRepository {
    List<Feedback> showAllFeedback();
}
