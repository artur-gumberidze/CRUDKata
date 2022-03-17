package web.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Name dont empty")
    @Size(min = 2, max = 25, message = "Incorrect name")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "Lastname dont empty")
    @Size(min = 2, max = 25, message = "Incorrect lastname")
    private String last_name;

    @Column(name = "email")
    @Email(message = "Email invalid")
    @NotEmpty(message = "Email dont empty")
    private String email;

    public User( String name, String last_name, String email) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public User() {

    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
