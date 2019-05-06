package basic.com;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("basic.com")
public class AppConfig{

    @Bean
    public FilterRegistrationBean<MyAuditingFilter> auditingFilterRegistrationBean() {
        //创建FilterRegistrationBean用于注册MyAuditingFilter
        FilterRegistrationBean<MyAuditingFilter> registration = new FilterRegistrationBean<>();
        //创建要注册的filter，并放入FilterRegistrationBean
        MyAuditingFilter filter = new MyAuditingFilter();    
        registration.setFilter(filter);
        //配置filter
        registration.setOrder(Integer.MAX_VALUE);//放置位置，越大越往后，这里放到责任链的最后
        registration.setUrlPatterns(Arrays.asList("/mvcmsgs/*"));//filter起作用的URL Pattern
        //
        return registration;
    }

}