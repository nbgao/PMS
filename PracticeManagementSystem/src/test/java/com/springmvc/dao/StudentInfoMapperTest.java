package com.springmvc.dao;

import com.springmvc.entity.StudentInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Created by liu on 2017/5/5.
 */
public class StudentInfoMapperTest {

    private ApplicationContext applicationContext;
    @Autowired//autowired==自动装配
    private StudentInfoMapper studentInfoMapper;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");//加载spring配置文件
        studentInfoMapper=applicationContext.getBean(StudentInfoMapper.class);//在这里导入要测试的

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        StudentInfo studentInfo=new StudentInfo();
        studentInfo.setSnumber(15051701);
        studentInfo.setSname("刘昊轩11");
        studentInfo.setSmajor("计算机");
        studentInfo.setSpassword("111111");
        studentInfo.setSsex("男");
        int result = studentInfoMapper.insertSelective(studentInfo);
        System.out.println(result);
        assert (result == 1);
    }
    @Test
    public void selectSelective()throws Exception{
        StudentInfo studentInfo=new StudentInfo();
        studentInfo.setSnumber(15051700);
        ArrayList<StudentInfo> list=studentInfoMapper.selectSelective(studentInfo);
        for(StudentInfo a:list)
            System.out.println(a);
    }

    @Test
    public void selectLike()throws Exception{
        StudentInfo studentInfo=new StudentInfo();
        studentInfo.setSname("刘昊轩");
        ArrayList<StudentInfo> list=studentInfoMapper.selectLike(studentInfo);
        for(StudentInfo a:list)
            System.out.println(a);
    }

}