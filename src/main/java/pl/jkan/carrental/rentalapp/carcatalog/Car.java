package pl.jkan.carrental.rentalapp.carcatalog;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
class Car {
    @Id
    String id;
    @Column
    String name;
    @Column
    String model;
    String segemnt;
    Integer capacity;
    Integer manufactureYear;
}
