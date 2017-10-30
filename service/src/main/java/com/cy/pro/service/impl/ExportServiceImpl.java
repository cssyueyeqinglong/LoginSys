package com.cy.pro.service.impl;

import com.cy.pro.BaseDao;
import com.cy.pro.domain.*;
import com.cy.pro.service.ExportService;
import com.cy.pro.utils.Page;
import com.cy.pro.utils.UtilFuns;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.*;

public class ExportServiceImpl implements ExportService {
    private BaseDao baseDao;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public List<Export> find(String hql, Class<Export> entityClass, Object[] params) {
        return baseDao.find(hql, entityClass, params);
    }

    public Export get(Class<Export> entityClass, Serializable id) {
        return baseDao.get(entityClass, id);
    }

    public Page<Export> findPage(String hql, Page<Export> page, Class<Export> entityClass, Object[] params) {
        return baseDao.findPage(hql, page, entityClass, params);
    }


    public void saveOrUpdate(Export entity) {
        if (UtilFuns.isEmpty(entity.getId())) {
            //新增
            String[] ids = entity.getContract_ids().split(",");
            for (int i = 0; i < ids.length; i++) {
                Contract contract = baseDao.get(Contract.class, ids[i]);
                contract.setState(2);
                baseDao.saveOrUpdate(contract);

                Set<ContractProduct> cps = contract.getCps();
                Set<ExportProduct> eps = new HashSet<>();
                for (ContractProduct item :
                        cps) {
                    ExportProduct ep = new ExportProduct();
                    ep.setBox_num(item.getBox_num());
                    ep.setCnumber(item.getCnumber());
                    ep.setPrice(item.getPrice());
                    ep.setExport(entity);
                    ep.setFactory(item.getFactory());
                    ep.setOrder_no(item.getOrder_no());
                    ep.setPacking_unit(item.getPacking_unit());
                    ep.setProduct_no(item.getProduct_no());

                    Set<ExtEproduct> extEproducts = ep.getExtEproducts();
                    Set<ExtCproduct> extCproducts = item.getExtCproducts();
                    for (ExtCproduct ec :
                            extCproducts) {
                        ExtEproduct ext = new ExtEproduct();
                        BeanUtils.copyProperties(ec,ext);
                        ext.setId(null);
                        ext.setEp(ep);
                        baseDao.saveOrUpdate(ext);
                        extEproducts.add(ext);

                    }
                    ep.setExtEproducts(extEproducts);
                    eps.add(ep);
                }
                entity.setEps(eps);
            }
            entity.setContract_ids(entity.getContract_ids().replaceAll(","," "));
            entity.setState(0);//0草稿   1已上报   2已报运
        }
        entity.setInput_date(new Date());
        baseDao.saveOrUpdate(entity);
    }

    public void saveOrUpdateAll(Collection<Export> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    public void deleteById(Class<Export> entityClass, Serializable id) {

        baseDao.deleteById(entityClass, id);//删除一个对象
    }

    public void delete(Class<Export> entityClass, Serializable[] ids) {

        for (Serializable id : ids) {
            this.deleteById(Export.class, id);
        }
    }

    @Override
    public void changeState(String[] ids, Integer state) {
        for (String id : ids) {
            Export contract = baseDao.get(Export.class, id);
            if (contract != null) {
                contract.setState(state);
                this.saveOrUpdate(contract);//可以不写
            }
        }
    }
}
