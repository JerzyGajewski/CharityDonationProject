package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.CategoryService;

import java.util.List;

@Controller
public class DonationController {

    private InstitutionRepository institutionRepository;
    private CategoryService categoryService;
    private CategoryRepository categoryRepository;
    private DonationRepository donationRepository;


    public DonationController(InstitutionRepository institutionRepository, CategoryRepository categoryRepository,
                              CategoryService categoryService, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
        this.donationRepository = donationRepository;
    }

    @ModelAttribute("institution")
    public List<Institution> institutionList() {
        return institutionRepository.findAll();
    }


    @GetMapping("/form")
    public String donationForm(Model model) {
        List<Category> categoryList = categoryService.getCategory();
        model.addAttribute("categories", categoryList);
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/form")
    public String filledForm(@ModelAttribute Donation donation){
        donationRepository.save(donation);
        return "form-confirmation";
    }
}
