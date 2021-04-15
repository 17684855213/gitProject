package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeParam;

import java.util.List;

public interface EmployeeService{


    int deleteByPrimaryKey(Long id);

    int insert(EmployeeParam record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EmployeeParam record);

    int updateByPrimaryKey(Employee record);


    List<EmployeeParam> selectSelective(Employee employee);
}
