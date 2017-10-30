package com.cy.pro.service.impl;

import com.cy.pro.BaseDao;
import com.cy.pro.domain.Role;
import com.cy.pro.service.RoleService;
import com.cy.pro.utils.Page;
import com.cy.pro.utils.UUIDUtils;
import com.cy.pro.utils.UtilFuns;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    private BaseDao baseDao;

    @Override
    public List<Role> find(String hql, Class<Role> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    @Override
    public Role get(Class<Role> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    @Override
    public Page<Role> findPage(String hql, Page<Role> page, Class<Role> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }

    @Override
    public void saveOrUpdate(Role entity) {
        if (UtilFuns.isEmpty(entity.getId())) {//新增
//            entity.setState(1);
            String uuid = UUIDUtils.getUUID();
            entity.setId(uuid);
//            entity.getUserInfo().setUser_info_id(uuid);
        }
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<Role> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    @Override
    public void deleteById(Class<Role> entityClass, Serializable id) {
        baseDao.deleteById(Role.class, id);
    }

    @Override
    public void delete(Class<Role> entityClass, Serializable[] ids) {
        for (int i = 0; i < ids.length; i++) {
            deleteById(Role.class, ids[i]);
        }
    }
}
