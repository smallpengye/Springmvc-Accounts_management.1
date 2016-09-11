package cn.edu.hfuu.Accounts_management.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 志鹏 on 2016/8/2.
 */
public abstract class BaseController {

    /**
     * Servlet APIs。
     */
    private ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
    private ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();


    String getSessionUserName(){
        Object obj =  getRequest().getSession().getAttribute("sessionUser");
        if(obj == null){
            return null;
        }
        return (String) obj;
    }

    /**
     * 获取 请求对象。
     */
    protected HttpServletRequest getRequest() {
        return this.request.get();
    }

    /**
     * 获取响应对象。
     */
    protected HttpServletResponse getResponse() {
        return this.response.get();
    }
    /**
     * 设置Servlet APIs
     */
    @ModelAttribute
    private void setServletAPIs(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        this.request.set(request);
        this.response.set(response);
    }
    }
