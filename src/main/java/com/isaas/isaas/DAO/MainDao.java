package com.isaas.isaas.DAO;

import com.isaas.isaas.Entities.Reflection.User;
import com.isaas.isaas.Entities.CRUD.UserRepo;
import com.isaas.isaas.Entities.Requests.*;
import com.isaas.isaas.Exceptions.ISException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;

@Service
public class MainDao implements IMainDao {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean register(RegisterRequest req) throws ISException{
        User newUser = new User(req.getFirstName(), req.getLastName(),
                req.getPhoneNumber(), req.getEmail(), req.getPassword(), req.getUsername());
        userRepo.save(newUser);
        return true;
    }

    public User login(LoginRequest req) throws ISException{
        User user = this.findByUsernameAndPassword(req.getUsername());
        if(user==null){
            return null;
        }
        if(passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            return user;
        }
        return null;
    }

    private User findByUsernameAndPassword(String username) throws ISException{
        Query q = this.entityManager.createQuery("SELECT user FROM User user WHERE user.username='"
        +username+"'");
        ArrayList<User> users = (ArrayList<User>)q.getResultList();
        if(users!=null && users.size()>0){
            if(users.size()>1){
                throw new ISException("DB ERROR: Duplicate Users");
            }
            return users.get(0);
        }
        return null;
    }



/**
 * ============================================================================================================
 * ============================================================================================================
 * ======                                 Validation Functions                                          =======
 * ============================================================================================================
 * ============================================================================================================
 * */

    /**
     * Check if email is already registered
     * @param email email
     * @return true/false
     * @throws ISException exception
     */
    public Boolean isEmailExists(String email) throws ISException{
        Query q = this.entityManager.createQuery("SELECT user FROM User user WHERE user.email='"
                +email+"'");
        ArrayList<User> users = (ArrayList<User>)q.getResultList();
        if(users!=null && users.size()>0){
            return true;
        }
        return false;
    }

    /**
     * Check if username is already registered
     * @param username username
     * @return true/false
     * @throws ISException exception
     */
    public Boolean isUsernameExists(String username) throws ISException{
        Query q = this.entityManager.createQuery("SELECT user FROM User user WHERE user.username='"
                +username+"'");
        ArrayList<User> users = (ArrayList<User>)q.getResultList();
        if(users!=null && users.size()>0){
            return true;
        }
        return false;
    }

    /**
     * Check if phoneNumber is already registered
     * @param phoneNumber phoneNumber
     * @return true/false
     * @throws ISException exception
     */
    public Boolean isPhoneNumberExists(String phoneNumber) throws ISException{
        Query q = this.entityManager.createQuery("SELECT user FROM User user WHERE user.phoneNumber='"
                +phoneNumber+"'");
        ArrayList<User> users = (ArrayList<User>)q.getResultList();
        if(users!=null && users.size()>0){
            return true;
        }
        return false;
    }


}
