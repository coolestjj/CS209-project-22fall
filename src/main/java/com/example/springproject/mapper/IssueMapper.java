package com.example.springproject.mapper;

import com.example.springproject.entity.Issue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IssueMapper {

//    @Select("select * from sqlpubcooljj.issue where state=#{state}")
    List<Issue> getIssueByState(String state);

    void insertIssues(List<Issue> issues);

}
