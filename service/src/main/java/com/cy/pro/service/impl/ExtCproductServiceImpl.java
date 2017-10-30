package com.cy.pro.service.impl;

import com.cy.pro.BaseDao;
import com.cy.pro.domain.Contract;
import com.cy.pro.domain.ContractProduct;
import com.cy.pro.domain.ExtCproduct;
import com.cy.pro.service.ExtCproductService;
import com.cy.pro.utils.Page;
import com.cy.pro.utils.UtilFuns;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ExtCproductServiceImpl implements ExtCproductService {
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    private BaseDao baseDao;

    @Override
    public List<ExtCproduct> find(String hql, Class<ExtCproduct> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    @Override
    public ExtCproduct get(Class<ExtCproduct> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    @Override
    public Page<ExtCproduct> findPage(String hql, Page<ExtCproduct> page, Class<ExtCproduct> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    @Override
    public void saveOrUpdate(ExtCproduct entity) {
        if (entity.getCnumber() == null) {
            entity.setCnumber(0);
        }
        if (entity.getPrice() == null) {
            entity.setPrice(0d);
        }
        Double amount = entity.getCnumber() * entity.getPrice();
        if (UtilFuns.isEmpty(entity.getId())) {//新增
            entity.setAmount(amount);
            ContractProduct cp = baseDao.get(ContractProduct.class, entity.getCp().getId());
            cp.setAmount(cp.getAmount() + amount);//修改货物价格
            //修改合同价格
            Contract contract = cp.getContract();
            contract.setTotal_amount(contract.getTotal_amount() + amount);
            baseDao.saveOrUpdate(contract);
        } else {//修改
            Double oldAmont = entity.getAmount();//取出在修改之前的价格
            entity.setAmount(amount);
            ContractProduct cp = baseDao.get(ContractProduct.class, entity.getCp().getId());
            cp.setAmount(cp.getAmount() - oldAmont + amount);//修改货物价格
            baseDao.saveOrUpdate(cp);
            Contract contract = cp.getContract();
            contract.setTotal_amount(contract.getTotal_amount() - oldAmont + amount);
            baseDao.saveOrUpdate(contract);
        }

        entity.setAmount(entity.getPrice() * entity.getCnumber());
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<ExtCproduct> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    @Override
    public void deleteById(Class<ExtCproduct> entityClass, Serializable id) {
        ExtCproduct extCproduct = baseDao.get(ExtCproduct.class, id);
        extCproduct.setCp(null);
        extCproduct.setFactory(null);
        baseDao.saveOrUpdate(extCproduct);
        baseDao.deleteById(ExtCproduct.class, id);
    }

    @Override
    public void delete(Class<ExtCproduct> entityClass, Serializable[] ids) {
        for (int i = 0; i < ids.length; i++) {
            deleteById(ExtCproduct.class, ids[i]);
        }
    }

    @Override
    public void delete(Class<ExtCproduct> entityClass, ExtCproduct ext) {
        ExtCproduct ec = baseDao.get(ExtCproduct.class, ext.getId());
        ContractProduct cp = baseDao.get(ContractProduct.class, ext.getCp().getId());
        cp.setAmount(cp.getAmount() - ec.getAmount());
        Contract contract = cp.getContract();
        contract.setTotal_amount(contract.getTotal_amount() - ec.getAmount());
        baseDao.saveOrUpdate(contract);
        baseDao.deleteById(ExtCproduct.class, ext.getId());
    }
}
