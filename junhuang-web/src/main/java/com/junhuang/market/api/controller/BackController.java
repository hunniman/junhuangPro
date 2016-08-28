package com.junhuang.market.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    private RoleRepository roleRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/index")
    public String index() {
        return "admin/index";
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
    public JsonResult saveMenu(HttpServletRequest request, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("aliasName") String aliasName, @RequestParam("url") String url,@RequestParam("order") int order) {
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
            UserResponse userResponse=new UserResponse();
            BeanUtils.copyProperties(user,userResponse);
            StringBuilder sb=null;
            if(user.getRoleList()!=null){
                sb=new StringBuilder();
                for(Role role:user.getRoleList()){
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
        User user=null;
        if (StringUtils.isBlank(id))
            user = new User();
        else {
            user = userRepository.findOne(id);
        }
        Map<String, User> resultMap = new HashMap<>(1);
        resultMap.put("user", user);
        return new ModelAndView("admin/userAdd", resultMap);
        // return "admin/roleAdd";
    }
}
