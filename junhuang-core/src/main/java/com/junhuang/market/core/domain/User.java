package com.junhuang.market.core.domain;

import com.junhuang.market.core.enumclass.UserStatus;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Created by pengweiyuan on 7/11/16.
 */
@Document(collection = "user")
public class User extends IDMongoEntity {

    // 密码 md5 加密的key
    public static final String ssoPasswordEncodeKey = "xc??vn()&^i@!#Y*!&@Tkl~~deh#*!ut@#!$ks√fhs213@1234vx>>>..';[]5938˜∫√ƒ45$@#&$T@&#$^!@#!*#$^*!^#*&^<>M";

    private String userName;
    private String password;
    private Long passwordTimestamp;
    private String mobile;
    private String realName;
    private String nickName;
    private String email;
    private byte sex;
    private UserStatus userStatus;
    private List<Role> roleList;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPasswordTimestamp() {
        return passwordTimestamp;
    }

    public void setPasswordTimestamp(Long passwordTimestamp) {
        this.passwordTimestamp = passwordTimestamp;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
