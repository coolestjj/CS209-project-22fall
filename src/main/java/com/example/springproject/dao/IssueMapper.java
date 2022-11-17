package com.example.springproject.dao;

import com.example.springproject.entity.Issue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IssueMapper {

    List<Issue> getIssue(String state);

}
