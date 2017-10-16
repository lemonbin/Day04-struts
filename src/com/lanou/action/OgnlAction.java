package com.lanou.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 2017/10/13.
 */
public class OgnlAction extends ActionSupport {

    private String username;
    private String password;

    @Override
    public String execute() throws Exception {
        System.out.println(username + ", " + password);

        // 获取当前请求对象的值栈 (list结构)
        ValueStack valueStack = ServletActionContext.getValueStack(ServletActionContext.getRequest());

        // 往Request中的attr的map集合中存储数据
        ServletActionContext.getRequest().setAttribute("request_username", "请求域中的属性");

        // 往Application中的map集合中存储数据
        ActionContext.getContext().getApplication().put("application_username", "application对应的map集合中的数据存储");

        // 往Session中的map集合中存储数据
        ActionContext.getContext().getSession().put("session_username", "session对应的map集合中的数据存储");

        // 往Parameters中的attr的map集合中存储数据
        // Parameters的集合中不能修改参数, 往里面添加数据时不报错
        // 但是取不到添加的数据, 原因是一个请求的参数只能在第一次提交时设置
        // 以后均不可修改
        ActionContext.getContext().getParameters().put("parameter_username", "parameter对应的map集合中的数据存储");


        //往request, session, application集合中加入同样名字的属性
        ServletActionContext.getRequest().setAttribute("name", "request中的name");
        ServletActionContext.getRequest().getSession().setAttribute("name", "session中的name");
        ServletActionContext.getServletContext().setAttribute("name", "application中的name");
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
