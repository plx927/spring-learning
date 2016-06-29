package com.panlingxiao.spring.learning.webmvc.controller;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by panlingxiao on 2016/6/28.
 * 源码分析@SessionAttribute原理
 *
 * @SessionAttribute是不跨越Handler的
 *
 */
@Controller
@SessionAttributes(value={"person","page"},types = {Person.class})
@RequestMapping("/sessionAttr")
public class SessionAttributeController {

    public @ModelAttribute("person") Person initSessionAttrbute(){
        Person person = new Person();
        person.setName("隔壁老王");
        //System.out.println("initSessionAttrbute:"+id);
        return person;
    }

    //getAnnotation(ModelAttribute.class)!= null && getAnnotatin(RequestMapping.class)==null
    @RequestMapping("/myTest1")
    public void myTest1(@ModelAttribute("person") Person person,HttpSession session,HttpServletRequest request){
        Person person1 = (Person) session.getAttribute("person");
        Object person2 = request.getAttribute("person");
        System.out.println(person);
        System.out.println(person1);
        System.out.println(person2);
    }


    @RequestMapping("/myTest/{id}")
    public void myTest2(@PathVariable Integer id){
        System.out.println("myTest2:"+id);
    }

}
