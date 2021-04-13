package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName DepartmentController
 * @Description TODO
 * @Author kangningning
 * @Date 2021/4/13 10:59 上午
 * @Version 1.0
 */
@RestController
@RequestMapping("/department")
@Api(value = "部门管理",tags = {"部门管理"})
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    @ApiOperation("新增部门")
    public R add(@Valid @RequestBody Department department){

        return R.ok("成功插入"+departmentService.insert(department)+"条数据");
    }
    @GetMapping("/delete")
    @ApiOperation("删除")
    public R delete(@RequestParam Long id){
        return R.ok("成功删除"+departmentService.deleteByPrimaryKey(id)+"条数据");
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public R update(@RequestBody Department department){
        return R.ok("成功更新"+departmentService.updateByPrimaryKeySelective(department)+"条数据");
    }

    @GetMapping("/list")
    @ApiOperation("列表获取。支持分页。pageNum，pageSize传null获取全部列表")
    public R getList(@RequestBody Department department){
        return R.ok().put("data",departmentService.selectSelective(department));
    }
}
