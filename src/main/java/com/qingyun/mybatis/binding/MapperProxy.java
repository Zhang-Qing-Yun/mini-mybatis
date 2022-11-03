package com.qingyun.mybatis.binding;

import com.qingyun.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @description： 代理类，模拟根据接口的方法名执行查数据库并返回结果的过程
 * @author: 張青云
 * @create: 2022-10-27 22:10
 **/
public class MapperProxy<T> implements InvocationHandler {
    // 代理的接口
    private final Class<T> mapperInterface;
    // 接口方法的具体执行过程
    private SqlSession sqlSession;
    // 代理方法对应的执行过程的缓存
    private final Map<Method, MapperMethod> methodCache;

    public MapperProxy(Class<T> mapperInterface, SqlSession sqlSession, Map<Method, MapperMethod> methodCache) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
        this.methodCache = methodCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 判断是否为toString、hashCode等方法，它们是不需要被代理的
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        MapperMethod mapperMethod = cachedMapperMethod(method);
        return mapperMethod.execute(sqlSession, args);
    }

    /**
     * 去缓存中找MapperMethod
     */
    private MapperMethod cachedMapperMethod(Method method) {
        MapperMethod mapperMethod = methodCache.get(method);
        if (mapperMethod == null) {
            //找不到才去new
            mapperMethod = new MapperMethod(mapperInterface, method, sqlSession.getConfiguration());
            methodCache.put(method, mapperMethod);
        }
        return mapperMethod;
    }
}
