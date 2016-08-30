package com.junhuang.market.core.domain;

import com.junhuang.market.core.enumclass.UserStatus;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by pengweiyuan on 7/11/16.
 */
@Document(collection = "user")
public class User extends IDMongoEntity {

    // 密码 md5 加密的key
    public static final String ssoPasswordEncodeKey = "xc??vn()&^i@!#Y*!&@Tkl~~deh#*!ut@#!$ks√fhs213@1234vx>>>..';[]5938˜∫√ƒ45$@#&$T@&#$^!@#!*#$^*!^#*&^<>M";
    public static final String USERNAME_IS_INULL = "用户名为空";
    public static final String PASSWORD_IS_INULL = "密码为空";
    public static final String EMAIL_IS_INULL = "邮箱为空";
    private String userName;
    private String password;
    private Long passwordTimestamp;
    private String mobile;
    private String nickName;
    private String email;
    private byte sex;
    private UserStatus userStatus;
    private List<Role> roleList;

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

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

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

}
