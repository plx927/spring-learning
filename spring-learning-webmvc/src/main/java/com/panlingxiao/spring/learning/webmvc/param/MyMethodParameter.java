package com.panlingxiao.spring.learning.webmvc.param;

import com.panlingxiao.spring.learning.webmvc.annotation.MyRequestBody;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2016/7/20.
 */
public class MyMethodParameter extends MethodParameter {

    private RequestBody requiredAnno;
    private RequestBody noReqeuiredAnno;
    private MyRequestBody myRequestBody;

    public MyMethodParameter(MethodParameter original,MyRequestBody myRequestBody) {
        super(original);
        try {
            Method declaredMethod = ConsutructAnnotationClass.class.getDeclaredMethod("test", new Class[]{String.class, Integer.class});
            Annotation[][] parameterAnnotations = declaredMethod.getParameterAnnotations();
            RequestBody anno = (RequestBody) parameterAnnotations[0][0];
            if(anno.required()){
                requiredAnno = anno;
                noReqeuiredAnno = (RequestBody) parameterAnnotations[1][0];
            }else{
                noReqeuiredAnno = anno;
                requiredAnno = (RequestBody) parameterAnnotations[1][0];
            }
            this.myRequestBody = myRequestBody;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static class ConsutructAnnotationClass{
        public void test(@RequestBody() String st1,@RequestBody Integer num){
        }
    }

    @Override
    public <T extends Annotation> T getParameterAnnotation(Class<T> annotationType) {
        if(annotationType == RequestBody.class){
            if(myRequestBody.required()){
                return (T)requiredAnno;
            }else{
                return (T)noReqeuiredAnno;
            }
        }
        return super.getMethodAnnotation(annotationType);
    }



}
