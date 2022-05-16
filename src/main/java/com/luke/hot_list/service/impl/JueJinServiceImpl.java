package com.luke.hot_list.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.luke.hot_list.service.JueJinService;
import com.luke.hot_list.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("jueJinService")
public class JueJinServiceImpl implements JueJinService {
    private static final Logger log = LoggerFactory.getLogger(JueJinServiceImpl.class.getName());

    @Resource
    private RedisUtil redisUtil;

    public static final String BASE_URL = "https://api.juejin.cn";
    public static final String GET_CHECK_STATUS_URL = "/growth_api/v1/get_today_status";
    public static final String CHECK_IN_STATUS_URL = "/growth_api/v1/check_in";

    private String COOKIE;

    private void getCookie() {
        COOKIE = (String) redisUtil.get("juejin_cookie");
    }

    private boolean isCheckIn() {
        getCookie();
        String body = HttpRequest.get(BASE_URL + GET_CHECK_STATUS_URL).cookie(COOKIE).execute().body();
        JSONObject result = JSONObject.parseObject(body);
        String data = result.getString("data");
        return "true".equalsIgnoreCase(data);
    }

    @Override
    public void checkIn() {
        getCookie();
        if (!isCheckIn()) {
            String body = HttpRequest.post(BASE_URL + CHECK_IN_STATUS_URL).cookie(COOKIE).execute().body();
            JSONObject result = JSONObject.parseObject(body);
            String errMsg = result.getString("err_msg");
            if ("success".equalsIgnoreCase(errMsg)) {
                Integer sumPoint = result.getJSONObject("data").getInteger("sum_point");
                log.info("签到成功，时间：{}，总积分：{}", DateUtil.now(),sumPoint);
            }else {
                log.info(DateUtil.now() + " 掘金签到结果: " + body);
            }
        }else{
            log.info(DateUtil.now() + " 掘金已经签到,无需重复签到");
        }
    }
}
