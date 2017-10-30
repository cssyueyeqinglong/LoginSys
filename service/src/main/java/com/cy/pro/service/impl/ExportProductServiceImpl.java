package com.cy.pro.service.impl;

import com.cy.pro.BaseDao;
import com.cy.pro.domain.ExportProduct;
import com.cy.pro.service.ExportProductService;
import com.cy.pro.utils.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ExportProductServiceImpl implements ExportProductService {
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    private BaseDao baseDao;

    @Override
    public List<ExportProduct> find(String hql, Class<ExportProduct> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    @Override
    public ExportProduct get(Class<ExportProduct> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    @Override
    public Page<ExportProduct> findPage(String hql, Page<ExportProduct> page, Class<ExportProduct> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    @Override
    public void saveOrUpdate(ExportProduct entity) {

        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<ExportProduct> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    @Override
    public void deleteById(Class<ExportProduct> entityClass, Serializable id) {
        baseDao.deleteById(ExportProduct.class, id);
    }

    @Override
    public void delete(Class<ExportProduct> entityClass, Serializable[] ids) {
        for (int i = 0; i < ids.length; i++) {
            deleteById(ExportProduct.class, ids[i]);
        }
    }

    @Override
    public void delete(Class<ExportProduct> entityClass, ExportProduct model) {
        baseDao.deleteById(ExportProduct.class, model.getId());
    }
}
