package com.hzbank.demo01.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class Account {
 private Integer id;
 private String name;
 private Set<Course> courses;

 @Override
 public String toString() {
  return "Account{" +
          "id=" + id +
          ", name='" + name + '\'' +
          '}';
 }
}