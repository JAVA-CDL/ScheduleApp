package com.luke.hot_list.controller;

import com.luke.hot_list.annotation.Log;
import com.luke.hot_list.entity.Handbook;
import com.luke.hot_list.service.HandbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luke_long
 * @version 1.0
 * @date 2022/2/23 9:22
 */
@RestController
@CrossOrigin
@RequestMapping("/handbook")
public class HandbookController {

    @Resource
    private HandbookService handbookService;

    @Log(title = "根据图鉴名称模糊查询图鉴")
    @GetMapping("/findAll/{name}")
    public List<Handbook> findAll(@PathVariable(name = "name") String name) {
        return handbookService.findAll(name);
    }

    @Log(title = "保存图鉴")
    @PostMapping("/save")
    public void save(@RequestBody Handbook handbook) {
        handbookService.save(handbook);
    }

}
