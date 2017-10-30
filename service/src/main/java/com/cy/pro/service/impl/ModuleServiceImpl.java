package com.cy.pro.service.impl;

import com.cy.pro.BaseDao;
import com.cy.pro.domain.Module;
import com.cy.pro.service.ModuleService;
import com.cy.pro.utils.Page;
import com.cy.pro.utils.UUIDUtils;
import com.cy.pro.utils.UtilFuns;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ModuleServiceImpl implements ModuleService {
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    private BaseDao baseDao;

    @Override
    public List<Module> find(String hql, Class<Module> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    @Override
    public Module get(Class<Module> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    @Override
    public Page<Module> findPage(String hql, Page<Module> page, Class<Module> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    @Override
    public void saveOrUpdate(Module entity) {
        if (UtilFuns.isEmpty(entity.getId())) {//新增
            entity.setState(1);
            String uuid = UUIDUtils.getUUID();
            entity.setId(uuid);
        }
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<Module> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    @Override
    public void deleteById(Class<Module> entityClass, Serializable id) {
        baseDao.deleteById(Module.class, id);
    }

    @Override
    public void delete(Class<Module> entityClass, Serializable[] ids) {
        for (int i = 0; i < ids.length; i++) {
            deleteById(Module.class, ids[i]);
        }
    }
}
