package com.luke.hot_list.service;

import com.luke.hot_list.entity.Handbook;

import java.util.Set;

public interface HandbookService {

    Set<Handbook> findAll(String name);

    void save(Handbook handbook);
}
