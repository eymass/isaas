package com.isaas.isaas.Services;

import com.isaas.isaas.Entities.Requests.SearchRequest;
import com.isaas.isaas.Exceptions.ISException;

import java.util.LinkedHashMap;

public interface IBrowseService {

    Object searchCategory(SearchRequest req) throws ISException;

    LinkedHashMap getCategories() throws ISException;
}
