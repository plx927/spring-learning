package com.panlingxiao.spring.learning.webmvc.tag;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by panlingxiao on 2016/7/20.
 */
@Controller
@RequestMapping("/formTag")
public class FormTagController {

    /**
     * <pre>
     *      <form id="command" action="/spring-learning-webmvc/formTag/myTest1" method="post">
     *
     *      </form>
     *
     * </pre>
     *
     * 默认生成的表单格式
     *
     * @return
     */
    @RequestMapping("/myTest1")
    public String myTest1() {
        return "formTag";
    }


}
