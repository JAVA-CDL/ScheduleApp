package com.luke.hot_list.service;

import com.luke.hot_list.entity.Handbook;

import java.util.List;

public interface HandbookService {

    List<Handbook> findAll(String name);

    void save(Handbook handbook);
}
