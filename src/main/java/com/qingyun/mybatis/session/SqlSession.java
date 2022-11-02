package com.qingyun.mybatis.session;

/**
 * @description： 用来执行SQL，获取映射器，管理事务等
 * @author: 張青云
 * @create: 2022-11-02 21:53
 **/
public interface SqlSession {
    /**
     * 获取DAO接口对应的代理类对象
     * @param type DAO接口
     */
    <T> T getMapper(Class<T> type);

    /**
     * 根据指定的SqlID获取数据库一条记录的封装对象
     */
    <T> T selectOne(String statement, Object parameter);
}
