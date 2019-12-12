package fereusz.InformationFlow.controllers;

import fereusz.InformationFlow.domain.entities.Fund;
import fereusz.InformationFlow.domain.entities.FundManager;
import fereusz.InformationFlow.domain.repositories.FundManagerRepository;
import fereusz.InformationFlow.domain.repositories.FundRepository;
import fereusz.InformationFlow.dtos.FeedbackEditDTO;
import fereusz.InformationFlow.services.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FeedbackBrowseController {

    private final FundManagerRepository fundManagerRepository;
    private final FeedbackService feedbackService;
    private final FundRepository fundRepository;

    public FeedbackBrowseController(FundManagerRepository fundManagerRepository, FeedbackService feedbackService, FundRepository fundRepository) {
        this.fundManagerRepository = fundManagerRepository;
        this.feedbackService = feedbackService;
        this.fundRepository = fundRepository;
    }

    @ModelAttribute("managers")
    public List<FundManager> managers() {
        return fundManagerRepository.findAll();
    }

    @ModelAttribute("funds")
    public List<Fund> funds() {
        return fundRepository.findAll();
    }


    @GetMapping("/feedback")
    public String prepareAllFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackService.findAll());
        return "feedback/feedback-all";
    }

    @GetMapping("/feedback/update/{id}")
    public String prepareUpdateFeedback(@PathVariable Long id, Model model) {
        model.addAttribute("feedbacks", feedbackService.prepareUpdate(id));
        return "feedback/feedback-update";

    }

    @PostMapping("/feedback/update/{id}")
    public String executeUpdateFeedback(@PathVariable Long id, @ModelAttribute("feedback")
    @Valid FeedbackEditDTO feedbackEditDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "feedback/feedback-update";
        }
        feedbackService.save(feedbackEditDTO);
        return "redirect:/feedback";
    }

    @GetMapping("/feedback/delete/{id}")
    public String deleteFeedback (@PathVariable Long id) {
        feedbackService.delete(id);
        return "redirect:/feedback";
    }




}
