package com.isaas.isaas.Controllers;

import com.isaas.isaas.Entities.CRUD.UserRepo;
import com.isaas.isaas.Entities.Requests.*;
import com.isaas.isaas.Services.IMainService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.isaas.isaas.Entities.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/security/")
@Api(value="Main", description="User Actions")
public class MainController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private IMainService mainService;

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public GeneralResponse login(@Valid @RequestBody LoginRequest req){
        try {
            String result = this.mainService.login(req);
            return new GeneralResponse(result,"Success");
        }catch(Exception e){
            return new GeneralResponse(null, "Error "+e);
        }
    }

    @RequestMapping(value="/logout", method= RequestMethod.POST)
    public GeneralResponse logout(@Valid @RequestBody LogoutRequest req){
        try {
            String result = this.mainService.logout(req);
            return new GeneralResponse(result,"Success");
        }catch(Exception e){
            return new GeneralResponse(null, "Error "+e);
        }
    }

    @RequestMapping(value="/register", method= RequestMethod.POST)
    public GeneralResponse register(@Valid @RequestBody RegisterRequest req){
        try {
            String result = this.mainService.register(req);
            return new GeneralResponse<String, String>(result,"Success");
        }catch(Exception e){
            return new GeneralResponse<String, String>(null, "Error "+e);
        }
    }
}
