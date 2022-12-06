package com.example.springproject.service.impl;

import com.example.springproject.mapper.BasicMapper;
import com.example.springproject.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicServiceImpl implements BasicService {

    @Autowired
    private BasicMapper basicMapper;

    @Override
    public void truncateTable(String tableName) {
        basicMapper.truncateTables(tableName);
    }
}
