package fereusz.InformationFlow.controllers;

import fereusz.InformationFlow.domain.entities.Fund;
import fereusz.InformationFlow.domain.repositories.FundRepository;
import fereusz.InformationFlow.dtos.FundManagerDTO;
import fereusz.InformationFlow.services.FundManagerCreateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/addmanager")
public class FundManagerAddController {


    private final FundManagerCreateService fundManagerCreateService;
    private final FundRepository fundRepository;

    public FundManagerAddController(FundManagerCreateService fundManagerCreateService, FundRepository fundRepository) {
        this.fundManagerCreateService = fundManagerCreateService;
        this.fundRepository = fundRepository;
    }


    @ModelAttribute("funds")
    public List<Fund> funds () {
        return fundRepository.findAll();
    }

    @GetMapping
    public String getPmAddPage (Model model) {
//        List<Fund> funds = fundRepository.findAll();
        model.addAttribute("fundManagerDTO", new FundManagerDTO());
        return "manager/manager-add";

    }

    @PostMapping
    public String processAddPm (@ModelAttribute("fundManagerDTO")
                                @Valid FundManagerDTO fundManagerDTO, BindingResult result){
        if(result.hasErrors()) {
            return "addmanager/manager-add";
        }
        fundManagerCreateService.create(fundManagerDTO);
        return "redirect:/";
    }
}
