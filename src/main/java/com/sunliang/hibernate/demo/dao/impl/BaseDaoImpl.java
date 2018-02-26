package com.sunliang.hibernate.demo.dao.impl;

import com.sunliang.hibernate.demo.dao.BaseDao;
import com.sunliang.hibernate.demo.entity.BaseEntity;
import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author sunliang
 * @desc basedao
 * @create 2017-12-15 17:28
 **/
public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {
    // "排序"属性名称
    private static final String ORDER_LIST_PROPERTY_NAME = "orderList";

    // "创建日期"属性名称
    private static final String CREATE_DATE_PROPERTY_NAME = "createDate";

    private Class<T> entityClass;

    protected SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        Class c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T get(PK id) {
        Assert.notNull(id, "id is required");
        return (T) getSession().get(entityClass, id);
    }

    @Override
    public T load(PK id) {
        Assert.notNull(id, "id is required");
        return (T) getSession().load(entityClass, id);
    }

    @Override
    public List<T> getAllList() {
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(entityClass);
        String hql;
        if (classMetadata!=null && ArrayUtils.contains(classMetadata.getPropertyNames(), ORDER_LIST_PROPERTY_NAME)) {
            hql = "from " + entityClass.getName() + " as entity order by entity." + ORDER_LIST_PROPERTY_NAME + " desc";
        } else {
            hql = "from " + entityClass.getName();
        }
        return getSession().createQuery(hql).list();
    }

    @Override
    public Long getTotalCount() {
        String hql = "select count(*) from " + entityClass.getName();
        return (Long) getSession().createQuery(hql).uniqueResult();
    }

    @Override
    public PK save(T entity) {
        Assert.notNull(entity, "entity is required");
        if (entity instanceof BaseEntity) {
            try {
                Method method = entity.getClass().getMethod(BaseEntity.ON_SAVE_METHOD_NAME);
                method.invoke(entity);
                return (PK) getSession().save(entity);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return (PK) getSession().save(entity);
        }
    }

    @Override
    public void update(T entity) {
        Assert.notNull(entity, "entity is required");
        if (entity instanceof BaseEntity) {
            try {
                Method method = entity.getClass().getMethod(BaseEntity.ON_UPDATE_METHOD_NAME);
                method.invoke(entity);
                getSession().update(entity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            getSession().update(entity);
        }
    }

    @Override
    public void delete(T entity) {
        Assert.notNull(entity, "entity is required");
        getSession().delete(entity);
    }

    @Override
    public void delete(PK id) {
        Assert.notNull(id, "id is required");
        T entity = (T) getSession().load(entityClass, id);
        getSession().delete(entity);
    }
}
