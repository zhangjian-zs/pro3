package com.mynb.service;

import com.mynb.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class testService {

    @Autowired
    private ICardService cardService;

    @Test
    public void testSelectStusByInfo() throws Exception{
        List<Student> list = cardService.selectStusByInfo("2");
        org.junit.jupiter.api.Assertions.assertTrue(list.size()>0);
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
