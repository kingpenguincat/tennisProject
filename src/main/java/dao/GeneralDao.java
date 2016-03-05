package dao;

import java.util.Map;

public interface GeneralDao {
	/**
	 * 新增
	 * @param sql
	 * @param obj
	 * @return
	 */
	public Object add(String sql, Object obj) throws Exception;
	
	/**
	 * 修改对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object update(String str, Object obj) throws Exception;
	
	/**
	 * 删除对象 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object delete(String str, Object obj) throws Exception;
	
	
	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForObject(String str, Object obj) throws Exception;

	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForList(String str, Object obj) throws Exception;
	
	/**
	 * 分页查询
	 * @param str
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object findPage(String str, Map map) throws Exception;
	
	/**
	 * 分页查询总数
	 * @param str
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Object findPageCount(String str, Map map) throws Exception;
	
}
