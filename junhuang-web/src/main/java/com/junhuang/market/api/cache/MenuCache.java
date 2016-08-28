package com.junhuang.market.api.cache;

import com.junhuang.market.core.domain.Menu;

import java.util.List;

/**
 * Created by pengweiyuan on 7/27/16.
 */
public class MenuCache {

    private static List<Menu> menuCacheList=null;

    public static void initCache(List<Menu> menuList){
        menuCacheList=menuList;
    }

    public static void update(Menu menu){

    }

}
