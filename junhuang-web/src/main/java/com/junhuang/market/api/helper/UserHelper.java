package com.junhuang.market.api.helper;

import com.junhuang.market.core.domain.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * Created by pwy on 16/2/6.
 * user 实体类的帮助工具
 */
@Component
public class UserHelper {

    /**
     * 通过明文的密码，获取md5后的密码
     * @param lawsPassword
     * @return
     */
    public String getMd5Password(long passwordTimeStamp, String lawsPassword) {
        return DigestUtils.md5Hex(User.ssoPasswordEncodeKey + passwordTimeStamp + lawsPassword);
    }

    /**
     * 获取accessToken
     * 生成规则是 userId + username + password + timestamp 然后md5
     * @param userId
     * @param username
     * @param password
     * @param timestamp
     * @return
     */
    public String getMd5AccessToken(Long userId, String username, String password, Long timestamp) {
        return DigestUtils.md5Hex(userId + username + password + timestamp);
    }
}
