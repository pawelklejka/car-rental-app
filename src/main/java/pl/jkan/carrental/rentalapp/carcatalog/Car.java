package pl.jkan.carrental.rentalapp.carcatalog;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
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
