package com.example.springproject.service;

import com.example.springproject.dao.RepoService;

import com.example.springproject.entity.Repo;
import org.springframework.stereotype.Service;

@Service
public class RepoServiceImpl implements RepoService {

    @Override
    public Repo findInfo() {
        return new Repo();
    }
}
