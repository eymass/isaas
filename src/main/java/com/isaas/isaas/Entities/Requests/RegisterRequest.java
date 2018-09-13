package com.isaas.isaas.Entities.Requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterRequest {

    @NotNull
    @Size(min=4, message="First Name: minimum 4 characters")
    @Pattern(regexp="^[A-Za-z]+", message="First Name: Illegal characters")
    private String firstName;
    @NotNull
    @Size(min=4, message="Last Name: minimum 4 characters")
    @Pattern(regexp="^[A-Za-z]+", message="Last Name: Illegal characters")
    private String lastName;
    @NotNull
    @Pattern(regexp="[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?",
    message="Email: Illegal email")
    private String email;
    @NotNull
    @Pattern(regexp="^[0-9]+", message="Phone number: invalid")
    private String phoneNumber;
    @NotNull
    @Pattern(regexp="^[a-zA-Z][A-Za-z0-9]+", message="Username: invalid")
    private String username;
    @NotNull(message="Password is required")
    @Size(min=6, max=18)
    @Pattern(regexp="^[a-zA-Z][A-Za-z0-9#$%@!^&*]+", message="Password: invalid")
    private String password;


    public RegisterRequest(@NotNull @Size(min = 4, message = "First Name: minimum 4 characters") @Pattern(regexp = "^[A-Za-z]+", message = "First Name: Illegal characters") String firstName, @NotNull @Size(min = 4, message = "Last Name: minimum 4 characters") @Pattern(regexp = "^[A-Za-z]+", message = "Last Name: Illegal characters") String lastName, @NotNull @Pattern(regexp = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?",
            message = "Email: Illegal email") String email, @NotNull @Pattern(regexp = "^[0-9]+", message = "Phone number: invalid") String phoneNumber, @NotNull @Pattern(regexp = "^[a-zA-Z][A-Za-z0-9]+", message = "Username: invalid") String username, @NotNull @Size(min = 6, max = 18) @Pattern(regexp = "^[a-zA-Z][A-Za-z0-9]+", message = "Password: invalid") String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    public RegisterRequest() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
