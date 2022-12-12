package com.example.springproject.service.impl;

import com.example.springproject.entity.Release;
import com.example.springproject.entity.ReleaseAndCommitNum;
import com.example.springproject.mapper.ReleaseMapper;
import com.example.springproject.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService {

  @Autowired
  private ReleaseMapper releaseMapper;

  @Override
  public void insertReleases(List<Release> releases) {
    releaseMapper.insertReleases(releases);
  }

  @Override
  public int getReleases() {
    return releaseMapper.getReleases();
  }

  @Override
  public List<ReleaseAndCommitNum> getCommitsBeforeReleases() {
    return releaseMapper.getCommitsBeforeReleases();
  }

}
