package cn.edu.hfuu.Accounts_management.domain;

import java.util.Date;

/**
 * Created by 志鹏 on 2016/7/20.
 */
public class User {
    private int Id;
    private String UserName;
    private String UserPsd;
    private Date LastLoginTime;
    public User(){

    }

   public User(int id, String userName, String userPsd, Date lastLoginTime) {
        Id = id;
        UserName = userName;
        UserPsd = userPsd;
        LastLoginTime = lastLoginTime;
    }

    public Date getLastLoginTime() {
        return LastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        LastLoginTime = lastLoginTime;
    }

    public String getUserPsd() {
        return UserPsd;
    }

    public void setUserPsd(String userPsd) {
        UserPsd = userPsd;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
