package com.config;

import com.github.seratch.jslack.Slack;
import com.web.servlets.IBotServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

@Configuration
public class WebConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> iBotServlet() {
        ServletRegistrationBean<HttpServlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.setServlet(new IBotServlet());
        servletServletRegistrationBean.addUrlMappings("/ibot/*");
        servletServletRegistrationBean.setLoadOnStartup(1);
        return servletServletRegistrationBean;
    }

    @Bean
    public Slack slack() {
        return Slack.getInstance();
    }
}
