package com.blade.common.base;

import com.blade.common.utils.TableData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public class BaseService<M extends Mapper<T>, T> {

    @Autowired
    protected M mapper;

    /**
     * 新增实体
     *
     * @param t
     */
    public int insert(T t) {
        int insert = mapper.insert(t);
        return insert;
    }

    /**
     * 根据主键删除实体,返回删除记录数
     *
     * @param id
     */
    public int deleteById(String id) {
        int i = mapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * 修改实体
     *
     * @param t
     * @return 影响记录数
     */
    public int update(T t) {
        int update = mapper.updateByPrimaryKey(t);
        return update;
    }

    /**
     * 根据主键查询
     *
     * @param key
     * @return
     */
    public T selectOneByKey(Object key) {
        T t = mapper.selectByPrimaryKey(key);
        return t;
    }

    /**
     * 条件查询列表
     *
     * @param t
     * @return
     */
    public List<T> selectListByEntity(T t) {
        List<T> list = mapper.select(t);
        return list;
    }

    /**
     * 查询列表，带分页
     * @param pageNum 页数
     * @param pageSize 页面大小
     * @param t
     * @return
     */
    public TableData selectPage(Integer pageNum, Integer pageSize, T t) {
        PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 10 : pageSize);
        List<T> list = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return  new TableData(pageInfo.getList(),pageInfo.getTotal());
    }
}
