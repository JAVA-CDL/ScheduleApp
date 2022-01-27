package com.luke.hot_list.service;

/**
 * 数据相关service
 *
 * @author luke_long
 * @date 2021/12/27 10:06
 */
public interface DataService {

    /**
     * 抓取知乎热门
     */
    void grabZhihu();

    /**
     * 删除已经tag为1的记录
     */
    void cleanOldData();
}
