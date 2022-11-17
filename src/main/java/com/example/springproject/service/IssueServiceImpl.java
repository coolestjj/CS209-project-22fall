package com.example.springproject.service;

import com.example.springproject.dao.IssueMapper;
import com.example.springproject.entity.Issue;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IssueServiceImpl implements IssueMapper {

    @Autowired
    IssueMapper issueMapper;

    @Override
    public List<Issue> getIssue(String state) {
        List<Issue> issues;
        issues = issueMapper.getIssue(state);
        return issues;
    }
}
