package com.luke.hot_list.utils;

import com.luke.hot_list.dao.DatabaseDao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author luke_long
 * @version 1.0
 * @date 2021/12/27 9:37
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Resource
    private DatabaseDao databaseDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //启动之后,若数据库不存在,创建数据库
        databaseDao.createTableZhihu();
        databaseDao.createTableHandbook();
        databaseDao.createTableLog();
    }
}
