package com.hzbank.demo01.entity;
import lombok.Data;
@Data
public class Orders {
 private Integer id;
 private String name;
 private Customer customer;

 @Override
 public String toString() {
  return "Orders{" +
          "id=" + id +
          ", name='" + name + '\'' +
          '}';
 }
}