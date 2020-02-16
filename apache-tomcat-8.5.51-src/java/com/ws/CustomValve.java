package com.ws;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 自定义一个阀门
 * @author JunWu
 */
public class CustomValve extends ValveBase {

    private String name;

    private int number;

    public CustomValve(){
        System.out.println("自定义阀门实例化");
    }

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session != null){
            Object attribute = session.getAttribute("JSESSIONID");
        }
        String parameter = request.getParameter("jsessionid");
        System.out.println("自定义阀门start");
        getNext().invoke(request,response);
        System.out.println("自定义阀门end");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
