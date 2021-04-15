package com.example.demo.service.Impl;

import com.example.demo.entity.Employee;
import com.example.demo.exception.RRException;
import com.example.demo.mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.demo.entity.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.DepartmentService;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Resource
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {

        employeeMapper.deleteByDepartId(id);
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Department record) {
        Department department = new Department();
        department.setName(record.getName());
        List<Department> departments = departmentMapper.selectSelective(department);
        if(!CollectionUtils.isEmpty(departments)){
            throw new RRException("部门名称已存在");
        }
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

    @Override
    public List<Department> selectSelective(Department department) {
        if(department!=null){
            if(department.getPageSize()!=null && department.getPageIndex()!=null){
                PageHelper.startPage(department.getPageIndex(),department.getPageSize());
            }
        }

        return departmentMapper.selectSelective(department);

    }

}
