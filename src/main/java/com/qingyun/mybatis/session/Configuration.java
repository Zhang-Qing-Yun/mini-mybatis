package com.qingyun.mybatis.session;

import com.qingyun.mybatis.binding.MapperRegistry;
import com.qingyun.mybatis.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;

/**
 * @description： 配置项
 * @author: 張青云
 * @create: 2022-11-03 14:49
 **/
public class Configuration {
    protected MapperRegistry mapperRegistry;

    // 管理SQl语句
    protected final Map<String, MappedStatement> mappedStatements;

    public Configuration() {
        this.mapperRegistry = new MapperRegistry(this);
        this.mappedStatements = new HashMap<>();
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }
}
