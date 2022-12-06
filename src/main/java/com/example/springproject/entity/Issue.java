package com.example.springproject.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Issue {
    private int id;
    private String state;
    private Date create_date;
    private Date close_date;
}
