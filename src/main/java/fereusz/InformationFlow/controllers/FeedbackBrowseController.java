package fereusz.InformationFlow.controllers;

import fereusz.InformationFlow.services.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feedback")
public class FeedbackBrowseController {

    private final FeedbackService feedbackService;

    public FeedbackBrowseController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public String prepareAllFeedbacks(Model model) {
        model.addAttribute("feedback", feedbackService.findAll());
        return "feedback/feedback-all";
    }

    @GetMapping
    public String prepareUpdateFeedback (Model model ) {

    }

}
