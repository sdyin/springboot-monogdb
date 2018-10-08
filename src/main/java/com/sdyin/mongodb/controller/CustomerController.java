package com.sdyin.mongodb.controller;

import com.alibaba.fastjson.JSON;
import com.sdyin.mongodb.dao.CustomerRepository;
import com.sdyin.mongodb.model.Customer;
import com.sdyin.mongodb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
  @Autowired
  private ICustomerService customerService;

  @RequestMapping("/addCustomer")
  public void add(){
    Customer customer = customerRepository.save(new Customer(1, "sdyin", "liuye"));
    customerRepository.save(new Customer(2,"ruimeng","ruiwen"));
    System.out.println(customer);
  }

  @RequestMapping("/queryCustomer")
  public void query(){
    for (Customer customer : customerRepository.findAll()) {
      System.out.println(customer);
    }
  }

  @RequestMapping("/queryByFirstName")
  public void queryByFirsrName(){
    Customer customer = customerRepository.findByFirstName("sdyin");
    System.out.println(customer);
  }

  @GetMapping("/queryByCondition")
  public String queryByNickName(@RequestParam("nickName") String nickName){
    List<Customer> customers = customerService.queryByCondition(nickName);
    return JSON.toJSONString(customers);
  }
}
