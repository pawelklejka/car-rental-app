package pl.jkan.carrental.rental.carmodel;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Car")
@Builder
public class Car {
    @Id
    long id;
    @Column
    String name;
    @Column
    String model;
    String segment;
    Integer capacity;
    Integer manufactureYear;
}
