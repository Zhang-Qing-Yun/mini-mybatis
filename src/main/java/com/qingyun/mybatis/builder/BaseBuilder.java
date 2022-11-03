package com.qingyun.mybatis.builder;

import com.qingyun.mybatis.session.Configuration;

/**
 * @description：
 * @author: 張青云
 * @create: 2022-11-03 20:26
 **/
public abstract class BaseBuilder {
    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
