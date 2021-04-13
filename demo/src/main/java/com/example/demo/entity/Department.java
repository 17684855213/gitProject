package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value="com.example.demo.entity.Department")
@Data
public class Department implements Serializable {
    @ApiModelProperty(value="null")
    private Long id;

    @ApiModelProperty(value="null")
    private String name;

    @ApiModelProperty(value="null")
    private String info;

    private Integer pageNum;
    private Integer pageSize;


    private static final long serialVersionUID = 1L;

}