package com.cy.pro.service.impl;

import com.cy.pro.BaseDao;
import com.cy.pro.domain.Dept;
import com.cy.pro.service.DeptService;
import com.cy.pro.utils.Page;
import com.cy.pro.utils.UtilFuns;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DeptServiceImpl implements DeptService {
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    private BaseDao baseDao;

    @Override
    public List<Dept> find(String hql, Class<Dept> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    @Override
    public Dept get(Class<Dept> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    @Override
    public Page<Dept> findPage(String hql, Page<Dept> page, Class<Dept> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    @Override
    public void saveOrUpdate(Dept entity) {
        if (UtilFuns.isEmpty(entity.getId())) {//新增
            entity.setState(1);
        }
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<Dept> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    @Override
    public void deleteById(Class<Dept> entityClass, Serializable id) {
        String hql = "from Dept where parent_id=?";
        List<Dept> depts = baseDao.find(hql, Dept.class, new Object[]{id});//先查询出当前部门下面的所有子部门
        if (depts != null && depts.size() > 0) {
            for (int i = 0; i < depts.size(); i++) {
                this.deleteById(Dept.class, depts.get(i).getId());//递归删除
            }
        }
        baseDao.deleteById(Dept.class,id);
    }

    @Override
    public void delete(Class<Dept> entityClass, Serializable[] ids) {
        for (int i = 0; i < ids.length; i++) {
            deleteById(Dept.class,ids[i]);
        }
    }
}
