package com.sample.itschoolpg.itschoolproject.entitiy;

import lombok.Data;

@Data
public class EmployeeEntity {
  
  private long id;
  private String name;
  private String kana;
  private String position;
  private String birthday;
  private String tel;
  private String mail;
  private String remarks;
}
