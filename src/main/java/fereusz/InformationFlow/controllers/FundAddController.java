package fereusz.InformationFlow.controllers;

import fereusz.InformationFlow.dtos.FundCreateDTO;
import fereusz.InformationFlow.services.FundCreateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/addfund")
public class FundAddController {

    private final FundCreateService fundCreateService;

    public FundAddController(FundCreateService fundCreateService) {
        this.fundCreateService = fundCreateService;
    }
    @GetMapping
    public String getFundAddPage (Model model) {
        model.addAttribute("fundCreateDTO", new FundCreateDTO());
        return "fund/fund-add";

    }
    @PostMapping
    public String processFundAddPage (@ModelAttribute("fundCreateDTO")
                                          @Valid FundCreateDTO fundCreateDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "addfund/fund-add";
        }
        fundCreateService.create(fundCreateDTO);
        return "redirect:/";

    }
}
