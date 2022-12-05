package com.example.springproject.mapper;

import com.example.springproject.entity.Commit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommitMapper {

    void insertCommits(List<Commit> Commits);
}
