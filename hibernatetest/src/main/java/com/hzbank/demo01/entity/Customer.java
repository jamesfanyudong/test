package com.hzbank.demo01.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Customer {
    private Integer id;
    private String name;
    private Set<Orders> orders;

 @Override
 public String toString() {
  return "Customer{" +
          "id=" + id +
          ", name='" + name + '\'' +
          '}';
 }
}