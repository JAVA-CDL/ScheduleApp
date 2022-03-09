package com.luke.hot_list.controller;

import com.luke.hot_list.annotation.Log;
import com.luke.hot_list.dao.ZhihuDao;
import com.luke.hot_list.entity.Zhihu;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/zhihu")
public class ZhihuController {

    @Resource
    private ZhihuDao zhihuDao;

    @Log(title = "获取所有知乎列表")
    @GetMapping("/getAll")
    public List<Zhihu> getAll() {
        return zhihuDao.getAll();
    }

    @Log(title = "查看/忽略一条知乎记录")
    @PostMapping("/view/{url}")
    public void view(@PathVariable(name = "url") String url) {
        String baseUrl = "https://www.zhihu.com/question/";
        zhihuDao.view(baseUrl+url);
    }

    @Log(title = "忽略本也所有知乎记录")
    @PostMapping("/viewAll")
    public void viewAll(@RequestBody List<String> urls){
        String[] urlArray = new String[urls.size()];
        zhihuDao.view(urls.toArray(urlArray));
    }
}
