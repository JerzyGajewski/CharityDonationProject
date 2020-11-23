package pl.coderslab.charity.service.interfaces;

import pl.coderslab.charity.entity.Institution;

import java.util.List;

public interface InstitutionInterface {

    List<Institution> getInstitution();
    void saveInstitution(List<Institution> institutions);
}
