package com.panlingxiao.spring.learning.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by panlingxiao on 2016/6/26.
 */
@Controller
@RequestMapping("/mapping")
public class RequestMappingController {

//    @RequestMapping(value={"/myTest","myTest"},method = RequestMethod.GET)
//    public void myTest1(){
//        System.out.println("myTest1");
//    }
//
//    @RequestMapping(value="/myTest")
//    public void myTest2(){
//        System.out.println("myTest2");
//    }

    /*
     * 当没有加上"/"时，在构建PatternRequestCondition时，会自动加上"/"
     * 直接调式AbstractHandlerMethodMapping#registerHandlerMethod中Set<String> patterns = getMappingPathPatterns(mapping);代码查看结果
     */
    @RequestMapping(value={"/helloworld"})
    public void myTest3(){
        System.out.println("myTest3");
    }

    /*
     * 测试通配符的路径映射
     * 这种写法是比较消耗查询性能的，因为它需要整体遍历所有的RequestMappingInfo
     *
     * myTestabc、myTesta
     */
    @RequestMapping("/myTest*")
    public void myTest4(){
        System.out.println("myTest4");
    }

    @RequestMapping("/myTest5/{id}")
    public void myTest5(@PathVariable Integer id){
        System.out.println("id:"+id);
    }


    /*
     *　通过占位符设置映射的URL,name通过PropertyPlaceHolderConfigurer来转换
     */
    @RequestMapping("/myTest6/${name}")
    public void myTest6(){
        System.out.println("myTest6");
    }



}
