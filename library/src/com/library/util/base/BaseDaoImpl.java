package com.library.util.base;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.library.dao.bean.Book;
import com.library.dao.bean.BookStudent;
import com.library.dao.bean.Collect;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.BookTypeDaoImpl;
import com.library.dao.impl.CollectDaoImpl;
import com.library.util.DateUtils;
import com.library.util.hibernate.HibernateUtils;

public class BaseDaoImpl<T> implements BaseDao<T> {
	// 存储泛型的实际参数
	private Class<T> clazz;

	public BaseDaoImpl() {
		// 谁实现该类，这就是谁的类字节码
		Class c = this.getClass();
		// 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
		Type type = c.getGenericSuperclass();
		// 将类型强转为参数化类型
		ParameterizedType pType = (ParameterizedType) type;
		// 获取该类的父类的所有实际类型参数，也就是泛型的实际参数
		// 这里也就是获取BaseDaoImpl的实际类型参数
		Type[] actualTypeArguments = pType.getActualTypeArguments();
		// 将实际类型参数赋值给成员变量
		clazz = (Class<T>) (actualTypeArguments[0]);
	}

	/**
	 * 	保存
	 */
	public void save(T bean) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();			// 获取会话
			tx = session.beginTransaction();					// 开启事务

			// 初始化创建/更新时间 & 删除标记
			Method method1 = bean.getClass().getMethod("setCdate", Date.class);
			method1.invoke(bean, new Date());
			Method method2 = bean.getClass().getMethod("setYn", int.class);
			method2.invoke(bean, 1);

			if("Bespeak".equals(this.clazz.getSimpleName()) || "BookStudent".equals(this.clazz.getSimpleName())) {
				Method method = bean.getClass().getMethod("getId", null);
				int value = (Integer) method.invoke(bean, null);
				if(value == 0) {
					Method method3 = bean.getClass().getMethod("setId", int.class);
					method3.invoke(bean, DateUtils.getId());
				}
			}
			
			// 保存
	              session.save(bean);
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}

	/**
	 * 	删除（逻辑删除）
	 */
	public synchronized void delete(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();

			// 标记为删除状态 &　更新修改时间
			Object bean = session.get(this.clazz, id);
			if(bean == null)
				return;
			Method method = bean.getClass().getMethod("setYn", int.class);
			method.invoke(bean, 0);
			Method method2 = bean.getClass().getMethod("setUdate", Date.class);
			method2.invoke(bean, new Date());

			// 逻辑删除
			session.update(bean);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}
	
	/**
	 * 	删除（物理删除）
	 */
	public synchronized void deleteTrue(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();

			Object bean = session.get(this.clazz, id);
			if(bean == null)
				return;
			session.delete(bean);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}
	
	/**
	 * 	删除（逻辑删除）
	 */
	public synchronized void delete(T bean) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			
			// 标记为删除状态 &　更新修改时间
			Method method = bean.getClass().getMethod("setYn", int.class);
			method.invoke(bean, 0);
			Method method2 = bean.getClass().getMethod("setUdate", Date.class);
			method2.invoke(bean, new Date());

			// 逻辑删除
			session.update(bean);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}
	
	/**
	 * 	删除（物理删除）
	 */
	public synchronized void deleteTrue(T bean) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			
			if(bean == null)
				return;
			session.delete(bean);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}

	/**
	 * 	更新
	 */
	public synchronized void update(T bean) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();

			// 更新修改时间
			Method method = bean.getClass().getMethod("setUdate", Date.class);
			method.invoke(bean, new Date());

			// 更新
			session.update(bean);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}

	/**
	 * 	查询
	 */
	public T get(int id) {
		Session session = null;
		T t = null;
		try {
			session = HibernateUtils.getSession();

			// 查询
			t = (T) session.get(this.clazz, id);
			
			if(t == null)
				return null;
			
			// 查看标记状态是否为删除
			Method method = t.getClass().getMethod("getYn", null);
			int value = (Integer) method.invoke(t, null);
			
//			 若是删除状态则 " 查不到 "
			if (value == 0)
				t = null;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return t;
	}

	/**
	 * 	查询全部
	 */
	public List<T> list() {
		Session session = null;
		
		List<T> list = null;
		try {
			session = HibernateUtils.getSession();

			// 查询全部 & 过滤掉删除状态的数据
			list = session.createCriteria(this.clazz).add(Restrictions.eq("yn", 1)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * 	分页查询
	 */
	public List<T> list(int index, int count) {
		Session session = null;
		
		List<T> list = null;
		try {
			session = HibernateUtils.getSession();
			
			// 查询全部 & 过滤掉删除状态的数据
			Criteria c = session.createCriteria(this.clazz).add(Restrictions.eq("yn", 1));
			
			// 取某部分数据
			c.setFirstResult(index);
			c.setMaxResults(count);
			list = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	/**
	 * 	查询数量
	 */
	public int getCount() {
		Session session = null;
		
		int count = 0;
		try {
			session = HibernateUtils.getSession();

			Criteria cr = session.createCriteria(this.clazz).add(Restrictions.eq("yn", 1));
			
			if(cr.list() != null && cr.list().size() >= 1)
				count = cr.list().size();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
}
