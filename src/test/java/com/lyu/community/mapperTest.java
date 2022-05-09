package com.lyu.community;

import com.lyu.community.dao.DiscussPostMapper;
import com.lyu.community.pojo.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class mapperTest {
    @Autowired
    DiscussPostMapper discussPostMapper;
    @Test
    public void testMapper(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for(DiscussPost dp:discussPosts){
            System.out.println(dp);
        }

        int i = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(i);
    }
}
