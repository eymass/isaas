package com.isaas.isaas.Entities.CRUD;

import com.isaas.isaas.Entities.Reflection.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
