package cn.marring.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class GlobalCorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //配置允许跨域访问的路径
                registry.addMapping("/**")
                        //放行哪些原始域
                        .allowedOrigins("*")
                        //是否发送Cookie信息
                        .allowCredentials(true)
//                        .allowedOrigins("http://imqa.pg.com.cn", "https://imqa.pg.com.cn")
                        //放行哪些原始域(请求方式)
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
//                        .allowedMethods("*")
                        //放行哪些原始域(头部信息)
                        .allowedHeaders("Auth-Type", "Accept", "Authorization", "Content-Type", "Origin", "Ocp-Apim-Subscription-Key", "X-Requested-With")
                        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                        .exposedHeaders("X-Total-Count", "Correlation-Id", "Content-Type");
            }
        };
    }
}
