package com.cy.pro.service.impl;

import com.cy.pro.BaseDao;
import com.cy.pro.domain.Contract;
import com.cy.pro.service.ContractService;
import com.cy.pro.utils.Page;
import com.cy.pro.utils.UtilFuns;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ContractServiceImpl implements ContractService {
    private BaseDao baseDao;
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public List<Contract> find(String hql, Class<Contract> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    public Contract get(Class<Contract> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    public Page<Contract> findPage(String hql, Page<Contract> page, Class<Contract> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    public void saveOrUpdate(Contract entity) {
        if(UtilFuns.isEmpty(entity.getId())){
            //新增
            entity.setTotal_amount(0d);
            entity.setState(0);//0草稿   1已上报   2已报运
        }
        baseDao.saveOrUpdate(entity);
    }

    public void saveOrUpdateAll(Collection<Contract> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    public void deleteById(Class<Contract> entityClass, Serializable id) {

        baseDao.deleteById(entityClass, id);//删除一个对象
    }

    public void delete(Class<Contract> entityClass, Serializable[] ids) {

        for(Serializable id :ids){
            this.deleteById(Contract.class,id);
        }
    }

    @Override
    public void changeState(String[] ids, Integer state) {
        for(String id :ids){
            Contract contract =  baseDao.get(Contract.class, id);
            if(contract!=null){
                contract.setState(state);
                this.saveOrUpdate(contract);//可以不写
            }
        }
    }
}
