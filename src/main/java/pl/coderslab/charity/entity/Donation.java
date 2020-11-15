package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate pickUpDate;
    LocalTime pickUpTime;
    @Column(columnDefinition = "TEXT")
    String pickUpComment;

    @ManyToMany
    private List<Category> categoryList;

    @ManyToOne
    private Institution institution;


}
