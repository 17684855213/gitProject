package com.example.demo.util;

import lombok.Data;

import java.util.List;

@Data
public class PageInfoDto<T> {

     private long total;
     private List<T> items;

    public PageInfoDto() {
    }

    public PageInfoDto(long total, List<T> items) {
        this.total = total;
        this.items = items;
    }
}
