package com.junhuang.market.api.shiro;

import com.junhuang.market.api.helper.UserHelper;
import com.junhuang.market.core.domain.Role;
import com.junhuang.market.core.domain.User;
import com.junhuang.market.core.repository.RoleRepository;
import com.junhuang.market.core.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

/**
 * Created by pengweiyuan on 7/12/16.
 */
public class ShiroRealm  extends JdbcRealm {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserHelper userHelper;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
          String userName = (String) principals.getPrimaryPrincipal();
//        String name=getName();
//        Iterator iterator=principals.fromRealm(name).iterator();
//        String userName=null;
//        if(iterator.hasNext()){
//            userName = (String) iterator.next();
//        }



       // SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
//        info.addRole("testJo");
//        info.addStringPermission("lightsaber:weild");

        User user = userRepository.findByEmail(userName);
        if(user==null)return null;

        List<Role> roleList = user.getRoleList();
        if(roleList==null)return null;

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for(Role role:roleList){
            info.addRole(role.getRoleName());
            if(!StringUtils.isBlank(role.getPermissionStr())){
                String[] split = role.getPermissionStr().split(";");
                for(String mission:split){
                    info.addStringPermission(mission);
                }
            }
        }

        return info;


        /*info.addRole("admin");
        info.addStringPermission("lightsaber:weild");
        info.addStringPermission("winnebago:drive:eagle5");*/

       // User user =(User) userDao.findOne("username", userName);

        /*  BuguMapper.fetchCascade(user, "roleSet");
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            for (Role group : user.getRoleSet()) {
                BuguMapper.fetchCascade(group, "perssionSet");
                info.addRole(group.getName());
                if(group.getPerssionSet()!=null){
                    Iterator it=group.getPerssionSet().iterator();
                    while(it.hasNext()){
                        info.addStringPermission(((Permission)it.next()).getName());
                    }
                }

            }
            return info;
        } else {
            return null;
        }*/

        //return info;
    }

    //登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String  password =new String(token.getPassword());
        User user = userRepository.findByEmail(username);
        if(user==null){
            throw new UnknownAccountException();//没找到帐号
        }
        Long passwordTimestamp = user.getPasswordTimestamp();
        String pwdEncode=userHelper.getMd5Password(passwordTimestamp, password);
        if(!StringUtils.equals(pwdEncode,user.getPassword())){
            throw  new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(passwordTimestamp.toString()), getName());
        //return null;
    }
}
