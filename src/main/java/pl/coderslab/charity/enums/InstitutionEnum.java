package pl.coderslab.charity.enums;

import lombok.Getter;

@Getter
public enum InstitutionEnum {

    AKOGO("A kogo","Pomoc wybudzaniu dzieci ze śpiączki."),
    DBAMOZDROWIE("Dbam o Zdrowie", "Pomoc dzieciom z ubogich rodzin."),
    DLADZIECI("Dla dzieci","Pomoc osobom znajdującym się w trudnej sytuacji życiowej."),
    BEZDOMU("Bez domu","Pomoc dla osób nie posiadających miejsca zamieszkania");

    private String name;
    private String description;

    InstitutionEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
