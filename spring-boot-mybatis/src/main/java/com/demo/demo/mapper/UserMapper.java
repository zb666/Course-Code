package com.demo.demo.mapper;

import com.demo.demo.entity.UserTestBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//动态代理生成了这个类
@Repository
public interface UserMapper {

    int insertUser(UserTestBean userTestBean);

    int insertUserParam(
            @Param("userName") String userName,
            @Param("userAge") Integer userAge,
            @Param("userTime") Date userTime);

    List<UserTestBean> findUserById(@Param(value = "roleId") int roleId);
}
