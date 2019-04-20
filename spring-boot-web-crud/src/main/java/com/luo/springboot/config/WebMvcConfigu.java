package com.luo.springboot.config;

import com.luo.springboot.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfigu implements WebMvcConfigurer {


        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/index.html").setViewName("index");
            registry.addViewController("/").setViewName("index");
            registry.addViewController("/main.html").setViewName("dashboard");
            registry.addViewController("/mainpage.html").setViewName("mainpage");
            //registry.addViewController("/usr/login").setViewName("dashboard");
        }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/main.html")
                .excludePathPatterns("/","/index.html","/usr/login");
    }
}

