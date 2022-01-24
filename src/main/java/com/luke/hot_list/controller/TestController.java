package com.luke.hot_list.controller;

import com.luke.hot_list.service.DataService;
import com.luke.hot_list.service.JueJinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author luke_long
 * @version 1.0
 * @date 2021/12/27 10:05
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test success";
    }
}
