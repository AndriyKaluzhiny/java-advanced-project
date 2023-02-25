package ua.lviv.lgs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("cabinet");
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/create").setViewName("addUniversity");
        registry.addViewController("/universities").setViewName("universities");
        registry.addViewController("/marks").setViewName("marks");
        registry.addViewController("/registerMark").setViewName("registerMark");
        registry.addViewController("/universityPage").setViewName("universityPage");
        registry.addViewController("/edit").setViewName("edit");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
   }
}
