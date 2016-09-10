package com.junhuang.market.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junhuang.market.api.helper.UserHelper;
import com.junhuang.market.core.common.JsonResult;
import com.junhuang.market.core.common.TDoing;
import com.junhuang.market.core.domain.Menu;
import com.junhuang.market.core.domain.Role;
import com.junhuang.market.core.domain.User;
import com.junhuang.market.core.dto.UserResponse;
import com.junhuang.market.core.repository.MenuRepository;
import com.junhuang.market.core.repository.RoleRepository;
import com.junhuang.market.core.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.*;

/**
 * Created by pengweiyuan on 7/4/16.
 */
@Controller
@RequestMapping("/back")
public class BackController {

    private static final Logger log = LoggerFactory.getLogger(BackController.class);
   /* @Autowired
    private MongoTemplate mongoTemplate;*/

    @Autowired
    private UserHelper userHelper;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @RequiresAuthentication
    @RequestMapping(value = "/index")
    public String index() {
        return "admin/index";
    }


    @RequestMapping(value = "/showLogin")
    public String showLogin() {
        return "admin/login";
    }


    @RequestMapping(value = "/user")
    public String userIndex() {
        return "admin/userList";
    }


    @RequestMapping(value = "/roleIndex")
    public String showRole() {
        return "admin/role";
    }


    @RequestMapping(value = "/roleAdd")
    public ModelAndView roleAdd(@RequestParam("id") String id) {

        Role role = null;
        if (StringUtils.isBlank(id)) role = new Role();
        else {
            role = roleRepository.findOne(id);
        }
        Map<String, Role> resultMap = new HashMap<>(1);
        resultMap.put("role", role);
        return new ModelAndView("admin/roleAdd", resultMap);
        // return "admin/roleAdd";
    }


    @RequestMapping(value = "/saveRole")
    @ResponseBody
    public JsonResult saveRole(HttpServletRequest request, @RequestParam("id") String id, @RequestParam("roleName") String roleName, @RequestParam("description") String description, @RequestParam("permissionStr") String permission) {
        TDoing<Map<String, Object>> doing = jr -> {
            if (StringUtils.isBlank(id)) {
                Role role = new Role();
                role.setRoleName(roleName);
                role.setDescription(description);
                role.setPermissionStr(permission);
                role.setCreateTime(new Date());
                roleRepository.save(role);
            } else {
                Role role = roleRepository.findOne(id);
                role.setRoleName(roleName);
                role.setDescription(description);
                role.setPermissionStr(permission);
                roleRepository.save(role);
            }
        };
        return doing.go("", request, objectMapper, log);
    }

    @RequestMapping(value = "/getRoles")
    @ResponseBody
    public HashMap<String, Object> getRoles(HttpServletRequest request) {
        Iterable<Role> all = roleRepository.findAll();
        List<Role> result = new ArrayList<>();
        all.forEach(role -> {
            result.add(role);
        });

        HashMap<String, Object> tempData = new HashMap<>(2);
        tempData.put("total", result.size());
        tempData.put("rows", result);
        return tempData;
    }


    @RequestMapping(value = "/deleteRole")
    @ResponseBody
    public JsonResult deleteRole(HttpServletRequest request, @RequestParam("id") String id) {
        TDoing<Map<String, Object>> doing = jr -> {
            roleRepository.delete(id);
        };
        return doing.go("", request, objectMapper, log);
    }


    @RequestMapping(value = "/menuIndex")
    public String showMenu() {
        return "admin/menu";
    }


    @RequestMapping(value = "/getMenu")
    @ResponseBody
    public HashMap<String, Object> getMenus(HttpServletRequest request) {
        Iterable<Menu> all = menuRepository.findAll();
        List<Menu> result = new ArrayList<>();
        all.forEach(role -> {
            result.add(role);
        });

        HashMap<String, Object> tempData = new HashMap<>(2);
        tempData.put("total", result.size());
        tempData.put("rows", result);
        return tempData;
    }


    @RequestMapping(value = "/menuAdd")
    public ModelAndView menuAdd(@RequestParam("id") String id) {
        Menu menu = null;
        if (StringUtils.isBlank(id)) menu = new Menu();
        else {
            menu = menuRepository.findOne(id);
        }
        Map<String, Menu> resultMap = new HashMap<>(1);
        resultMap.put("menu", menu);
        return new ModelAndView("admin/menuAdd", resultMap);
        // return "admin/roleAdd";
    }


    @RequestMapping(value = "/saveMenu")
    @ResponseBody
    public JsonResult saveMenu(HttpServletRequest request, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("aliasName") String aliasName, @RequestParam("url") String url, @RequestParam("order") int order) {
        TDoing<Map<String, Object>> doing = jr -> {
            if (StringUtils.isBlank(id)) {
                Menu menu = new Menu();
                menu.setCreateTime(new Date());
                menu.setName(name);
                menu.setAliasName(aliasName);
                menu.setUrl(url);
                menu.setOrder(order);
                menuRepository.save(menu);
            } else {
                Menu menu = menuRepository.findOne(id);
                menu.setCreateTime(new Date());
                menu.setName(name);
                menu.setAliasName(aliasName);
                menu.setUrl(url);
                menu.setOrder(order);
                menuRepository.save(menu);
            }
        };
        return doing.go("", request, objectMapper, log);
    }


    @RequestMapping(value = "/deleteMenu")
    @ResponseBody
    public JsonResult deleteMenu(HttpServletRequest request, @RequestParam("id") String id) {
        TDoing<Map<String, Object>> doing = jr -> {
            menuRepository.delete(id);
        };
        return doing.go("", request, objectMapper, log);
    }


    @RequestMapping(value = "/getUser")
    @ResponseBody
    public HashMap<String, Object> getUser(HttpServletRequest request) {
        Iterable<User> all = userRepository.findAll();
        List<UserResponse> result = new ArrayList<>();
        all.forEach(user -> {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            StringBuilder sb = null;
            if (user.getRoleList() != null) {
                sb = new StringBuilder();
                for (Role role : user.getRoleList()) {
                    sb.append(role.getRoleName());
                    sb.append(";");
                }
            }
            result.add(userResponse);
        });

        HashMap<String, Object> tempData = new HashMap<>(2);
        tempData.put("total", result.size());
        tempData.put("rows", result);
        return tempData;
    }


    @RequestMapping(value = "/userAdd")
    public ModelAndView userAdd(@RequestParam("id") String id) {
        User user = null;
        if (StringUtils.isBlank(id))
            user = new User();
        else {
            user = userRepository.findOne(id);
        }
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("user", user);
        Iterable<Role> roles = roleRepository.findAll();
        resultMap.put("roles", roles);
        return new ModelAndView("admin/userAdd", resultMap);
        // return "admin/roleAdd";
    }


    @RequestMapping(value = "/saveUser")
    @ResponseBody
    public JsonResult saveUser(HttpServletRequest request, User user, @RequestParam("role") String role) {
        TDoing<Map<String, Object>> doing = jr -> {
            if (StringUtils.isBlank(user.getUserName())) {
                jr.errorParam(User.USERNAME_IS_INULL);
                return;
            }
            if (StringUtils.isBlank(user.getPassword())) {
                jr.errorParam(User.PASSWORD_IS_INULL);
                return;
            }
            if (StringUtils.isBlank(user.getEmail())) {
                jr.errorParam(User.EMAIL_IS_INULL);
                return;
            }
            Long passwordTimestamp = java.sql.Date.from(Instant.now()).getTime();
            user.setPassword(userHelper.getMd5Password(passwordTimestamp, user.getPassword()));
            user.setPasswordTimestamp(passwordTimestamp);

            if (!StringUtils.isBlank(role)) {
                String[] roleIds = role.split(",");
                Role role1 = null;
                List<Role> roleList = new ArrayList<>(roleIds.length);
                for (String rid : roleIds) {
                    role1 = roleRepository.findOne(rid);
                    if (role1 != null) {
                        roleList.add(role1);
                    }
                }
                user.setRoleList(roleList);
            }

            if (StringUtils.isBlank(user.getId())) {
                user.setId(null);
                user.setCreateTime(new Date());
                userRepository.insert(user);
            } else {
                userRepository.save(user);
            }
        };
        return doing.go(user, request, objectMapper, log);
    }


    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public JsonResult deleteUser(HttpServletRequest request, @RequestParam("id") String id) {
        TDoing<Map<String, Object>> doing = jr -> {
            userRepository.delete(id);
        };
        return doing.go(id, request, objectMapper, log);
    }


    @RequestMapping(value = "/checkEmail")
    @ResponseBody
    public HashMap<String, Object> checkEmail(HttpServletRequest request, @RequestParam("email") String email) {
        User user = userRepository.findByEmail(email);
        HashMap<String, Object> tempData = new HashMap<>(2);
        if (user != null) {
            tempData.put("valid", false);
        } else {
            tempData.put("valid", true);
        }
        return tempData;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(HttpServletRequest request, HttpServletResponse response, @RequestParam("email") String username, @RequestParam("password") String password) {
        //Object shiroLoginFailure = request.getAttribute("shiroLoginFailure");
        TDoing<Map<String, Object>> doing = jr -> {
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()) {
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                token.setRememberMe(false);//记住密码
                try {
                    currentUser.login(token);
                } catch (UnknownAccountException uae) {
                    log.error("There is no user with username of " + token.getPrincipal());
                    jr.errorParam(User.IS_NOT_EXIST);
                    return;
                } catch (IncorrectCredentialsException ice) {
                    log.error("Password for account " + token.getPrincipal() + " was incorrect!");
                    jr.errorParam(User.PASSWORD_IS_NOT_VALID);
                    return;
                } catch (LockedAccountException lae) {
                    log.error("The account for username " + token.getPrincipal() + " is locked.  " +
                            "Please contact your administrator to unlock it.");
                    jr.errorParam(User.WAS_LOCKED);
                    return;
                } catch (AuthenticationException ae) {
                    log.error("AuthenticationException error " + token.getPrincipal() + " was incorrect!",ae);
                    jr.errorParam(User.ERROR);
                }
            }
        };
        return doing.go("", request, objectMapper, log);
    }
}
