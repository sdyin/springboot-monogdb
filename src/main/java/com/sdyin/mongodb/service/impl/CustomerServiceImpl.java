package com.sdyin.mongodb.service.impl;

import com.sdyin.mongodb.dao.CustomerTemplate;
import com.sdyin.mongodb.model.Customer;
import com.sdyin.mongodb.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: liuye
 * @Date: 2018/10/8 10:57
 * @Description
 */
@Slf4j
@Service
public class CustomerServiceImpl implements ICustomerService {

  @Autowired
  private CustomerTemplate customerTemplate;

  @Override
  public List<Customer> queryByCondition(String nickName) {
    Query query = new Query(Criteria.where("nickName").is(nickName));
    List<Customer> customers = customerTemplate.queryByCondition(query);
    return customers;
  }

  @Override
  public Long delByCondition(String nickName) {
    Query query = new Query(Criteria.where("nickName").is(nickName));
    Long count = customerTemplate.delByCondition(query);
    return count;
  }
}
