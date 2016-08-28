package com.junhuang.market.api.controller;

import com.junhuang.market.core.domain.Menu;
import com.junhuang.market.core.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengweiyuan on 7/4/16.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private MenuRepository menuRepository;

     @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/menu")
    @ResponseBody
    public List<Menu> getMenus(){
        Query query=new Query();
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"order"));
        Sort sort=new Sort(orders);
        if(null!=sort){
            query.with(sort);
        }
        List<Menu> menus = mongoTemplate.find(query, Menu.class);
        return menus;
    }

}
