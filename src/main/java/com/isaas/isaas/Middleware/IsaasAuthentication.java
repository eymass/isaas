package com.isaas.isaas.Middleware;

import com.isaas.isaas.Entities.Reflection.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.Collection;

public class IsaasAuthentication extends PreAuthenticatedAuthenticationToken {

    private User user;

    private Boolean isValid = false;

    private String token;

    public IsaasAuthentication(Object aPrincipal, Object aCredentials) {
        super(aPrincipal, aCredentials);
    }

    public IsaasAuthentication(Object aPrincipal, Object aCredentials, Collection<? extends GrantedAuthority> anAuthorities) {
        super(aPrincipal, aCredentials, anAuthorities);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean isValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
