package com.isaas.isaas.Controllers;

import com.isaas.isaas.Entities.GeneralResponse;
import com.isaas.isaas.Entities.Requests.LoginRequest;
import com.isaas.isaas.Services.MainService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile/")
public class ISProfileController {


    @RequestMapping(value="/accountSettings", method= RequestMethod.POST)
    public GeneralResponse getAccountSettings(@RequestBody LoginRequest req){
        try {

            return new GeneralResponse("AccountDetails","Success");
        }catch(Exception e){
            return new GeneralResponse(null, "Error "+e);
        }
    }
}
