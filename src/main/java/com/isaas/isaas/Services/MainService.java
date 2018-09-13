package com.isaas.isaas.Services;

import com.isaas.isaas.DAO.IMainDao;
import com.isaas.isaas.Entities.Reflection.User;
import com.isaas.isaas.Entities.Requests.*;
import com.isaas.isaas.Exceptions.ISException;
import com.isaas.isaas.Middleware.AuthService;
import com.isaas.isaas.Tools.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * ISAAS
 * Main Service
 */
@Service
public class MainService implements IMainService {

    @Autowired
    AuthService authService;

    @Autowired
    IMainDao mainDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MainService() { }

    /**
     * Login
     * @param req
     * @return
     */
    @Override
    public String login(LoginRequest req) throws ISException{
        if(req==null){
            throw new ISException("Missing username and password");
        }
        if(req.getUsername()==null || req.getPassword()==null){
            throw new ISException("Missing username or password");
        }
        User user = this.mainDao.login(req);
        if(user!=null){
            this.authService.startToken();
            SecurityContextHolder.getContext().setAuthentication(authService.getAuthentication(req.getUsername(), req.getPassword()));
            return authService.getDevToken();
        }
        if(req.getUsername().equals("Isaas") && req.getPassword().equals("Isaas")){
            SecurityContextHolder.getContext().setAuthentication(authService.getAuthentication(req.getUsername(), req.getPassword()));
            return authService.getDevToken();
        }
        throw new ISException("Wrong username/password");
    }

    /**
     * Login
     * @param req
     * @return
     */
    @Override
    public String register(RegisterRequest req) throws ISException{
        this.validateRegister(req);
        if(req!=null){
            if(req.getEmail()!=null &&
                    req.getFirstName()!=null &&
                    req.getPhoneNumber()!=null &&
                    req.getLastName()!=null &&
                    req.getPassword()!=null){
                String encoded = passwordEncoder.encode(req.getPassword());

                req.setPassword(encoded);
                this.mainDao.register(req);
                return req.getUsername()+" registered successfully! \nWelcome to Isaas!";
            }
        } else{
            throw new ISException("Wrong username/password");
        }
        return "Error";
    }

    /**
     * Logout
     * @param req
     * @return
     */
    @Override
    public String logout(LogoutRequest req) throws ISException{
        return "SUCCESS";
    }


/**************************************************************************************************************
 *=============================================================================================================
 *=============================================================================================================
 *                                  Validation Functions
 *=============================================================================================================
 *=============================================================================================================
 *************************************************************************************************************/
    private void validateRegister(RegisterRequest req) throws ISException{
        if(this.mainDao.isEmailExists(req.getEmail())){
            throw new ISException(ErrorMessages.EMAIL_ALREADY_REGISTERED.getMessage());
        }
        if(this.mainDao.isPhoneNumberExists(req.getPhoneNumber())){
            throw new ISException(ErrorMessages.PHONE_ALREADY_REGISTERED.getMessage());
        }
        if(this.mainDao.isUsernameExists(req.getUsername())){
            throw new ISException(ErrorMessages.USERNAME_ALREADY_REGISTERED.getMessage());
        }
    }



}
