package com.luke.hot_list.dao;

import com.luke.hot_list.entity.Handbook;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface HandbookDao {

    /**
     * 查询是否已经存在同名
     */
    @Select("select count(name) from handbook where name = #{name}")
    int countByName(String name);

    /**
     * 添加
     * @param handbook 图鉴实体类 {@link Handbook}
     */
    @Insert("insert into handbook(name,description,img_url) values(#{name},#{description},#{imgUrl})")
    void save(Handbook handbook);

    /**
     * 根据名字模糊查询 {%name%}
     * @param name 图鉴名称
     * @return 所有符合的图鉴列表
     */
    List<Handbook> findAllLike(String name);

    /**
     * 模糊匹配name中每一个字
     * name = "白色的猫" {%白% or %色% or %的% or %猫%}
     * @param names 图鉴名称数组
     * @return 所有符合的图鉴列表
     */
    List<Handbook> findAllEachLike(List<String> names, List<Integer> ids);
}
