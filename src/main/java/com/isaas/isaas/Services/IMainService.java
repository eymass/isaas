package com.isaas.isaas.Services;

import com.isaas.isaas.Entities.Requests.*;
import com.isaas.isaas.Exceptions.ISException;

public interface IMainService {

    String register(RegisterRequest req) throws ISException;

    String login(LoginRequest req) throws ISException;

    String logout(LogoutRequest req) throws ISException;
}
