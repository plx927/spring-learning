package com.mouse.json.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panlingxiao.spring.learning.webmvc.domain.ParamBean;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


@ControllerAdvice
public class MyAdviceController {
	
	//private static final ObjectMapper MAPPER = new ObjectMapper();

	@ModelAttribute
	public ParamBean init(HttpEntity<ParamBean> httpEntity){
		ParamBean paramBean = null;
		 try {
			//获取参数
//			 String data = httpEntity.getBody();
//			 ObjectMapper objectMapper =  new ObjectMapper();
//			  paramBean = data != null ? objectMapper.readValue(data, ParamBean.class) : null;
			 paramBean = httpEntity.getBody();
			 System.out.println(paramBean);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return paramBean;
	}
}
