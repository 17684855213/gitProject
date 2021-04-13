package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.demo.entity.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    @Override
    public Department selectByPrimaryKey(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

}
