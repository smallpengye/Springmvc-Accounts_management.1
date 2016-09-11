package cn.edu.hfuu.Accounts_management;

import cn.edu.hfuu.Accounts_management.domain.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 志鹏 on 2016/7/28.
 */
public interface IUserDao {

    User queryUser(String name);

    void insertUser(User user);

    void upDataTime(String name, Date data);
    boolean queryUsername(Object userName);
    List<Map<Object, Object>> selectalluser(int offset,int limit);

}
