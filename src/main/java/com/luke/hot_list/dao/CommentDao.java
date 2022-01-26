package com.luke.hot_list.dao;

import com.luke.hot_list.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentDao {

    @Insert("insert into comment(user,content,create_time) values(#{user},#{content},#{createTime})")
    int save(Comment comment);

    @Select("select * from comment order by create_time desc")
    List<Comment> getAll();
}
