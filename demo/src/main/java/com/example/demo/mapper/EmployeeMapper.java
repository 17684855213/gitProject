package com.example.demo.mapper;


import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    int selectByPhoneNumber(String phoneNumber);

    List<Employee> selectSelective(Employee employee);

    void deleteByDepartId(Long id);
}