package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.enums.InstitutionEnum;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.interfaces.InstitutionInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstitutionService implements InstitutionInterface {

    private InstitutionRepository institutionRepository;


    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }


    @Override
    public List<Institution> getInstitution() {
        List<Institution> institutions = institutionRepository.findAll();
        if (institutions.size() == 0) {
            for (int i = 0; i < InstitutionEnum.values().length; i++) {
                Institution institution = new Institution();
                institution.setName(InstitutionEnum.values()[i].getName());
                institution.setDescription(InstitutionEnum.values()[i].getDescription());
                institutions.add(institution);
            }
            saveInstitution(institutions);
        }
        return institutions;
    }

    @Override
    public void saveInstitution(List<Institution> institutions) {
        for (Institution institution : institutions){
            institutionRepository.save(institution);
        }
    }


}
