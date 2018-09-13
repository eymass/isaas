package com.isaas.isaas.Controllers;

import com.isaas.isaas.Entities.GeneralResponse;
import com.isaas.isaas.Entities.Requests.SearchRequest;
import com.isaas.isaas.Services.IBrowseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search/")
@Api(value="Main", description="User Actions")
public class BrowseController {

    @Autowired
    private IBrowseService browse;

    @RequestMapping(value="/ebay", method= RequestMethod.POST)
    public GeneralResponse searchEbay(@RequestBody SearchRequest req){
        try {
            Object res = this.browse.searchCategory(req);
            return new GeneralResponse(res,"Success");
        }catch(Exception e){
            return new GeneralResponse(null, "Error "+e);
        }
    }

    @RequestMapping(value="/ebay/categories", method= RequestMethod.GET)
    public GeneralResponse getCategories(){
        try {
            Object res = this.browse.getCategories();
            return new GeneralResponse(res,"Success");
        }catch(Exception e){
            return new GeneralResponse(null, "Error "+e);
        }
    }



}
