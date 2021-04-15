package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeParam;
import com.example.demo.service.EmployeeService;
import com.example.demo.util.PageUtil;
import com.example.demo.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @ClassName EmployeeController
 * @Description TODO
 * @Author kangningning
 * @Date 2021/4/12 5:50 下午
 * @Version 1.0
 */

@RestController
@RequestMapping("/employee")
@Api(value = "员工管理",tags = {"员工管理"})
public class EmployeeController {


    @Autowired
    public EmployeeService employeeService;


    @PostMapping("/add")
    @ApiOperation("新增员工")
    public R add(@Valid @RequestBody EmployeeParam employeeParam){

        return R.ok("成功插入"+employeeService.insert(employeeParam)+"条数据");
    }
    @GetMapping("/delete")
    @ApiOperation("删除")
    public R delete(@RequestParam Long id){
        return R.ok("成功删除"+employeeService.deleteByPrimaryKey(id)+"条数据");
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public R update(@RequestBody EmployeeParam employeeParam){
        return R.ok("成功更新"+employeeService.updateByPrimaryKeySelective(employeeParam)+"条数据");
    }

    @PostMapping("/list")
    @ApiOperation("列表获取。支持分页。pageNum，pageSize传null获取全部列表")
    public R getList(@RequestBody Employee employee){
        return R.ok().put("data", PageUtil.pageDetail(employeeService.selectSelective(employee)));
    }


}
