package com.ws;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;
import java.util.Set;

import static javax.servlet.DispatcherType.REQUEST;

/**
 * 实现 ServletContainerInitializer接口
 * 创建文件webapps/ROOT/WEB-INF/classes/META-INF/services/javax.servlet.ServletContainerInitializer,
 * 保证能被扫描解析
 * @author JunWu
 */
public class CustomServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        // 加载Filter到context容纳器
        FilterRegistration.Dynamic dynamic = ctx.addFilter("customFilter", new CustomFilter());
        // 添加过滤器对应的映射,匹配规则
        dynamic.addMappingForUrlPatterns(EnumSet.of(REQUEST),true,"*");
    }
}
