package com.mynb.web;

import com.mynb.pojo.Userinfo;
import com.mynb.service.ICardService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController    //@RestController=@Controller + @ResponseBody
@CrossOrigin(allowCredentials="true", allowedHeaders="*")
@RequestMapping("/card")
public class UserinfoController {
    @Autowired
    private ICardService cardService;

/*    @RequestMapping(path="/login",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean verifyLogin(@RequestBody Userinfo userinfo, HttpSession session) {
        boolean rt = false;
        Userinfo u = cardService.UserLogin(userinfo.getUserLogin(), userinfo.getUserPasswd());
        if(u!=null) {
            session.setAttribute("userinfo", u);
            rt = true;
        }
        return rt;
    }*/

    @RequestMapping(path="/login",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean verifyLogin(@RequestBody Userinfo userinfo, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(userinfo.getUserLogin(),userinfo.getUserPasswd()));
        String login = (String) subject.getPrincipal();
        Userinfo u = cardService.selectUserByName(login);
        session.setAttribute("userinfo",u);
        return subject.isAuthenticated();
    }

    @RequestMapping(path="/getUserName",method = {RequestMethod.GET,RequestMethod.POST})
    public String getUserName(HttpSession session) {
        Userinfo userinfo = (Userinfo) session.getAttribute("userinfo");
        if(userinfo!=null) {
            return userinfo.getUserName();
        }
        return null;
    }


    @RequestMapping(path="/getUserId",method = {RequestMethod.GET,RequestMethod.POST})
    public Integer getUserId(HttpSession session) {
        Userinfo userinfo = (Userinfo) session.getAttribute("userinfo");
        if(userinfo!=null) {
            return userinfo.getUserId();
        }
        return null;

    }


    /**
     * 修改用户信息（修改登录密码）
     * @param
     * @return
     */
    @RequestMapping(path="/modifyUserinfo",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean modifyUserinfo(Userinfo userinfo) {
        boolean rt = cardService.updateUserinfo(userinfo);
        return rt;
    }


    /**
     * 修改用户信息（修改登录密码）
     * @param
     * @return
     */
    @RequestMapping(path="/confirmPwd",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean confirmPwd(Integer userId,String newPasswd) {
        boolean rt = cardService.confirmPwd(userId,newPasswd);
        return rt;
    }



}
