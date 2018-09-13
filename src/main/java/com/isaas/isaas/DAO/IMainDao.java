package com.isaas.isaas.DAO;

import com.isaas.isaas.Entities.Reflection.User;
import com.isaas.isaas.Entities.Requests.LoginRequest;
import com.isaas.isaas.Entities.Requests.RegisterRequest;
import com.isaas.isaas.Exceptions.ISException;

public interface IMainDao {

    Boolean register(RegisterRequest req) throws ISException;
    User login(LoginRequest req) throws ISException;
    Boolean isEmailExists(String email) throws ISException;
    Boolean isUsernameExists(String email) throws ISException;
    Boolean isPhoneNumberExists(String email) throws ISException;
}
