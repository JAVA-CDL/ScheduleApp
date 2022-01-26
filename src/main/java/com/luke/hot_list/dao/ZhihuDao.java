package com.luke.hot_list.dao;

import com.luke.hot_list.entity.Zhihu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

/**
 * 知乎
 * @author luke_long
 * @date 2021/12/27 11:16
 */
@Mapper
public interface ZhihuDao {

    /**
     * 根据url查找一个,用户判断是否已经存在
     *
     * @param url url
     * @return {@link Optional}<{@link Zhihu}>
     */
    @Select("select url from zhihu where url = #{url} limit 1")
    Optional<Zhihu> findOneByUrl(String url);

    /**
     * 保存所有
     *
     * @param list 列表
     * @return int
     */
    int saveAll(List<Zhihu> list);

    @Select("select * from zhihu where (tag is null or tag = 0) order by grab_date desc limit 20")
    List<Zhihu> getAll();

    @Update("update zhihu set tag = 1 where url = #{url}")
    void view(String url);
}
