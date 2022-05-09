package com.lyu.community.controller;

import com.lyu.community.pojo.DiscussPost;
import com.lyu.community.pojo.Page;
import com.lyu.community.pojo.User;
import com.lyu.community.service.DiscussPostService;
import com.lyu.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index" , method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //方法调用前，SpringMVC会自动实例化Model和Page，并将Page注入到Model中，因此我们不用手动将Page存到Model里

        //给分页组件存入总人数
        page.setRows(discussPostService.selectDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());

        List<Map<String,Object>> discussPost=new ArrayList<>();
        if(list!=null){
            for(DiscussPost dp:list){
                Map<String,Object> map=new HashMap<>();
                map.put("post",dp);
                User user = userService.findUserById(dp.getUserId());
                map.put("user",user);
                discussPost.add(map);
            }
        }
        model.addAttribute("discussPost",discussPost);
        return "index";
    }
}
