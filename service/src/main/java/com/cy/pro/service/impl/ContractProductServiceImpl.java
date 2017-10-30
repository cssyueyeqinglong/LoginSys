package com.cy.pro.service.impl;

import com.cy.pro.BaseDao;
import com.cy.pro.domain.Contract;
import com.cy.pro.domain.ContractProduct;
import com.cy.pro.domain.ExtCproduct;
import com.cy.pro.service.ContractProductService;
import com.cy.pro.utils.Page;
import com.cy.pro.utils.UtilFuns;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ContractProductServiceImpl implements ContractProductService {
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    private BaseDao baseDao;

    @Override
    public List<ContractProduct> find(String hql, Class<ContractProduct> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    @Override
    public ContractProduct get(Class<ContractProduct> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    @Override
    public Page<ContractProduct> findPage(String hql, Page<ContractProduct> page, Class<ContractProduct> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    @Override
    public void saveOrUpdate(ContractProduct entity) {

        if (entity.getCnumber() == null) {
            entity.setCnumber(0);
        }
        if (entity.getPrice() == null) {
            entity.setPrice(0d);
        }
        Double amount = entity.getCnumber() * entity.getPrice();
        if (UtilFuns.isEmpty(entity.getId())) {//新增
            entity.setAmount(amount);
            Contract contract = baseDao.get(Contract.class, entity.getContract().getId());
            contract.setTotal_amount(contract.getTotal_amount() + entity.getAmount());
            baseDao.saveOrUpdate(contract);
        } else {//修改
            Double oldAmont = entity.getAmount();//取出在修改之前的价格
            entity.setAmount(amount);
            Contract contract = baseDao.get(Contract.class, entity.getContract().getId());
            contract.setTotal_amount(contract.getTotal_amount() - oldAmont + amount);
            baseDao.saveOrUpdate(contract);
        }


        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<ContractProduct> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    @Override
    public void deleteById(Class<ContractProduct> entityClass, Serializable id) {
        baseDao.deleteById(ContractProduct.class, id);
    }

    @Override
    public void delete(Class<ContractProduct> entityClass, Serializable[] ids) {
        for (int i = 0; i < ids.length; i++) {
            deleteById(ContractProduct.class, ids[i]);
        }
    }

    @Override
    public void delete(Class<ContractProduct> entityClass, ContractProduct model) {
        ContractProduct product = baseDao.get(ContractProduct.class, model.getId());
        Set<ExtCproduct> extCproducts = product.getExtCproducts();
        Double amount = 0d;
        //先累计附件下面的价格
        for (ExtCproduct item :
                extCproducts) {
            amount += item.getAmount();
        }
        amount += product.getAmount();//加上当前货物的价格
        Contract contract = baseDao.get(Contract.class, model.getContract().getId());
        contract.setTotal_amount(contract.getTotal_amount() - amount);
        baseDao.saveOrUpdate(contract);//保存修改后的数据
        //因为做过级联，所以直接删掉当前货物就可以删掉附件；
        baseDao.deleteById(ContractProduct.class, model.getId());
    }
}
