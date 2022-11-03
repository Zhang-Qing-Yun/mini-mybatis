package com.qingyun.mybatis.session.defaults;

import com.qingyun.mybatis.session.Configuration;
import com.qingyun.mybatis.session.SqlSession;
import com.qingyun.mybatis.session.SqlSessionFactory;

/**
 * @description：
 * @author: 張青云
 * @create: 2022-11-02 22:12
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
