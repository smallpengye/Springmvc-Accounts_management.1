package cn.edu.hfuu.Accounts_management;


import cn.edu.hfuu.Accounts_management.domain.User;

import java.util.Date;

/**
 * Created by 志鹏 on 2016/7/28.
 */
public interface IUserService {

    //查询用户是否存在，存在返回true
    boolean  checkname(String name);


    String queryUserByUserName(String name);
    void   UpDataTime(String name, Date date);
    void    RegisterUser(User user);

}