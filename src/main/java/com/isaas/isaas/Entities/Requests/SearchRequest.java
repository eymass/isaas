package com.isaas.isaas.Entities.Requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class SearchRequest {

    @Size(min=1, max=30)
    @Pattern(regexp="^[A-Za-z0-9$%&()=+!?~{}.,><@|_]+", message="Keywords: Illegal characters")
    private String keywords;

    @NotNull
    @Size(min=1, max=20)
    private ArrayList<Integer> categories;

    public SearchRequest() { }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public SearchRequest(ArrayList<Integer> categories) {
        this.categories = categories;
    }

    public ArrayList<Integer> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Integer> categories) {
        this.categories = categories;
    }
}
