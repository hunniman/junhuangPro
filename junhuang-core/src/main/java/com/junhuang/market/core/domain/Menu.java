package com.junhuang.market.core.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by pengweiyuan on 7/24/16.
 */
@Document(collection = "menu")
public class Menu  extends IDMongoEntity{

    private String name;

    /**
     * 别名
     */
    private String aliasName;

    private String url;

    private int order;

    /**
     * 父菜单ID
     */
    private String parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
