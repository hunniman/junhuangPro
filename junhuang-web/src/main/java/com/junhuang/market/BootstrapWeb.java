package com.junhuang.market;

/**
 * Created by pengweiyuan on 4/3/16.
 */

import com.junhuang.market.core.domain.Role;
import com.junhuang.market.core.domain.User;
import com.junhuang.market.core.repository.UserRepository;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class})
@ComponentScan
@EnableTransactionManagement
public class BootstrapWeb {
    public static  void main(String[]args){
        SpringApplication application=new SpringApplication(BootstrapWeb.class);
        application.setBannerMode(Banner.Mode.LOG);
        ApplicationContext applicationContext= application.run(args);
        /*applicationContext.getMe
        ssage("");*/
       /* Mongo mogo = applicationContext.getBean(Mongo.class);
        System.err.println(mogo==null);*/
        MongoTemplate template = applicationContext.getBean(MongoTemplate.class);
        User userInfo=new User();
        userInfo.setUserName("joker");
        userInfo.setPassword("123");
        userInfo.setMobile("123");
        //template.insert(userInfo);
        User test = template.findById("5784a2141a8b9f3cc0554e4f", User.class);
        System.err.println(test);

        /*User user=new User();
        user.setMobile("44444");
        user.setUsername("userName");
        user.setUserStatus(UserStatus.DISABLE);
        template.insert(user);*/

       /* List<User> users = template.find(Query.query(where("userName").is("joker")), User.class);
        System.err.println(users.get(0).getUserName());

        UserRepository userRepository = applicationContext.getBean(UserRepository.class);

        List<User> joker = userRepository.findByUserNameAndPassword("joker", "123");
        System.err.println(joker.get(0).getPassword());
*/

        List<Role> all = template.findAll(Role.class);

        all.forEach(role -> {
            System.err.println(role.getId());
        });

//
//        Subject currentUser = SecurityUtils.getSubject();
//
//        // Do some stuff with a Session (no need for a web or EJB container!!!)
//        Session session = currentUser.getSession();
//        session.setAttribute("someKey", "aValue");
//        String value = (String) session.getAttribute("someKey");
//        if (value.equals("aValue")) {
//            System.err.println("Retrieved the correct value! [" + value + "]");
//        }
//
//        // let's login the current user so we can check against roles and permissions:
//        if (!currentUser.isAuthenticated()) {
//            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
//            token.setRememberMe(true);
//            try {
//                currentUser.login(token);
//            } catch (UnknownAccountException uae) {
//
//            }
//        }
        System.err.println("over!!!");
    }
}
