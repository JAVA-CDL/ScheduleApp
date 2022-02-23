package com.luke.hot_list.service.impl;

import com.luke.hot_list.dao.HandbookDao;
import com.luke.hot_list.entity.Handbook;
import com.luke.hot_list.service.HandbookService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author luke_long
 * @version 1.0
 * @date 2022/2/23 9:44
 */
@Service("handbookService")
public class HandbookServiceImpl implements HandbookService {

    @Resource
    private HandbookDao handbookDao;

    @Override
    public Set<Handbook> findAll(String name) {
        List<Handbook> result = handbookDao.findAllLike(name);
        List<Handbook> eachLikeResult = handbookDao.findAllEachLike(Arrays.asList(name.split("")),
                result.stream().map(Handbook::getId).collect(Collectors.toList()));
        result.addAll(eachLikeResult);
        return new HashSet<>(result);
    }

    @Override
    public void save(Handbook handbook) {
        int count = handbookDao.countByName(handbook.getName());
        if (count < 1) {
            handbookDao.save(handbook);
        }
    }
}
