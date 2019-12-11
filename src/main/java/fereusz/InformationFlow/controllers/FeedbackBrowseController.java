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
@RequestMapping("/feedback")
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

    @GetMapping
    public String prepareAllFeedbacks(Model model) {
        model.addAttribute("feedback", feedbackService.findAll());
        return "feedback/feedback-all";
    }

    @GetMapping("/update")
    public String prepareUpdateFeedback (Model model, Long id) {
        model.addAttribute("feedback",feedbackService.prepareUpdate(id));
        return "feedback/feedback-update";

    }
    @PostMapping("/update")
    public String executeUpdateFeedback (@ModelAttribute("feedback")
                                             @Valid FeedbackEditDTO feedbackEditDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "feedback/feedback-update";
        }

        return "redirect:/feedback";
    }


//    @PostMapping("/edit/{id}")
//    public String processEditMovie(@ModelAttribute("movie") @Valid EditMovieDTO movie, BindingResult result,
//                                   @PathVariable Long id) {
//        if (result.hasErrors()) {
//            return "admin/movies/edit";
//        }
//        if (movie != null) {
//            adminService.save(movie);
//        }
//        return "redirect:/admin/movies/all";
//    }
//
//    @GetMapping("/update")
//    public String prepareUpdateCategory (Model model, Long id) {
//        Optional<Category> result = categoryRepository.findById(id);
//        Category category = result.get();
//        model.addAttribute("category", category);
//        return "update-category";
//
//    }
//    @PostMapping("/update")
//    public String executeUpdateCategory(@ModelAttribute @Valid Category category, BindingResult result) {
//        if (result.hasErrors()){
//            return "/home";
//        }
//        categoryRepository.save(category);
//        return "redirect:/home";
//    }
}
