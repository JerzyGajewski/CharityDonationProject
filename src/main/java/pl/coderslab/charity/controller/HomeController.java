package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {

 private InstitutionRepository institutionRepository;
 private InstitutionService institutionService;
 private DonationRepository donationRepository;

    @Autowired
    public HomeController(InstitutionRepository institutionRepository, InstitutionService institutionService,
                          DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.institutionService = institutionService;
        this.donationRepository=donationRepository;
    }

    @GetMapping()
    public String homeAction(Model model) {
        List<Institution> institutionList = institutionService.getInstitution();
        institutionService.saveInstitution(institutionList);
        institutionList = institutionRepository.findAll();
        model.addAttribute("institution", institutionList);

       return "index";
    }

    @ModelAttribute
    void DonationQuantity(Model model){
        List<Donation> donationList = donationRepository.findAll();
        int totalPacks = donationList.stream().mapToInt(total -> total.getQuantity()).sum();
        model.addAttribute("donationQuantity", donationList.size());
        model.addAttribute("donationPacks", totalPacks);
    }
}
