package com.luke.hot_list.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * 数据库相关
 *
 * @author luke_long
 * @date 2021/12/27 09:43
 */
@Mapper
public interface DatabaseDao {

    /**
     * 创建{知乎}表
     */
    void createTableZhihu();
}
