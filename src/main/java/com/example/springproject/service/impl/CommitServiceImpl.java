package com.example.springproject.service.impl;

import com.example.springproject.entity.Commit;
import com.example.springproject.entity.DateAndCommitNum;
import com.example.springproject.entity.DeveloperAndCommitNum;
import com.example.springproject.mapper.CommitMapper;
import com.example.springproject.service.CommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitServiceImpl implements CommitService {

  @Autowired
  private CommitMapper commitMapper;

  @Override
  public void insertCommits(List<Commit> Commits) {
    commitMapper.insertCommits(Commits);
  }

  @Override
  public List<DateAndCommitNum> getCommitNumByTime() {
    return commitMapper.getCommitNumByTime();
  }

  @Override
  public List<DeveloperAndCommitNum> getCommitNumByDeveloper() {
    return commitMapper.getCommitNumByDeveloper();
  }

  ;

}
