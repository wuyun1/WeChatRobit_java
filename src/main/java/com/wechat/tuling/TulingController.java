package com.wechat.tuling;

import com.alibaba.fastjson.JSONObject;

/**
 * 图灵机器人接口流程控制类
 * @author Administrator
 *
 */
public class TulingController {
	
	/**
	 * 调用图灵机器人接口，并返回所需内容
	 * @param info
	 * @return
	 */
	public String getTulingRe(String info){
		
		//调用图灵机器人接口api，获取结果
		String url = "http://www.tuling123.com/openapi/api?key=12669fb3f28c44d0b1078d5194b71d39&secret=9b516433febfcf44&info="+info;
		String tlResult = HttpGetRequest.get(url);
		JSONObject jsonObj = JSONObject.parseObject(tlResult);
		//解析图灵结果数据，提取所需内容
		String result = jsonObj.getString("text");
		return result;
	}
}
