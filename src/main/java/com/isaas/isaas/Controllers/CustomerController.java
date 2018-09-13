package com.isaas.isaas.Controllers;

import com.isaas.isaas.Entities.GeneralResponse;
import com.isaas.isaas.Entities.Reflection.Customer;
import com.isaas.isaas.Services.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@Api(value = "SupplierController", description = "SupplierController")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @RequestMapping(value="/add", method= RequestMethod.POST)
  public GeneralResponse addSupplier(@RequestBody Customer req){
    try {
         // Boolean res = this.customerService.saveSupplier(req);
          return new GeneralResponse(null,"Success");
    }catch(Exception e){
          return new GeneralResponse(null, "Error "+e);
    }
  }



}

    