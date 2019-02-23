package pl.jkan.carrental.carmodel;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "car")
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    String name;
    String model;
    String segment;
    Integer capacity;
    Integer manufactureYear;
}
