package com.qingyun.mybatis.mapping;

import com.qingyun.mybatis.session.Configuration;
import lombok.Data;

import java.util.Map;

/**
 * @description：
 * @author: 張青云
 * @create: 2022-11-03 14:50
 **/
@Data
public class MappedStatement {
    private Configuration configuration;
    private String id;
    private SqlCommandType sqlCommandType;

    private String parameterType;
    private String resultType;
    private String sql;
    private Map<Integer, String> parameter;

    public MappedStatement(Configuration configuration, String id, SqlCommandType sqlCommandType, String parameterType, String resultType, String sql, Map<Integer, String> parameter) {
        this.configuration = configuration;
        this.id = id;
        this.sqlCommandType = sqlCommandType;
        this.parameterType = parameterType;
        this.resultType = resultType;
        this.sql = sql;
        this.parameter = parameter;
    }
}
