package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@ApiModel(value="com.example.demo.entity.Employee")
@Data
public class EmployeeParam implements Serializable {
    @ApiModelProperty(value="null")
    private Long id;

    /**

    * 姓名
    */
    @ApiModelProperty(value="姓名")
    @NotNull
    private String name;
    /**
    * 性别(女0/男1)
    */
    @ApiModelProperty(value="性别(女0/男1)")
    @NotNull
    private Integer sex;

    /**
    * 年龄
    */
    @ApiModelProperty(value="年龄")
    @NotNull
    private Integer age;

    /**
    * 部门id
    */
    @ApiModelProperty(value="部门id")
    private Long departmentId;

    /**
    * 电话号
    */
    @ApiModelProperty(value="电话号")
    @NotNull
    private String phoneNumber;

    /**
    * 爱好
    */
    @ApiModelProperty(value="爱好")
    private List<String> hobby;
    private String departmentName;
    /**
    * 地址
    */
    @ApiModelProperty(value="地址")
    private String adress;

    private Integer pageNum;
    private Integer pageSize;




}