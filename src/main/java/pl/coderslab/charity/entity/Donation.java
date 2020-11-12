package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    Integer quantity;
    String phone;
    String street;
    String city;
    String zipCode;
    LocalDate pickUpDate;
    LocalTime pickUpTime;
    @Column(columnDefinition = "TEXT")
    String pickUpComment;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Institution institution;


}
