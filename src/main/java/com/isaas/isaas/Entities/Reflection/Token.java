package com.isaas.isaas.Entities.Reflection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/*************************************************
 **************  Author eyMas  *******************
 **************  8/6/2018     *******************
 **************  ISAAS BackEnd *******************
 **************  eymaslive@gmail.com  ************
 *************************************************
 * Description: Token
 *
 * ***********************************************
 */
@Entity
@Table(name="Usertoken")
public class Token {


    @Id
    @NotNull(message="Token is missing")
    @Size(min=20)
    @Column(name = "token", nullable=false, length=600)
    private String token;

    @NotNull(message="User ID is missing")
    @Column(name = "userid", nullable=false, length=200)
    private Integer userID;

    @NotNull(message="TTL is missing")
    @Column(name = "ttl", nullable=false)
    private Integer ttl;

    @NotNull(message="Created is missing")
    @Column(name = "created", nullable=false)
    private Date created;

    public Token() { }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

    
    