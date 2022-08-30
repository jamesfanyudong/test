package com.hzbank.demo01.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter

public class Course {
 private Integer id;
 private String name;
 private Set<Account> accounts;

 @Override
 public String toString() {
  return "Course{" +
          "id=" + id +
          ", name='" + name + '\'' +
          '}';
 }
}