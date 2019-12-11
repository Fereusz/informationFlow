package fereusz.InformationFlow.services;

import fereusz.InformationFlow.domain.entities.Feedback;
import fereusz.InformationFlow.dtos.FeedbackDTO;

import java.util.List;

public interface FeedbackService {

    void create (FeedbackDTO feedbackDTO);
    List<Feedback> findAll();

    Feedback prepareUpdate (Long id);


}
