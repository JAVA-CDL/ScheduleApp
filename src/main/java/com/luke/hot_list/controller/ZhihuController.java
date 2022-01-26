package com.luke.hot_list.controller;

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

    @GetMapping("/getAll")
    public List<Zhihu> getAll() {
        return zhihuDao.getAll();
    }

    @PostMapping("/view/{url}")
    public void view(@PathVariable(name = "url") String url) {
        String baseUrl = "https://www.zhihu.com/question/";
        zhihuDao.view(baseUrl+url);
    }
}
