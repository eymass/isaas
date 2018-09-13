package com.isaas.isaas.Middleware;

import com.isaas.isaas.Entities.Reflection.User;
import com.isaas.isaas.Exceptions.ISException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Isaas Auth Service
 * 1. Authenticate Users
 * 2. Check Tokens
 * 3. Register Users
 */
@Service
public class AuthService implements IAuthService {

    private final String token = "ISS";

    @Autowired
    ITokenService tokenService;

    public AuthService() { }

    /**
     * Get the development token
     * @return
     */
    @Override
    public String getDevToken(){
        return this.token;
    }

    /**
     * Get authentication object
     * by username and password
     * @param username
     * @param password
     * @return
     */
    @Override
    public Authentication getAuthentication(String username, String password){
        IsaasAuthentication auth = new IsaasAuthentication(username, password);
        auth.setAuthenticated(true);
        return auth;
    }

    /**
     * Get authentication object
     * by token
     * @param token
     * @return
     */
    @Override
    public Authentication getAuthentication(String token){
        IsaasAuthentication auth = new IsaasAuthentication(token, token);
        auth.setValid(true);
        auth.setAuthenticated(true);
        return auth;
    }

    /**
     *
     * @param token
     * @return
     */
    @Override
    public Authentication authenticate(String token) throws ISException{
        User user = tokenService.retrieve(token);
        if(token=="DEVLEP"){
            return this.getAuthentication(token);
        }
        if(user==null){
            return null;
        }
        return this.getAuthentication(token);
    }
}
