package cn.edu.hfuu.Accounts_management.controller;

import cn.edu.hfuu.Accounts_management.IUserDao;
import cn.edu.hfuu.Accounts_management.IUserService;
import cn.edu.hfuu.Accounts_management.request.LoginRequest;
import cn.edu.hfuu.Accounts_management.response.LoginResponse;
import cn.edu.hfuu.Accounts_management.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by 志鹏 on 2016/8/1.
 */
@Controller
public class MainController  extends BaseController{



    @Autowired
    IUserService iUserService;
    @Autowired
    IUserDao iUserDao;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login1(@ModelAttribute("loginRequest") LoginRequest loginRequest) {
        return "login";
    }

    @RequestMapping(value = "/login123")
    @ResponseBody
    public Object login(HttpSession httpSession, LoginRequest req) {
        Response rsp = new Response();
        String userName = req.getUserName();
        String userPsd = req.getUserPsd();

     /*   if(httpSession.getAttribute(userName)!=null){
            httpSession.setAttribute("userName",null);
        }
    */

        //判断用户名是否为空
        if (StringUtils.isEmpty(userName)) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setSuccess(false);
            loginResponse.setInfo("user name is not allowed empty");
            rsp.setData(loginResponse);
        } else {
            String Psd = iUserService.queryUserByUserName(userName);
            if ((Psd != null) && (Psd.equalsIgnoreCase(userPsd))) {

                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setSuccess(true);
                loginResponse.setInfo("success");
                //设置session
                //  request.getSession().setAttribute("sessionUser",userName);
                httpSession.setAttribute("userName",userName);

                rsp.setData(loginResponse);
            }
            else if ((Psd != null) && (!Psd.equalsIgnoreCase(userPsd))) {
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setSuccess(false);
                loginResponse.setInfo("用户密码不正确");
                rsp.setData(loginResponse);
            } else {

                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setSuccess(false);
                loginResponse.setInfo("用户不存在");
                rsp.setData(loginResponse);
            }
        }
        return rsp;
    }


    @RequestMapping("index")
    public  String index(HttpSession httpSession,@ModelAttribute("loginRequest") LoginRequest loginRequest){
        Object s=httpSession.getAttribute("userName");
       // String s=getSessionUserName();
        System.out.println("session1"+s);
        return "index";
    }
    @RequestMapping("index1")
     @ResponseBody
    //通过request得到js中的数，response返回js所要需要的数
   public Object index1(HttpSession httpSession,HttpServletRequest request,LoginRequest req){
        Object s=httpSession.getAttribute("userName");
        System.out.println("session2"+s);

        Response rsp = new Response();
        int offset= req.getOffset();
        int limit=req.getLimit();
        String userName = req.getUserName();
        String PSd=req.getUserPsd();

         List<Map<Object,Object>> listmap=iUserDao.selectalluser(offset,limit);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setSuccess(true);
        loginResponse.setMap(listmap);
        rsp.setData(loginResponse);

        return  rsp;

    }



}
