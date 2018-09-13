package com.isaas.isaas.Entities.Reflection;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name="Users")
public class User{

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message="firstName is required")
    @Size(min=3, message="First Name: minimum 4 characters")
    @Pattern(regexp="^[A-Za-z]+", message="First Name: Illegal characters")
    @Column(name = "firstname", nullable=false, length=50)
    private String firstName;

    @NotNull(message="lastName is required")
    @Size(min=3, message="Last Name: minimum 4 characters")
    @Pattern(regexp="^[A-Za-z]+", message="Last Name: Illegal characters")
    @Column(name = "lastname", nullable=false, length=50)
    private String lastName;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Column(name = "phonenumber", nullable=false, length=50)
    private String phoneNumber;

    @NotNull(message="email is required")
    @Pattern(regexp="[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?",
            message="Email: Illegal email")
    @Column(name = "email", nullable=false, length=50, unique=true)
    private String email;

    @NotNull(message="Password is required")
    @Size(min=6, max=300)
    @Column(name = "password", nullable=false, length=300)
    private String password;

    @NotNull
    @Pattern(regexp="^[a-zA-Z][A-Za-z0-9]+", message="Username: invalid")
    @Column(name = "username", nullable=false, length=50)
    private String username;

    public User(String firstName, String lastName, String phoneNumber, @Email String email, String password, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public User() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, phoneNumber, email, password, username);
    }
}
