package com.isaas.isaas.Entities.Reflection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/*************************************************
 **************  Author eyMas  *******************
 **************  9/4/2018     *******************
 **************  ISAAS BackEnd *******************
 **************  eymaslive@gmail.com  ************
 *************************************************
 * Description: Affiliate
 *
 * ***********************************************
 */
@Entity
@Table(name = "Affiliate")
public class Affiliate implements Serializable {

    @Id
    @NotNull(message="username is required")
    @Size(min=3, message="username: minimum 4 characters")
    @Pattern(regexp="^[A-Za-z0-9]+", message="username: Illegal characters")
    @Column(name = "username", nullable=false, length=50)
    private String username;

    @NotNull(message="email is required")
    @Pattern(regexp="[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?",
            message="Email: Illegal email")
    @Column(name = "email", nullable=false, length=50, unique=true)
    private String email;

}

    
    