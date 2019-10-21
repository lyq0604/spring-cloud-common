package com.blade.common.base;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lyq
 * @create 10/21/19
 */
public interface BaseMapper<T> extends Mapper<T>{

    /**
     * 根据条件查询列表
     * @param t
     * @return
     */
    List<T> selectListByEntity(T t);

}
