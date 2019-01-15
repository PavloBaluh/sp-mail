package ua.test.spring_boot.Config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Bean
    public MessageSource messageSource (){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:massages");
        return messageSource;
    }
    @Bean
    public LocalValidatorFactoryBean factoryBean(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String passtofolder = System.getProperty("user.home") + File.separator + "images" + File.separator;
        registry.addResourceHandler("/ava/**").addResourceLocations("file:///",passtofolder);

    }
}
