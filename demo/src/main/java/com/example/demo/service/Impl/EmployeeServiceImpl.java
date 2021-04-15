package com.example.demo.service.Impl;

import com.example.demo.entity.EmployeeParam;
import com.example.demo.exception.RRException;
import com.example.demo.mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;

import com.example.demo.service.EmployeeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(EmployeeParam employeeParam) {
        String s = employeeParam.getHobby().toString();
        Employee record = new Employee();
        BeanUtils.copyProperties(employeeParam,record);
        String replace = s.replace("[" , "").replace("]" , "").replace(" ","");

        record.setHobby(replace.trim());
        int i= employeeMapper.selectByPhoneNumber(record.getPhoneNumber());
        if(i!=0){
            throw  new RRException("手机号重复");
        }
        return employeeMapper.insert(record);
    }

    @Override
    public int insertSelective(Employee record) {
        return employeeMapper.insertSelective(record);
    }

    @Override
    public Employee selectByPrimaryKey(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(EmployeeParam employeeParam) {
        String s = employeeParam.getHobby().toString();
        Employee record = new Employee();
        BeanUtils.copyProperties(employeeParam,record);
        record.setHobby(s.replace("[","").replace("]","").replace(" ",""));
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return employeeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<EmployeeParam> selectSelective(Employee employee) {

        if(employee.getPageSize()!=null && employee.getPageNum()!=null){
            PageHelper.startPage(employee.getPageNum(),employee.getPageSize());
        }
        List<Employee> employees = employeeMapper.selectSelective(employee);
        List<EmployeeParam> list = new ArrayList<>();
        for (Employee employee1: employees){

            String[] split = employee1.getHobby().split(",");
            List<String> strings = Arrays.asList(split);
            EmployeeParam employeeParam = new EmployeeParam();
            BeanUtils.copyProperties(employee1,employeeParam);
            employeeParam.setHobby(strings);
            list.add(employeeParam);
        }
        return list;

    }

}
