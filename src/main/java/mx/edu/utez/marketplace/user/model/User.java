package mx.edu.utez.marketplace.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.marketplace.person.model.Person;
import mx.edu.utez.marketplace.role.model.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String username;
    @JsonIgnore
    private String password;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToMany(mappedBy = "users")
    private Set<Role> authorities;

    public User() {
    }

    public User(long id, String username, String password, Person person, Set<Role> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.person = person;
        this.authorities = authorities;
    }

    public User(String username, String password, Person person, Set<Role> authorities) {
        this.username = username;
        this.password = password;
        this.person = person;
        this.authorities = authorities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }
}
