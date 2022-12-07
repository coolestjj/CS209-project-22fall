package com.example.springproject.service.impl;

import com.example.springproject.mapper.IssueMapper;
import com.example.springproject.entity.Issue;
import com.example.springproject.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    // Impl里面要有Mapper
    @Autowired
    private IssueMapper issueMapper;


    @Override
    public int getIssueByState(String state) {
        return issueMapper.getIssueByState(state);
    }

    @Override
    public void insertIssues(List<Issue> issues) {
        issueMapper.insertIssues(issues);
    }

    @Override
    public double getSolveTimeAVG() {
        return issueMapper.getSolveTimeAVG();
    }

    @Override
    public double getSolveTimeMAX() {
        return issueMapper.getSolveTimeMAX();
    }

    @Override
    public double getSolveTimeSTDDEV() {
        return issueMapper.getSolveTimeSTDDEV();
    }
}
