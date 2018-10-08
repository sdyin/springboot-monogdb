package com.sdyin.mongodb.service;

import com.sdyin.mongodb.model.Customer;

import java.util.List;

/**
 * @author: liuye
 * @Date: 2018/10/8 10:57
 * @Description
 */
public interface ICustomerService {

  /**
   * 根据条件查询
   * @param nickName
   */
  List<Customer> queryByCondition(String nickName);

  /**
   * 根据条件删除
   * @param nickName
   */
  Long delByCondition(String nickName);
}
