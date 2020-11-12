package pl.coderslab.charity.enums;

import lombok.Getter;

@Getter
public enum CategoryEnum {
UBRANIA("ubrania, które nadają się do ponownego użycia"), UBRANIAOUT("ubrania, do wyrzucenia"),
ZABAWKI("zabawki"), KSIAZKI("książki"), INNE("inne");


    private String name;

    CategoryEnum(String name) {
        this.name = name;
    }
}
