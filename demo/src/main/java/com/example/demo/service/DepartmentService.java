package com.example.demo.service;

import com.example.demo.entity.Department;

import java.util.List;

public interface DepartmentService{


    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectSelective(Department department);
}
