package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

 private InstitutionRepository institutionRepository;
 private InstitutionService institutionService;

    @Autowired
    public HomeController(InstitutionRepository institutionRepository, InstitutionService institutionService) {
        this.institutionRepository = institutionRepository;
        this.institutionService = institutionService;
    }

    @GetMapping()
    public String homeAction(Model model) {
        List<Institution> institutionList = institutionService.getInstitution();
        institutionService.saveInstitution(institutionList);
        institutionList = institutionRepository.findAll();
        model.addAttribute("institution", institutionList);
       return "index";
    }
}
