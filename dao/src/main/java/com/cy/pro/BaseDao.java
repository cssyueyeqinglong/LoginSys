package com.cy.pro;

import com.cy.pro.utils.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * @Description:
 * @Author:		传智播客 java学院	传智.宋江
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月31日
 */
public interface BaseDao {
	//查询所有，带条件查询
	public <T> List<T> find(String hql, Class<T> entityClass, Object[] params);
	//获取一条记录
	public <T> T get(Class<T> entityClass, Serializable id);
	//分页查询，将数据封装到一个page分页工具类对象
	public <T> Page<T> findPage(String hql, Page<T> page, Class<T> entityClass, Object[] params);

	//新增和修改保存
	public <T> void saveOrUpdate(T entity);
	//批量新增和修改保存
	public <T> void saveOrUpdateAll(Collection<T> entitys);

	//单条删除，按id
	public <T> void deleteById(Class<T> entityClass, Serializable id);
	//批量删除
	public <T> void delete(Class<T> entityClass, Serializable[] ids);

}