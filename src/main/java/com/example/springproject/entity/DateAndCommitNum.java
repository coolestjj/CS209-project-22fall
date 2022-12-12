package com.example.springproject.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class DateAndCommitNum {

  private Date commit_date;
  private int commitNum;
}
