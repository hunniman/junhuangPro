package com.junhuang.market.core.domain;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by pengweiyuan on 7/11/16.
 */

public class IDMongoEntity {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
