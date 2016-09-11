package cn.edu.hfuu.Accounts_management.imp;

import cn.edu.hfuu.Accounts_management.IUserDao;
import cn.edu.hfuu.Accounts_management.domain.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by ־�� on 2016/7/28.
 */
@Component
public class UserImp implements IUserDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;


      //ͨ���û������û������ظ��û�
    public User queryUser(String name){
        if(this.sqlSession == null) {
            this.sqlSession  = sqlSessionFactory.openSession();
        }
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("UserName",name);
        return sqlSession.selectOne("mappers.selectByName",param);

    }
    //��ѯ���û����Ƿ����
    public boolean queryUsername(Object name){
        if(this.sqlSession == null) {
            this.sqlSession  = sqlSessionFactory.openSession();
        }
        System.out.print("UserImp"+name);
       // Map<String,Object> param = new HashMap<String, Object>();
        //param.put("UserName",name);
        //�鵽 ,��Ϊ������ڸ��û�
        User user = null;
        try{
            Map<String,Object> params = new HashMap<String, Object>();
            params.put("UserName",name);
             user=sqlSession.selectOne("mappers.selectusername",params);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.print("       "+user);
          if(sqlSession.selectOne("mappers.selectusername",name)!=null) {

          return  true;

       }else{

            System.out.print("û�鵽user"+sqlSession.selectOne("mappers.selectusername",name));
            return false;
        }
    }

    public void insertUser(User user) {
        if(this.sqlSession == null) {
            this.sqlSession  = sqlSessionFactory.openSession();
        }

        Map<String,Object> params = new HashMap<String, Object>();
        params.put("userName",user.getUserName());
        params.put("userPsd",user.getUserPsd());
        sqlSession.insert("mappers.InsertUser",params);

    }


    public void upDataTime(String name,Date data) {
        System.out.print("=====data=="+data);
        SqlSession session=sqlSessionFactory.openSession();
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("lastlogintime",data);
        params.put("userName",name);
        session.update("mappers.UpdataTime",params);

    }
    public List<Map<Object, Object>> selectalluser(int offset,int limit){
        SqlSession session=sqlSessionFactory.openSession();

        List< Map<Object,Object>> listmap = new ArrayList<Map<Object, Object>>();
          //offset��ʼλ�ã�limitÿҳ����
         RowBounds rowBounds=new RowBounds(offset,limit);

         listmap  =   session.selectList("mappers.selectalluser",null,rowBounds);
        return listmap;
    }


    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }


}