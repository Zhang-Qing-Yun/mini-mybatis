package com.qingyun.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @description： 接口代理类的工厂，封装了创建代理类的过程
 * @author: 張青云
 * @create: 2022-10-27 22:32
 **/
public class MapperProxyFactory<T> {
    // 要代理的接口
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    // 封装创建代理类的过程
    public T newInstance(Map<String, String> sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<>(mapperInterface, sqlSession);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);

    }
}
