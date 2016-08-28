package com.junhuang.market.api.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

/**
 * Created by pengweiyuan on 4/4/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    CookieLocaleResolver resolver;

    @Autowired
    SessionLocaleResolver sessionLocaleResolver;



    @RequestMapping(value = "/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping(value = "/logout")
    /*@RequiresAuthentication
    @RequiresPermissions(" lightsaber:weild")*/
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isAuthenticated())
            currentUser.logout();
        return "user/index";
    }


    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request,@RequestParam("username")String username,@RequestParam("password")String password){
        //Object shiroLoginFailure = request.getAttribute("shiroLoginFailure");
        Subject currentUser = SecurityUtils.getSubject();
        System.err.println(currentUser==null);

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                System.err.println("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                System.err.println("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                System.err.println("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        return "user/login";
    }


    @RequestMapping(value = "/language")
    public ModelAndView language(HttpServletRequest request, HttpServletResponse response,String language){
        if(language.toLowerCase().equals("zh_cn")){
            sessionLocaleResolver.setLocale(request,response, Locale.CHINA);
            Locale locale = new Locale("zh", "CN");
            //request.getSession().setAttribute("locale",locale);
        }else if(language.toLowerCase().equals("en")){
            sessionLocaleResolver.setLocale(request,response, Locale.ENGLISH);
            Locale locale = new Locale("en", "US");
           // request.getSession().setAttribute("locale",locale);
        }
        return  new ModelAndView("redirect:index");
    }
}
