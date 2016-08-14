package com.ecloudtime.rs.controller;

import com.ecloudtime.rs.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by eric on 2016/8/14.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, @Valid User user, BindingResult bindingResult, ModelMap map) throws Exception {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
        } catch (UnknownAccountException uae) {
            map.addAttribute("message", "未知账户");
        } catch (IncorrectCredentialsException ice) {
            map.addAttribute("message", "密码不正确");
        } catch (LockedAccountException lae) {
            map.addAttribute("message", "账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            map.addAttribute("message", "用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            ae.printStackTrace();
            map.addAttribute("message", "用户名或密码不正确");
        }

        //验证是否登录成功
        if (currentUser.isAuthenticated()) {
            return "redirect:/";
        } else {
            token.clear();
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap map) {
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        map.addAttribute("message", "您已安全退出");
        return "redirect:/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        return "403";
    }
}
