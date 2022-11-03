package com.qingyun.mybatis.binding;

import com.qingyun.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description： 创建接口代理类对象的工厂，封装了创建代理类的过程
 * @author: 張青云
 * @create: 2022-10-27 22:32
 **/
public class MapperProxyFactory<T> {
    // 要代理的接口
    private final Class<T> mapperInterface;
    // 要代理的方法的缓存
    private Map<Method, MapperMethod> methodCache = new ConcurrentHashMap<>();

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    // 封装创建代理类的过程
    public T newInstance(SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<>(mapperInterface, sqlSession, methodCache);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

    public Map<Method, MapperMethod> getMethodCache() {
        return methodCache;
    }
}
