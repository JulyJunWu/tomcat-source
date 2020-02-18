package com.ws;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * 自定义Servlet
 * @author JunWu
 */
public class CustomServlet extends HttpServlet {

    private static final String MESSAGE = "访问成功";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handle(req,resp);
    }

    private void handle(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        Object jsessionid = session.getAttribute("JSESSIONID");
        ServletContext servletContext = request.getServletContext();
        try{
            if (Objects.nonNull(jsessionid)){
                servletContext.log(jsessionid.toString());
            }
            response.setContentType("application/json;charset=UTF-8");
            ServletOutputStream outputStream = response.getOutputStream();

            outputStream.write(MESSAGE.getBytes(Charset.defaultCharset()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
