package com.junhuang.market.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;


@Configuration
@EnableWebMvc
public class webMvcConfigureAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
//        super.configureHandlerExceptionResolvers(exceptionResolvers);
//        SimpleMappingExceptionResolver simpleMappingExceptionResolver=new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        properties.setProperty("org.apache.shiro.authz.UnauthorizedException","/test");
//        simpleMappingExceptionResolver.setExceptionMappings(properties);
//        exceptionResolvers.add(simpleMappingExceptionResolver);
//    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setPrefix("/page/");
        resolver.setSuffix(".jsp");
        return  resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }



   /* @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        return factory;
    }*/

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource getmessageSource(){
        ResourceBundleMessageSource source=new ResourceBundleMessageSource();
        source.setBasename("messages/messages");
        source.setUseCodeAsDefaultMessage(true);//不加会报错,很纠结 还没搞明白
        return  source;
    }

    @Bean
    public CookieLocaleResolver getCookieLocaleResolver(){
        CookieLocaleResolver resolver=new CookieLocaleResolver();
        resolver.setCookieMaxAge(604800);
        resolver.setDefaultLocale(Locale.forLanguageTag("zh_CN"));
        resolver.setCookieName("Language");
        return resolver;
    }

    @Bean(name = "localeResolver")
    public SessionLocaleResolver getSessionLocaleResolver(){
        SessionLocaleResolver sessionLocaleResolver=new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.CHINA);
        //sessionLocaleResolver.l/**/
        return sessionLocaleResolver;
    }

   // @Bean
    private LocaleChangeInterceptor getInterceptor(){
        LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
        interceptor.setParamName("language");
        return  interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public DBaasLocaleResolver getLocaleResolver(){
        DBaasLocaleResolver dBaasLocaleResolver=new DBaasLocaleResolver();
        return  dBaasLocaleResolver;
    }


}
