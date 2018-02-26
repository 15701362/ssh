package com.sunliang.hibernate.demo.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author sunliang
 * @desc 基类
 * @create 2017-12-15 17:27
 **/
public interface BaseDao<T, PK extends Serializable> {
    /**
     * 根据ID获取实体对象
     *
     * @param id
     *            记录ID
     * @return 实体对象
     */
    public T get(PK id);

    /**
     * 根据ID获取实体对象
     *
     * @param id
     *            记录ID
     * @return 实体对象
     */
    public T load(PK id);

    /**
     * 获取所有实体对象集合
     *
     * @return 实体对象集合
     */
    public List<T> getAllList();

    /**
     * 获取所有实体对象总数
     *
     * @return 实体对象总数
     */
    public Long getTotalCount();

    /**
     * 保存实体对象
     *
     * @param entity
     *            对象
     * @return ID
     */
    public PK save(T entity);

    /**
     * 更新实体对象
     *
     * @param entity
     *            对象
     */
    public void update(T entity);

    /**
     * 删除实体对象
     *
     * @param entity
     *            对象
     * @return
     */
    public void delete(T entity);

    /**
     * 根据ID删除实体对象
     *
     * @param id
     *            记录ID
     */
    public void delete(PK id);
}
