package com.luke.hot_list.service.impl;

import cn.hutool.http.HttpRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luke.hot_list.service.DataService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author luke_long
 * @version 1.0
 * @date 2021/12/27 10:07
 */
@Service("dataService")
public class DataServiceImpl implements DataService {

    public static final String ZHIHU_URL = "https://www.zhihu.com/api/v3/feed/topstory/hot-list-web?limit=50&desktop=true";

    @Override
    public void grabZhihu() throws JsonProcessingException {
        String body = HttpRequest.get(ZHIHU_URL).execute().body();
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.readValue(body, Map.class);
        System.out.println(map);
    }
}
