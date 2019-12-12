package fereusz.InformationFlow.services;

import fereusz.InformationFlow.domain.entities.Feedback;
import fereusz.InformationFlow.dtos.FeedbackDTO;
import fereusz.InformationFlow.dtos.FeedbackEditDTO;

import java.util.List;

public interface FeedbackService {

    void create (FeedbackDTO feedbackDTO);
    List<Feedback> findAll();

    FeedbackEditDTO prepareUpdate (Long id);

    void save (FeedbackEditDTO editDTO);

    void delete (Long id);



}
