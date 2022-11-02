package com.qingyun.mybatis.session;

/**
 * @description： 构建SqlSession的工厂
 * @author: 張青云
 * @create: 2022-11-02 22:12
 **/
public interface SqlSessionFactory {
    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();
}
