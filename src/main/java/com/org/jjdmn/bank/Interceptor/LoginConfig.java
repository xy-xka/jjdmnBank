package com.org.jjdmn.bank.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class LoginConfig implements WebMvcConfigurer {
    @Autowired
    private AdminInterceptor adminInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(adminInterceptor);
        registration.addPathPatterns("/**").excludePathPatterns("/", "/do_login",
                "/css/**","/js/**","/images/**","/fonts/**","/jquery-validation/**",
                "/layer/**","/vendor/**");
    }
}
