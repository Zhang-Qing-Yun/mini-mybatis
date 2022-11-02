package com.qingyun.mybatis.binding;

import com.qingyun.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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

    public MapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 判断是否为toString、hashCode等方法，它们是不需要被代理的
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        String key = mapperInterface.getName() + "." + method.getName();
        return sqlSession.selectOne(method.getName(), args);
    }
}
