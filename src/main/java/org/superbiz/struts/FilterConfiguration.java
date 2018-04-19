package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.Collections.singletonList;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean registerFilter1() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new FilterDispatcher());
        registration.setUrlPatterns(singletonList("/*"));
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean registerFilter2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ActionContextCleanUp());
        registration.setUrlPatterns(singletonList("/*"));
        registration.setOrder(2);
        return registration;
    }

    @Bean
    public FilterRegistrationBean registerFilter3() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new PageFilter());
        registration.setUrlPatterns(singletonList("/*"));
        registration.setOrder(3);
        return registration;
    }
}
