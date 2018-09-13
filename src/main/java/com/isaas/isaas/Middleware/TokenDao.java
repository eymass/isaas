package com.isaas.isaas.Middleware;

import com.isaas.isaas.Entities.Reflection.Token;
import com.isaas.isaas.Entities.Reflection.User;
import com.isaas.isaas.Exceptions.ISException;
import com.isaas.isaas.Tools.STools;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/*************************************************
 **************  Author eyMas  *******************
 **************  8/6/2018     *******************
 **************  ISAAS BackEnd *******************
 **************  eymaslive@gmail.com  ************
 *************************************************
 * Description: TokenDao
 *
 * ***********************************************
 */
public class TokenDao implements ITokenDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public void store(String token, User user) throws ISException {
        Token tokenEntity = new Token();
        tokenEntity.setToken(token);
        tokenEntity.setTtl(Integer.parseInt(STools.getPropertyFromFile("ttl")));
        tokenEntity.setCreated(STools.getDateTimestamp());
        tokenEntity.setUserID(user.getId());
        entityManager.persist(tokenEntity);
        entityManager.flush();
    }

    @Override
    public boolean contains(String token) {
        return true;
    }

    @Override
    public User retrieve(String token) {
        Token tk = entityManager.find(Token.class,token);
        return  new User();
    }

    @Override
    public Boolean clearToken(String token){
        return false;
    }
}

    
    