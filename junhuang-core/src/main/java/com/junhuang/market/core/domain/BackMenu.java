package com.junhuang.market.core.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by pengweiyuan on 7/15/16.
 */
@Document(collection="backmenu")
public class BackMenu extends IDMongoEntity {

    private String name;

    private String url;

    private List<BackMenu> childMenu;

    private List<String>permission;

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<BackMenu> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<BackMenu> childMenu) {
        this.childMenu = childMenu;
    }
}
