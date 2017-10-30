package com.cy.pro.service.impl;

import com.cy.pro.BaseDao;
import com.cy.pro.domain.Factory;
import com.cy.pro.service.FactoryService;
import com.cy.pro.utils.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class FactoryServiceImpl implements FactoryService {
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    private BaseDao baseDao;

    @Override
    public List<Factory> find(String hql, Class<Factory> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    @Override
    public Factory get(Class<Factory> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    @Override
    public Page<Factory> findPage(String hql, Page<Factory> page, Class<Factory> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    @Override
    public void saveOrUpdate(Factory entity) {
//        if (UtilFuns.isEmpty(entity.getId())) {//新增
//            entity.setState(1);
//        }
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<Factory> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    @Override
    public void deleteById(Class<Factory> entityClass, Serializable id) {
        baseDao.deleteById(Factory.class,id);
    }

    @Override
    public void delete(Class<Factory> entityClass, Serializable[] ids) {
        for (int i = 0; i < ids.length; i++) {
            deleteById(Factory.class,ids[i]);
        }
    }
}
