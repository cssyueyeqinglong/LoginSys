package com.cy.pro.service.impl;

import com.cy.pro.BaseDao;
import com.cy.pro.domain.Contract;
import com.cy.pro.domain.ContractProduct;
import com.cy.pro.domain.ExtCproduct;
import com.cy.pro.domain.ExtEproduct;
import com.cy.pro.service.ExtCproductService;
import com.cy.pro.service.ExtEproductService;
import com.cy.pro.utils.Page;
import com.cy.pro.utils.UtilFuns;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ExtEproductServiceImpl implements ExtEproductService {
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    private BaseDao baseDao;

    @Override
    public List<ExtEproduct> find(String hql, Class<ExtEproduct> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    @Override
    public ExtEproduct get(Class<ExtEproduct> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    @Override
    public Page<ExtEproduct> findPage(String hql, Page<ExtEproduct> page, Class<ExtEproduct> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    @Override
    public void saveOrUpdate(ExtEproduct entity) {
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<ExtEproduct> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    @Override
    public void deleteById(Class<ExtEproduct> entityClass, Serializable id) {
        baseDao.deleteById(ExtEproduct.class, id);
    }

    @Override
    public void delete(Class<ExtEproduct> entityClass, Serializable[] ids) {
        for (int i = 0; i < ids.length; i++) {
            deleteById(ExtEproduct.class, ids[i]);
        }
    }

    @Override
    public void delete(Class<ExtEproduct> entityClass, ExtEproduct ext) {
        baseDao.deleteById(ExtEproduct.class, ext.getId());
    }
}
