package fereusz.InformationFlow.services.impl;

import fereusz.InformationFlow.domain.entities.Feedback;
import fereusz.InformationFlow.domain.entities.User;
import fereusz.InformationFlow.domain.repositories.FeedbackRepository;
import fereusz.InformationFlow.domain.repositories.UserRepository;
import fereusz.InformationFlow.dtos.FeedbackDTO;
import fereusz.InformationFlow.services.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@Slf4j
public class DefaultFeedbackService implements FeedbackService {

    private final UserRepository userRepository;
    private final FeedbackRepository feedbackRepository;

    public DefaultFeedbackService(UserRepository userRepository, FeedbackRepository feedbackRepository) {
        this.userRepository = userRepository;
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public void create(FeedbackDTO feedbackDTO) {
        ModelMapper mapper = new ModelMapper();
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Feedback feedback = mapper.map(feedbackDTO, Feedback.class);
        feedback.setUser(user);
        log.info("Feedback to save: " + feedback);
        feedbackRepository.save(feedback);

    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback prepareUpdate(Long id) {
        Optional<Feedback> feedback = feedbackRepository.findById(id);
        return feedback.get();
    }


//    @Override
//    public List<FeedbackDTO> findAllFeedbacks() {
//        ModelMapper mapper = new ModelMapper();
//        return feedbackRepository.findAll().stream()
//                .map(f->mapper.map(f,FeedbackDTO.class))
//                .collect(Collectors.toList());
//    }
}
