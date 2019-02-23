package pl.jkan.registration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String passwordConfirm;
    @Column
    @ElementCollection
    Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles(){
        return roles;
    }
    public void setUsers(Set<Role> roles){
        this.roles = roles;
    }
    @Transient
    public String getPasswordConfirm(){
        return passwordConfirm;
    }
}
