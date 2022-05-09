package com.lyu.community.service;

import com.lyu.community.dao.DiscussPostMapper;
import com.lyu.community.pojo.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;
    //查询帖子
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit){
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }
    //查询行数
    public int selectDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
