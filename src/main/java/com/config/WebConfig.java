package com.config;

import com.github.seratch.jslack.Slack;
import com.web.servlets.BotServlet;
import javax.servlet.http.HttpServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> iBotServlet() {
        ServletRegistrationBean<HttpServlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.setServlet(new BotServlet());
        servletServletRegistrationBean.addUrlMappings("/ibot/*");
        servletServletRegistrationBean.setLoadOnStartup(1);
        return servletServletRegistrationBean;
    }

    @Bean
    public Slack slack() {
        return Slack.getInstance();
    }
}
