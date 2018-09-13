package com.isaas.isaas.Entities.Reflection;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
/*************************************************
 **************  Author eyMas  *******************
 **************  8/22/2018     *******************
 **************  ISAAS BackEnd *******************
 **************  eymaslive@gmail.com  ************
 *************************************************
 * Description: Customer
 *
 * ***********************************************
 */
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

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
    private String phoneNumber1;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Column(name = "phonenumber1",  length=50)
    private String phoneNumber2;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Column(name = "phonenumber2", length=50)
    private String phoneNumber3;

    @NotNull(message="email is required")
    @Pattern(regexp="[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?",
            message="Email: Illegal email")
    @Column(name = "email", nullable=false, length=50, unique=true)
    private String email;

    @NotNull
    @Pattern(regexp="^[a-zA-Z]+", message="Country ID: invalid")
    @Column(name = "countryID", nullable=false, length=5)
    private String countryID;

    @Column(name = "ismarried")
    private Boolean isMarried;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Column(name = "socialnumber", length=100)
    private String socialNumber;

    @Column(name = "notes")
    private String notes;
}

    
    