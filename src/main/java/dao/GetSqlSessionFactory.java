package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import service.AppUserService;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by liupeng on 16/3/4.
 */
public class GetSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory = null;

    private static GetSqlSessionFactory getSqlSessionFactory = null;

    private GetSqlSessionFactory()
    {
        String rs = "mybatis-config.xml";
        Reader reader = null;
        try
        {
            reader = Resources.getResourceAsReader(rs);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 注解方式查询时需要注册mapper
        sqlSessionFactory.getConfiguration().addMapper(AppUserService.class);
    }

    public static GetSqlSessionFactory getInstance()
    {
        if (getSqlSessionFactory == null)
            getSqlSessionFactory = new GetSqlSessionFactory();
        return getSqlSessionFactory;
    }

    public static SqlSessionFactory getSqlSessionFactory()
    {
        return sqlSessionFactory;
    }



}
