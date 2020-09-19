package com.mynb.web;

import com.mynb.pojo.College;
import com.mynb.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials="true", allowedHeaders="*")
@RequestMapping("/card")
public class CollegeController {
    @Autowired
    private ICardService cardService;


    @RequestMapping(path="/listAllColleges",method = {RequestMethod.GET,RequestMethod.POST})
    public List<College> getStuById(Integer stuId) {
        List<College> list = cardService.listAllColleges();
        return list;
    }
}
