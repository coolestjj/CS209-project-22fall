package com.example.springproject.service;

import com.example.springproject.entity.Release;
import com.example.springproject.entity.ReleaseAndCommitNum;

import java.util.List;

public interface ReleaseService {

    void insertReleases(List<Release> releases);

    int getReleases();

    List<ReleaseAndCommitNum> getCommitsBeforeReleases();
}
