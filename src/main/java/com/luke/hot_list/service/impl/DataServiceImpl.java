package com.luke.hot_list.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luke.hot_list.dao.HotListDao;
import com.luke.hot_list.dao.ZhihuDao;
import com.luke.hot_list.entity.HotList;
import com.luke.hot_list.entity.Zhihu;
import com.luke.hot_list.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    @Resource
    HotListDao hotListDao;

    public static final String ZHIHU_URL = "https://www.zhihu.com/api/v3/feed/topstory/hot-list-web?limit=50&desktop=true";
    public static final String HOST_LIST_URL = "https://api.codelife.cc/api/top/list";
    public static final String HOST_LIST_SIGNATUREKEY = "U2FsdGVkX18gzYBgCdsS45SWgI4EJsSFvkjeTpgYM0U=";

    @Override
    public void grabZhihu() {
        String body = HttpRequest.get(ZHIHU_URL).execute().body();
        List<Zhihu> listZhihu = new ArrayList<>();
        JSONArray list = JSONObject.parseObject(body).getJSONArray("data");
        for (int i = 0; i < list.size(); i++) {
            JSONObject item = list.getJSONObject(i);
            Zhihu entity = new Zhihu();
            String url = item.getJSONObject("target").getJSONObject("link").getString("url");
            if (!url.startsWith("https://www.zhihu.com/question/")) {
                continue;
            }
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
    public void grabHotList() {
        List<HotList> list = new ArrayList<>();
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("微博", "{\"id\":\"KqndgxeLl9\"}");
        requestBody.put("知乎", "{\"id\":\"mproPpoq6O\"}");
        requestBody.put("微信", "{\"id\":\"WnBe01o371\"}");
        requestBody.put("百度", "{\"id\":\"Jb0vmloB1G\"}");
        requestBody.put("少数派", "{\"id\":\"Y2KeDGQdNP\"}");
        requestBody.put("IT之家", "{\"id\":\"74Kvx59dkx\"}");
        requestBody.put("哔哩哔哩", "{\"id\":\"74KvxwokxM\"}");
        requestBody.put("掘金", "{\"id\":\"QaqeEaVe9R\"}");
        requestBody.put("百度贴吧", "{\"id\":\"Om4ejxvxEN\"}");
        for (Map.Entry<String, String> entry : requestBody.entrySet()) {
            String body = HttpRequest.post(HOST_LIST_URL).header("signaturekey",HOST_LIST_SIGNATUREKEY).body(entry.getValue()).execute().body();
            JSONObject bodyJSON = JSONObject.parseObject(body);
            if (200 == bodyJSON.getInteger("code")) {
                JSONArray data = bodyJSON.getJSONArray("data");
                for (int i = 0; i < data.size(); i++) {
                    JSONObject item = data.getJSONObject(i);
                    String link = item.getString("link");
                    Optional<HotList> oneByUrl = hotListDao.findOneByUrl(link);
                    if (!oneByUrl.isPresent()) {
                        HotList hotList = new HotList();
                        hotList.setTitle(filterEmoji(item.getString("title")));
                        hotList.setLink(link);
                        hotList.setHotValue(item.getString("hotValue"));
                        hotList.setGrabDate(new Date());
                        hotList.setType(entry.getKey());
                        list.add(hotList);
                    }
                }
            }
        }
        hotListDao.saveAll(list);
    }

    @Override
    public void cleanOldData() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        String date = DateUtil.format(calendar.getTime(),"yyyy-MM-dd");
        int result = zhihuDao.cleanOldData(date);
        log.info(DateUtil.now() + "清理旧数据成功,共清理" + result + "条!");
    }

    private String filterEmoji(String source) {
        if(source != null) {
            Pattern emoji = Pattern.compile ("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE ) ;
            Matcher emojiMatcher = emoji.matcher(source);
            if ( emojiMatcher.find()) {
                source = emojiMatcher.replaceAll("*");
                return source ;
            }
            return source;
        }
        return null;
    }
}
