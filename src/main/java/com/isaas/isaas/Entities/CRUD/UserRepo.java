package com.isaas.isaas.Entities.CRUD;

import com.isaas.isaas.Entities.Reflection.User;
import com.isaas.isaas.Exceptions.ISException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends CrudRepository<User, String> {

    Boolean findByUsernameAndPassword(String username, String password) throws ISException;

}
