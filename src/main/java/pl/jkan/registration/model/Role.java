package pl.jkan.registration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    @Column
    @ElementCollection
    Set<User> users;

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers(){
        return users;
    }
}
