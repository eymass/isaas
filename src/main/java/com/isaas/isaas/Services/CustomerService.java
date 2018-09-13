package com.isaas.isaas.Services;

import com.isaas.isaas.Entities.CRUD.CustomerRepo;
import com.isaas.isaas.Exceptions.ISException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*************************************************
 **************  Author eyMas  *******************
 **************  8/22/2018     *******************
 **************  ISAAS BackEnd *******************
 **************  eymaslive@gmail.com  ************
 *************************************************
 * Description: SupplierService
 *
 * ***********************************************
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Boolean saveSupplier(Supplier sup) throws ISException{
        this.customerRepo.save(sup);
        return true;
    }

}

    
    