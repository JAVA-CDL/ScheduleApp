package com.luke.hot_list.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luke.hot_list.dao.ZhihuDao;
import com.luke.hot_list.entity.Zhihu;
import com.luke.hot_list.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author luke_long
 * @version 1.0
 * @date 2021/12/27 10:07
 */
@Service("dataService")
public class DataServiceImpl implements DataService {

    private static final Logger log = LoggerFactory.getLogger(DataServiceImpl.class.getName());

    @Resource
    ZhihuDao zhihuDao;

    public static final String ZHIHU_URL = "https://www.zhihu.com/api/v3/feed/topstory/hot-list-web?limit=50&desktop=true";

    @Override
    public void grabZhihu() {
        String body = HttpRequest.get(ZHIHU_URL).execute().body();
        List<Zhihu> listZhihu = new ArrayList<>();
        JSONArray list = JSONObject.parseObject(body).getJSONArray("data");
        for (int i = 0; i < list.size(); i++) {
            JSONObject item = list.getJSONObject(i);
            Zhihu entity = new Zhihu();
            String url = item.getJSONObject("target").getJSONObject("link").getString("url");
            Optional<Zhihu> oneByUrl = zhihuDao.findOneByUrl(url);
            if (oneByUrl.isPresent()) {
                continue;
            }
            entity.setUrl(url);
            entity.setContent(item.getJSONObject("target").getJSONObject("excerpt_area").getString("text"));
            entity.setGrabDate(DateUtil.now());
            entity.setImageUrl(item.getJSONObject("target").getJSONObject("image_area").getString("url"));
            entity.setTitle(item.getJSONObject("target").getJSONObject("title_area").getString("text"));
            listZhihu.add(entity);
        }
        //入库
        if (listZhihu.size() > 0) {
            int result = zhihuDao.saveAll(listZhihu);
            log.info(DateUtil.now() + "从知乎抓取热榜记录成功,共入库" + result + "条!");
        }
    }

    @Override
    public void cleanOldData() {
        int result = zhihuDao.cleanOldData();
        log.info(DateUtil.now() + "清理旧数据成功,共清理" + result + "条!");
    }


}
