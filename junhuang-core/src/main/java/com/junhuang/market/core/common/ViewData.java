package com.junhuang.market.core.common;

/**
 * Created by oyhk on 16/3/20.
 *
 */
public class ViewData {
    public String view;
    // url
    public String url;
    // redirect: url
    public String rUrl;

    public void setRUrl(String url) {
        this.rUrl = "redirect:" + url;
    }

}
