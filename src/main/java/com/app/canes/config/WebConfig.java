package com.app.canes.config;

import com.app.canes.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(
            InterceptorRegistry registry) {

        registry.addInterceptor(
                new LoginInterceptor())

                .addPathPatterns("/**")

                .excludePathPatterns(
                        "/",
                        "/logout",
                        "/login",
                        "/css/**",
                        "/js/**",
                        "/img/**"
                );
    }
}
