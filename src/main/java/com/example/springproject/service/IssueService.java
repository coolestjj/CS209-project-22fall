package com.example.springproject.service;

import com.example.springproject.entity.Issue;

import java.util.List;

public interface IssueService {

    List<Issue> getIssueByState(String state);

    void insertIssues(List<Issue> issues);
}
