package com.sunliang.hibernate.demo.service.impl;

import java.io.Serializable;
import java.util.List;

import com.sunliang.hibernate.demo.dao.BaseDao;
import com.sunliang.hibernate.demo.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * BaseServiceImpl
 * @param <T>
 * @param <PK>
 */
@Transactional
public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

	private BaseDao<T, PK> baseDao;

	public BaseDao<T, PK> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	@Transactional(readOnly = true)
	public T get(PK id) {
		return baseDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public T load(PK id) {
		return baseDao.load(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getAllList() {
		return baseDao.getAllList();
	}

	@Override
	@Transactional(readOnly = true)
	public Long getTotalCount() {
		return baseDao.getTotalCount();
	}

	@Override
	@Transactional
	public PK save(T entity) {
		return baseDao.save(entity);
	}

	@Override
	@Transactional
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	@Transactional
	public void delete(T entity) {
		baseDao.delete(entity);
	}

	@Override
	@Transactional
	public void delete(PK id) {
		baseDao.delete(id);
	}


}