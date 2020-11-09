package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Controller
public class DonationController {

    private InstitutionRepository institutionRepository;


    public DonationController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @ModelAttribute("institution")
public List<Institution> institutionList(){
        return institutionRepository.findAll();
    }


@GetMapping("/form")
    public String donationForm(){

    return "form";
}
}
