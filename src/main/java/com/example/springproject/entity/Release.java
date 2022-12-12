package com.example.springproject.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Release {

  private Timestamp publish_time;
  private int id;
}
