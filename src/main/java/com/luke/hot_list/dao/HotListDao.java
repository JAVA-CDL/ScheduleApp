package com.luke.hot_list.dao;

import com.luke.hot_list.entity.HotList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface HotListDao {

    @Select("select link from hot_list where link = #{link} limit 1")
    Optional<HotList> findOneByUrl(String link);

    int saveAll(List<HotList> list);
}
