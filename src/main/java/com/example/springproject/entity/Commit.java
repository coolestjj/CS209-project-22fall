package com.example.springproject.entity;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class Commit {
    private String sha;
    private Date commit_date;
    private String developer;
    private Timestamp commit_time;
}
