package com.blade.common.utils;

import lombok.Data;

import java.util.List;

/**
 * 分页数据封装
 *
 * @author lyq
 * @create 8/19/19
 */
@Data
public class TableData<T> {

    private List<T> data;

    private Long total;

    public TableData(List<T> data, Long total) {
        this.data = data;
        this.total = total;
    }
}
