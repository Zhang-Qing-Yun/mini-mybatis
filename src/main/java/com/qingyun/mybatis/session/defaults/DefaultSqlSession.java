package com.qingyun.mybatis.session.defaults;

import com.qingyun.mybatis.binding.MapperRegistry;
import com.qingyun.mybatis.session.SqlSession;

/**
 * @description：
 * @author: 張青云
 * @create: 2022-11-02 21:56
 **/
public class DefaultSqlSession implements SqlSession {
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }
}
