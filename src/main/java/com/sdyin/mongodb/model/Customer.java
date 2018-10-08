package com.sdyin.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author: liuye
 * @Date: 2018/9/18 21:15
 * @Description
 */
@Data
public class Customer {

  @Id
  public Integer id;
  public String firstName;
  public String lastName;
  public String nickName;

  public Customer(Integer id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
