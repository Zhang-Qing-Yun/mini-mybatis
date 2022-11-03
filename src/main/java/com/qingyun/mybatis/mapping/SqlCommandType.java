package com.qingyun.mybatis.mapping;

/**
 * @description： sql类型
 * @author: 張青云
 * @create: 2022-11-03 14:45
 **/
public enum SqlCommandType {

    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;

}
