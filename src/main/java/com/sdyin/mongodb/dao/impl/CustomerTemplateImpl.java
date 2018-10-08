package com.sdyin.mongodb.dao.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.sdyin.mongodb.dao.CustomerTemplate;
import com.sdyin.mongodb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liuye
 * @Date: 2018/10/8 11:00
 * @Description
 */
@Repository
public class CustomerTemplateImpl implements CustomerTemplate {

  @Autowired
  MongoTemplate mongoTemplate;

  /**
   * 新增客户
   * @param customer
   */
  public void insertCustomer(Customer customer) {
    mongoTemplate.insert(customer);
  }

  @Override
  public List<Customer> queryByCondition(Query query) {
    List<Customer> customers = mongoTemplate.find(query, Customer.class);
    return customers;
  }

  /**
   * 根据条件更新
   * @param query
   * @param update
   * @param collectionName
   * @return
   */
  @Override
  public Long updateByCondition(Query query, Update update, String collectionName) {
    UpdateResult updateResult = mongoTemplate.updateMulti(query, update, collectionName);
    return updateResult.getMatchedCount();
  }

  @Override
  public Long delByCondition(Query query) {
    DeleteResult delResult = mongoTemplate.remove(query, "customer");
    return delResult.getDeletedCount();
  }
}
