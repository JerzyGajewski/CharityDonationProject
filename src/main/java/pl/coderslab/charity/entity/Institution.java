package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @Column(columnDefinition = "TEXT")
    String description;

    @OneToMany
    private List<Donation> donationList = new ArrayList<>();
    //fixtury do fundacji i liczby darów
}
