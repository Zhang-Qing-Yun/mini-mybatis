package com.qingyun.mybatis.test;

import com.qingyun.mybatis.binding.MapperRegistry;
import com.qingyun.mybatis.io.Resources;
import com.qingyun.mybatis.session.SqlSession;
import com.qingyun.mybatis.session.SqlSessionFactory;
import com.qingyun.mybatis.session.SqlSessionFactoryBuilder;
import com.qingyun.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.qingyun.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @description：
 * @author: 張青云
 * @create: 2022-10-27 22:46
 **/
public class APITest {
    private Logger logger = LoggerFactory.getLogger(APITest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);
    }
}
