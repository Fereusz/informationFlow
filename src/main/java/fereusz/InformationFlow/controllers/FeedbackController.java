package fereusz.InformationFlow.controllers;

import fereusz.InformationFlow.domain.entities.Fund;
import fereusz.InformationFlow.domain.entities.FundManager;
import fereusz.InformationFlow.domain.repositories.FundManagerRepository;
import fereusz.InformationFlow.domain.repositories.FundRepository;
import fereusz.InformationFlow.dtos.FeedbackDTO;
import fereusz.InformationFlow.services.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/addfeedback")
public class FeedbackController {

    private final FundManagerRepository fundManagerRepository;
    private final FeedbackService feedbackService;
    private final FundRepository fundRepository;

    public FeedbackController(FundManagerRepository fundManagerRepository, FeedbackService feedbackService, FundRepository fundRepository) {
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

    @GetMapping
    public String prepareAddFeedback(Model model) {
        model.addAttribute("feedbackDTO", new FeedbackDTO());
        return "feedback/feedback-add";
    }

    @PostMapping
    public String processAddFeedback(@ModelAttribute("feedbackDTO")
                                     @Valid FeedbackDTO feedbackDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "addfeedback/feedback-add";
        }
        feedbackService.create(feedbackDTO);
        return "redirect:/";
    }


}

