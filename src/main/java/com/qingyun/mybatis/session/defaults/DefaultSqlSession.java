package com.qingyun.mybatis.session.defaults;

import com.qingyun.mybatis.mapping.MappedStatement;
import com.qingyun.mybatis.session.Configuration;
import com.qingyun.mybatis.session.SqlSession;

/**
 * @description：
 * @author: 張青云
 * @create: 2022-11-02 21:56
 **/
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }
}
