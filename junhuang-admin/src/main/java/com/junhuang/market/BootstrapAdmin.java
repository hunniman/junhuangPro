package com.junhuang.market;

/**
 * Created by pengweiyuan on 4/3/16.
 */

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class})
@EnableTransactionManagement
public class BootstrapAdmin {
    public static  void main(String[]args){
        SpringApplication application=new SpringApplication(BootstrapAdmin.class);
        application.setBannerMode(Banner.Mode.LOG);
        ApplicationContext applicationContext= application.run(args);
    }
}
