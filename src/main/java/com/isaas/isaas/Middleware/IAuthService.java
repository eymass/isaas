package com.isaas.isaas.Middleware;

import com.isaas.isaas.Exceptions.ISException;
import org.springframework.security.core.Authentication;

public interface IAuthService {

    String getDevToken() throws ISException;
    /**
     * Get authentication by username and password
     * @param username
     * @param password
     * @return
     * @throws ISException
     */
     Authentication getAuthentication(String username, String password) throws ISException;
    /**
     * Get authentication object
     * by token
     * @param token
     * @return
     */
    Authentication getAuthentication(String token) throws ISException;

    /**
     * Authenticate users
     * @param token
     * @return
     */
    Authentication authenticate(String token) throws ISException;


}
