package com.example.springproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BasicMapper {

  void truncateTables(@Param("tableName") String tableName);
}
