package com.lyu.community.dao;

import com.lyu.community.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    //通过id查询
    User selectById(int id);
    //通过name查询
    User selectByName(String username);
    //通过邮箱查询
    User selectByEmail(String email);
    //增加用户
    int insertUser(User user);
    //更新状态
    int updateStatus(int id,int status);
    //更新头像
    int updateHeader(int id,String headerUrl);
    //修改密码
    int updatePassword(int id,String password);
}
