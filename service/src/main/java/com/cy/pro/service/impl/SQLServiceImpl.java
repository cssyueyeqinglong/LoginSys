package com.cy.pro.service.impl;

import com.cy.pro.SqlDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class SQLServiceImpl {

    private SqlDao sqlDao;

    public void setSqlDao(SqlDao sqlDao) {
        this.sqlDao = sqlDao;
    }

    //返回单值
    public String getSingleValue(String sql) {

        return sqlDao.getSingleValue(sql);
    }

    public String getSingleValue(String sql, Object[] objs) {
        return sqlDao.getSingleValue(sql, objs);
    }

    public String[] toArray(String sql) {
        return sqlDao.toArray(sql);
    }

    public List executeSQL(String sql) {
        return sqlDao.executeSQL(sql);
    }

    public List executeSQL(String sql, Object[] objs) {

        return sqlDao.executeSQL(sql, objs);
    }

    public List executeSQLForList(String sql, Object[] objs) {
        return sqlDao.executeSQLForList(sql, objs);
    }

    public int updateSQL(String sql) {
        return sqlDao.updateSQL(sql);
    }

    public int updateSQL(String sql, Object[] objs) {
        return sqlDao.updateSQL(sql, objs);
    }

    public int[] batchSQL(String[] sql) {
        return sqlDao.batchSQL(sql);
    }
}
