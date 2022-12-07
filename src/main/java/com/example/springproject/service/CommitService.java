package com.example.springproject.service;

import com.example.springproject.entity.Commit;
import com.example.springproject.entity.DateAndCommitNum;
import com.example.springproject.entity.DeveloperAndCommitNum;

import java.util.List;

public interface CommitService {

    void insertCommits(List<Commit> Commits);

    List<DateAndCommitNum> getCommitNumByTime();

    List<DeveloperAndCommitNum> getCommitNumByDeveloper();
}
