package com.isaas.isaas.Services;

import com.isaas.isaas.Entities.Requests.SearchRequest;
import com.isaas.isaas.Exceptions.ISException;
import com.isaas.isaas.ISDK.SDKHandler;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class BrowseService implements IBrowseService{

    SDKHandler sdk = SDKHandler.getHandler();

    public LinkedHashMap searchCategory(SearchRequest req) throws ISException{
        return sdk.searchFromEbayByCategories(req);
    }

    public LinkedHashMap getCategories() throws ISException{
        return sdk.getAllEbayCategories();
    }
}
