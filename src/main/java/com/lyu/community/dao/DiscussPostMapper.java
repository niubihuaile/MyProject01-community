package com.lyu.community.dao;

import com.lyu.community.pojo.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface DiscussPostMapper {
    //查询所有的帖子（加上id则为查询自己的贴子）
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    //查询帖子数量（当方法只有一个参数，且用在了动态sql里，那么就必须加上@param）
    int selectDiscussPostRows(@Param("userId") int userId);
}
