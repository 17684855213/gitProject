package com.example.demo.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageUtil {


    public static void startPage(int pageIndex, int pageSize, String orderby){
        if(pageIndex<=0 ){
            pageIndex=1;
        }
        if(pageSize<=0 ){
            pageSize=10;
        }
        PageHelper.startPage(pageIndex,pageSize);
        PageHelper.orderBy(orderby);
    }

    public static PageInfoDto pageDetail(List list){
        PageInfo pageInfo = new PageInfo(list);
        PageInfoDto pageInfoDto = new PageInfoDto(pageInfo.getTotal(),pageInfo.getList());
        return pageInfoDto;
    }
}
