package com.panlingxiao.spring.learning.webmvc.domain;

import java.util.HashMap;
import java.util.Map;

public class ParamBean {
	
	private static final long serialVersionUID = 698852581L;
	
	private String appId;

	private Map<String, Object> headMap = new HashMap<String, Object>();
	


	public ParamBean() {
	}



	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * getCommand(这里用一句话描述这个方法的作用)
	 * 
	 * @Title: getCommand
	 * @Description: TODO
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public void setHead(String key, Object value) {
		headMap.put(key, value);
	}

	public Object getHead(String key) {
		return headMap.get(key);
	}


	public Map<String, Object> getHeadMap() {
		return headMap;
	}


	@Override
	public String toString() {
		return "ParamBean{" +
				"appId='" + appId + '\'' +
				", headMap=" + headMap +
				'}';
	}
}
