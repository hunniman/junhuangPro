package com.junhuang.market.api.config;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by pengweiyuan on 4/14/16.
 */
public class DBaasLocaleResolver extends AcceptHeaderLocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        HttpSession session=request.getSession();
        Locale locale=(Locale)session.getAttribute("locale");
        System.out.println("resolveLocale:"+locale.toString());
        if (locale==null){
            session.setAttribute("locale",request.getLocale());
            return request.getLocale();
        }else{
            return locale;
        }
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        System.out.println("setLocale:"+locale.toString());
        request.getSession().setAttribute("locale",locale);
    }
}
