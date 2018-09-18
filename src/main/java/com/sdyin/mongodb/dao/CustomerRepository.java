package com.sdyin.mongodb.dao;

import com.sdyin.mongodb.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author: liuye
 * @Date: 2018/9/18 21:16
 * @Description
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

   Customer findByFirstName(String firstName);
   List<Customer> findByLastName(String lastName);
}
