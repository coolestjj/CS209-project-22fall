package com.example.springproject.mapper;

import com.example.springproject.entity.Release;
import com.example.springproject.entity.ReleaseAndCommitNum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReleaseMapper {

  void insertReleases(List<Release> releases);

  int getReleases();

  List<ReleaseAndCommitNum> getCommitsBeforeReleases();
}
