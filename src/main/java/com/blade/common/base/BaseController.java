package com.blade.common.base;

import com.blade.common.response.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class BaseController<S extends BaseService, T> {

    @Autowired
    protected S service;

    /**
     * 新增实体
     * @param t
     * @return
     */
    @PostMapping("/add")
    public BaseResult add(@RequestBody T t){
        service.insert(t);
        return new BaseResult().success(t);
    }

    /**
     * 根据主键删除实体
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public BaseResult deleteByKey(@PathVariable String id){
        service.deleteById(id);
        return new BaseResult().success();
    }

    /**
     * 根据主键更新实体
     * @param t
     * @return
     */
    @PutMapping("/update")
    public BaseResult update(@RequestBody T t){
        service.update(t);
        return new BaseResult().success(t);
    }

    /**
     * 根据主键获取单个实体
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public BaseResult selectEntityByKey(@PathVariable String id) {
        return new BaseResult().success(service.selectOneByKey(id));
    }

    /**
     * 根据实体查询list,不含分页
     * @param t
     * @return
     */
    @GetMapping("/list")
    public BaseResult selectList(T t){
        return new BaseResult().success(service.selectListByEntity(t));
    }

    /**
     * 条件查询实list，带分页
     * @param pageNum
     * @param pageSize
     * @param t
     * @return
     */
    @GetMapping("/page")
    public BaseResult selectPageList(Integer pageNum, Integer pageSize, T t){
        return new BaseResult().success(service.selectPage(pageNum,pageSize,t));
    }

}
