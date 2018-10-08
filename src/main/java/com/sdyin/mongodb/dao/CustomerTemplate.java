package com.sdyin.mongodb.dao;

import com.sdyin.mongodb.model.Customer;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @author: liuye
 * @Date: 2018/10/8 10:59
 * @Description
 */
public interface CustomerTemplate {

  /**
   * 根据条件查询
   * @param query
   */
  List<Customer> queryByCondition(Query query);

  /**
   * 根据条件更新
   * @param query
   * @param update
   * @param collectionName
   * @return
   */
  Long updateByCondition(Query query, Update update, String collectionName);
}
