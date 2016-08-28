package com.junhuang.market.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pengweiyuan on 7/5/16.
 */
@Controller
@RequestMapping("/about")
public class AboutController {
    @RequestMapping(value = "/index")
    public String index(){
        return "about/index";
    }
}
