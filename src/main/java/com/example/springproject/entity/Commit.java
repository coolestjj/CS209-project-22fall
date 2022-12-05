package com.example.springproject.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Commit {
    private String sha;
    private Date commit_date;
    private String developer;
    private Date commit_time;
}
