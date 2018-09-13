package com.isaas.isaas.Middleware;

import com.isaas.isaas.Entities.Reflection.User;
import com.isaas.isaas.Exceptions.ISException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.UUID;

/*************************************************
 **************  Author eyMas  *******************
 **************  8/6/2018     *******************
 **************  ISAAS BackEnd *******************
 **************  eymaslive@gmail.com  ************
 *************************************************
 * Description: ITokenService
 *
 * ***********************************************
 */
public interface ITokenService {

    String store(Authentication authentication) throws ISException;

    boolean contains(String token) throws ISException;

    User retrieve(String token) throws ISException;

    Boolean clearToken(String token) throws ISException;
}

    
    