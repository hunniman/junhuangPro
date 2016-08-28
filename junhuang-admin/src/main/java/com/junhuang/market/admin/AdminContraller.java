package com.junhuang.market.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pengweiyuan on 4/3/16.
 */
@RestController
public class AdminContraller {

    @RequestMapping("/test")
    public String test(){
        return "dddddddda";
    }
}
