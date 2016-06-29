package com.panlingxiao.spring.learning.webmvc.other;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.junit.Test;
import org.springframework.core.Conventions;
import org.springframework.core.GenericTypeResolver;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2016/6/29.
 */
public class AnnotationTest {

    @Test
    public void testAnnotationInReturnValue() throws Exception {
        Method aa = AnnotationTest.class.getMethod("aa", new Class[]{});
        ModelAttribute annotation1 = aa.getAnnotation(ModelAttribute.class);
        System.out.println(annotation1);

        Method bb = AnnotationTest.class.getMethod("bb", new Class[]{});
        ModelAttribute annotation2 = aa.getAnnotation(ModelAttribute.class);
        System.out.println(annotation2);


    }

    @Test
    public void testMethodResolve() throws Exception {
        Method method = AnnotationTest.class.getMethod("bb", new Class[]{});
        Class<?> resolvedType = GenericTypeResolver.resolveReturnType(method, String.class);
        String name = Conventions.getVariableNameForReturnType(method, resolvedType, "aa");
        System.out.println(name);


        Method method2 = AnnotationTest.class.getMethod("cc", new Class[]{});
        resolvedType = GenericTypeResolver.resolveReturnType(method2, Person.class);
        name = Conventions.getVariableNameForReturnType(method, resolvedType, "aa");
        System.out.println(name);
    }


    @ModelAttribute
    public void aa() {

    }

    public
    @ModelAttribute
    String bb() {
        return "abc";
    }

    @ModelAttribute
    public Person cc() {
        return new Person();
    }

}
