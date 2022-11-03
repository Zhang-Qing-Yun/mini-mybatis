package com.qingyun.mybatis.session;

import com.qingyun.mybatis.builder.xml.XMLConfigBuilder;
import com.qingyun.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @description： 构建SqlSessionFactory的工厂
 * @author: 張青云
 * @create: 2022-11-03 21:37
 **/
public class SqlSessionFactoryBuilder {
    /**
     * 根据XML文件的流创建SqlSessionFactory
     * @param reader XML文件的流
     */
    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
