package mx.edu.utez.marketplace.user.controller;

import com.sun.istack.NotNull;
import mx.edu.utez.marketplace.person.model.Person;
import mx.edu.utez.marketplace.role.model.Role;
import org.hibernate.annotations.NotFound;
import org.springframework.lang.NonNull;

import java.util.Set;

public class UserDTO {
    private long id;
    @NonNull
    private String username;
    @NotFound
    private String password;
    @NotFound
    private Person person;
    @NotNull
    private Set<Role> roles;

    public UserDTO() {
    }

    public UserDTO(long id, @NonNull String username, String password, Person person, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }

    public UserDTO(@NonNull String username, String password, Person person, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public UserDTO(@NonNull String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
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
}
