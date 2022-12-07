package com.example.springproject.service;

import com.example.springproject.entity.Issue;

import java.util.List;

public interface IssueService {

    int getIssueByState(String state);

    void insertIssues(List<Issue> issues);

    double getSolveTimeAVG();

    double getSolveTimeMAX();

    double getSolveTimeSTDDEV();
}
