package com.junhuang.market.core.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by pengweiyuan on 8/28/16.
 */
@Document(collection = "resource")
public class Resource extends IDMongoEntity {

    private String name;

    private String type;
    //顺序
    private int priority;

    private String permission;


    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
