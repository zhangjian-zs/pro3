package com.mynb.web;

import com.github.pagehelper.PageInfo;
import com.mynb.pojo.Student;
import com.mynb.pojo.Userinfo;
import com.mynb.service.ICardService;
import com.mynb.vo.StudentDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.expr.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController    //@RestController=@Controller + @ResponseBody
@CrossOrigin(allowCredentials="true", allowedHeaders="*")
@RequestMapping("/card")
public class StudentController {
    @Autowired
    private ICardService cardService;

    @RequestMapping(path="/listAllStu",method = {RequestMethod.GET,RequestMethod.POST})
    public PageInfo<Student> listAllStu(@RequestParam(required = false,name = "page",defaultValue = "1") Integer page) {
        //自定义每页显示的条数
        Integer pageSize = 5;
        PageInfo<Student> info = cardService.listAllStu(page,pageSize);
        return info;
    }

    @RequestMapping(path="/getStuById",method = {RequestMethod.GET,RequestMethod.POST})
    public Student getStuById(Integer stuId) {
        Student student = cardService.selectStuBySid(stuId);
        return student;
    }

    @RequestMapping(path="/saveStu",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean saveStu(@RequestBody Student student) {

        return cardService.updateStu(student);
    }

    @RequestMapping(path="/addStu",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean addStu(@RequestBody Student student) {

        return cardService.addStu(student);
    }

    @RequestMapping(path="/delStuById",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean delStuById(Integer stuId) {
        System.out.println(stuId);
        return cardService.delStuBySid(stuId);
    }

    /**
     * 删除多选学生
     * @param stus
     * @return
     */
    @RequestMapping(path="/delStusByIds",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean delStusByIds(Integer[] stus) {
        for (Integer integer : stus) {
            cardService.delStuBySid(integer);
        }
        return false;
    }

    /**
     * 模糊查询学生信息
     * @param info
     * @return
     */
    @RequestMapping(path="/selectStusByInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public List<Student> selectStusByInfo(String info) {
        List<Student> list = cardService.selectStusByInfo(info);
        return list;
    }


    /**
     * 学生登录
     *
     * @param login
     * @param password
     * @return
     */
    @RequestMapping(path="/stuLogin",method = {RequestMethod.GET,RequestMethod.POST})
    public Student stuLogin(String login,String password) {
        Student student = cardService.stuLogin(login,password);
        return student;
    }




    @RequestMapping(path="/getStuDetailById",method = {RequestMethod.GET,RequestMethod.POST})
    public StudentDetail getStuDetailsById(Integer stuId) {
        StudentDetail studentDetail = cardService.selStuDetailById(stuId);
        return studentDetail;
    }

}

