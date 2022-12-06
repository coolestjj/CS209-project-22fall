package com.example.springproject.mapper;

import com.example.springproject.entity.Commit;
import com.example.springproject.entity.DateAndCommitNum;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CommitMapper {

    void insertCommits(List<Commit> Commits);

    @MapKey("commit_date")
    List<DateAndCommitNum> getCommitNumByTime();
}
