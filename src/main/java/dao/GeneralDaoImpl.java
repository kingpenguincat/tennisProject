package dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class GeneralDaoImpl implements GeneralDao {

	// 注入sqlSessionTemplate模版
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	//增

	public Object add(String str, Object obj) throws Exception {
		return sqlSessionTemplate.insert(str, obj);
	}

	//改

	public Object update(String str, Object obj) throws Exception {
		return sqlSessionTemplate.update(str, obj);
	}

	//删

	public Object delete(String str, Object obj) throws Exception {
		return sqlSessionTemplate.delete(str, obj);
	}

	//查询一个

	public Object findForObject(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectOne(str, obj);
	}

	//查询一组

	public Object findForList(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}

	//分页查询

	public Object findPage(String str, Map map) throws Exception {
		return sqlSessionTemplate.selectList(str, map);
	}

	//分页查询总记录数

	public Object findPageCount(String str, Map map) throws Exception {
		return sqlSessionTemplate.selectOne(str, map);
	}

}
