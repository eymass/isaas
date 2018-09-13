package com.isaas.isaas.Middleware;

import com.isaas.isaas.Exceptions.ISException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * User Token Filter
 * 1.Filter users by Token
 * 2.Filter API by Path
 * 3.
 */
public class UserFilter extends BasicAuthenticationFilter {

    @Autowired
    IAuthService authService;

    @Autowired
    ITokenService tokenService;

    public UserFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if(request==null || request.getHeader("Authorization")==null) {
            return;
        }
        String token = request.getHeader("Authorization");
        try {
            Authentication auth = authService.authenticate(token);
            if(auth!=null){
                IsaasAuthentication iAuth = (IsaasAuthentication)auth;
                if(iAuth.isValid()) {
                    SecurityContextHolder.getContext().setAuthentication(auth);
                } else {
                    throw new ISException("Error user");
                }
            } else {
                throw new ISException("Error user");
            }
        } catch(Exception e){
            throw new IOException("Error user");
        }
        chain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        if(request.getRequestURI().equals("/security/register")){
            return true;
        }
        return false;
    }
}
