package rzh.smartsducationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rzh.smartsducationsystem.bean.BeanFactory;
import rzh.smartsducationsystem.bean.UserBean;
import rzh.smartsducationsystem.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/login/submit",method = RequestMethod.POST)
    public String login(String username, String password, String radio, HttpServletRequest request){
        UserBean userBean = BeanFactory.getUserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        userBean.setUserType(radio);
        System.out.println(userBean.toString());
        if (userService.validateAccount(userBean)){
            HttpSession session = request.getSession();
            session.setAttribute("user",userService.getUser(userBean));
            return "index";
        }else {
            return "error";
        }
    }
    @RequestMapping(value = "/login/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "login";
    }
}
