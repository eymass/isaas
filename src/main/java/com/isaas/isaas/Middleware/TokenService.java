package com.isaas.isaas.Middleware;

import com.isaas.isaas.Entities.Reflection.User;
import com.isaas.isaas.Exceptions.ISException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.UUID;

/*************************************************
 **************  Author eyMas         ************
 **************  08/06/2018           ************
 **************  ISAAS BackEnd        ************
 **************  eymaslive@gmail.com  ************
 *************************************************
 * Description: TokenService
 *
 * ***********************************************
 */
@Service
public class TokenService implements ITokenService {

    @Autowired
    TokenDao tokenDao;

    private String generateNewToken(){
        return UUID.randomUUID().toString();
    }

    @Override
    public String store(Authentication authentication) throws ISException {
        String token = this.generateNewToken();
        IsaasAuthentication auth = (IsaasAuthentication)authentication;
        this.tokenDao.store(token, auth.getUser());
        return token;
    }

    @Override
    public boolean contains(String token) throws ISException {
        return this.tokenDao.contains(token);
    }

    @Override
    public User retrieve(String token) throws ISException {
        return tokenDao.retrieve(token);
    }

    @Override
    public Boolean clearToken(String token) throws ISException{
        return this.tokenDao.clearToken(token);
    }

}

    
    