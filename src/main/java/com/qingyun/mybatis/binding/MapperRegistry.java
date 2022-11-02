package com.qingyun.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.qingyun.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description： 用于管理接口以及它们对应的代理类工厂
 * @author: 張青云
 * @create: 2022-11-02 21:35
 **/
public class MapperRegistry {
    // Dao接口以及对应的代理类工厂
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    /**
     * 注册DAO接口
     */
    public <T> void addMapper(Class<T> type) {
        if (type.isInterface()) {
            if(hasMapper(type)) {
                throw new RuntimeException(type + "已经注册过了");
            }
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    /**
     * 获取DAO接口对应的代理类对象
     */
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if(mapperProxyFactory == null) {
            throw new RuntimeException(type + "没有注册");
        }
        return mapperProxyFactory.newInstance(sqlSession);
    }

    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }

    /**
     * 扫描包路径并将该路径下的接口进行注册
     */
    public void addMappers(String packName) {
        Set<Class<?>> classSet = ClassScanner.scanPackage(packName);
        for (Class<?> clazz: classSet) {
            addMapper(clazz);
        }
    }
}
