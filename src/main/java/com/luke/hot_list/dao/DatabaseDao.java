package com.luke.hot_list.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

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

    /**
     * 创建{图鉴}表
     */
    void createTableHandbook();

    /**
     * 创建{日志}表
     */
    void createTableLog();

    void createTableHotList();

    @Insert("insert into log(request_title,request_result,request_args,request_url,request_method,class_name,method_name) " +
            "values(#{requestTitle},#{requestResult},#{requestArgs},#{requestUrl},#{requestMethod},#{className},#{methodName})")
    void insertIntoLog(Map<String, String> log);
}
