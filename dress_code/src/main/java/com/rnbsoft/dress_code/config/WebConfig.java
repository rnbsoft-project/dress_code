package com.rnbsoft.dress_code.config;

import com.rnbsoft.dress_code.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

        @Autowired
        private AuthInterceptor authInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(authInterceptor)
                        // AuthInterceptor를 등록하고, 특정 경로 /single ( 상품디테일 화면 ) 에서 인터셉터가 동작하도록 설정
                        .addPathPatterns("/single");
        }
}
