package com.sdyin.mongodb.controller;

import com.sdyin.mongodb.dao.CustomerRepository;
import com.sdyin.mongodb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuye
 * @Date: 2018/9/18 21:21
 * @Description
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @RequestMapping("/addCustomer")
  public void add(){
    Customer customer = customerRepository.save(new Customer(1, "sdyin", "liuye"));
    customerRepository.save(new Customer(2,"ruimeng","ruiwen"));
    System.out.println(customer);
  }

  @RequestMapping("/queryCustomer")
  public void query(){

  }
}
