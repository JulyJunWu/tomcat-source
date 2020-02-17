package com.ws;

import org.apache.catalina.filters.FilterBase;
import org.apache.juli.logging.Log;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 自定义Filter
 * @author JunWu
 */
public class CustomFilter extends FilterBase {
    @Override
    protected Log getLogger() {
        return null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
    }
}
