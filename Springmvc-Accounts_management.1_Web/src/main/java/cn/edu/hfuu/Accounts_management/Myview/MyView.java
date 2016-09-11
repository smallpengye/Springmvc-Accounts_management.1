package cn.edu.hfuu.Accounts_management.Myview;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

/**
 * Created by 志鹏 on 2016/7/28.
 * 该类用来判断返回的view值用什么view匹配器来匹配
 */
public class MyView extends InternalResourceView {

    public boolean checkResource(Locale locale) throws Exception {
        File file = new File(this.getServletContext().getRealPath("/")+getUrl());
        return file.exists();//判断该jsp页面是否存在
    }

}
