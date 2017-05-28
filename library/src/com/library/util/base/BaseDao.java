package com.library.util.base;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 	保存
	 * @param bean 保存的对象
	 */
	public void save(T bean);
	
	/**
	 * 	删除
	 * @param id 删除对象的主键值
	 */
	public void delete(int id);
	
	/**
	 * 	删除
	 * @param bean 删除的对象
	 */
	public void delete(T bean);

	/**
	 * 	更新
	 * @param bean 更新的对象
	 */
	public void update(T bean);

	/**
	 * 	查询
	 * @param id 主键值
	 * @return 对象
	 */
	public T get(int id);
	
	/**
	 * 	查询全部
	 * @return 全部对象的List集合
	 */
	public List<T> list();

	/**
	 * 	分页查询
	 * @param index 开始
	 * @param count 数量
	 * @return 某个区域的数据
	 */
	public List<T> list(int index, int count);

	/**
	 * 	查询数据数量
	 * @return
	 */
	public int getCount();
}
