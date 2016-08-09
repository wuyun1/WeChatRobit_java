package com.wechat.util;

import java.util.Date;

import com.wechat.entity.ReceiveXmlEntity;

public class FormatXmlResult {
	/**
	 * 封装xml结果数据
	 * @param xml 接受到的xml对象
	 * @param tlResult 图灵机器人的结果
	 * @return
	 */
	public static String getXmlResult(ReceiveXmlEntity xml , String tlResult) {
		StringBuffer sb = new StringBuffer();
		xml.setContent(tlResult);
		xml.setCreateTime(""+new Date().getTime());
		
		sb.append("<xml><ToUserName><![CDATA[")
		.append(xml.getFromUserName())
		.append("]]></ToUserName><FromUserName><![CDATA[")
		.append(xml.getToUserName())
		.append("]]></FromUserName><CreateTime>")
		.append(xml.getCreateTime())
		.append("</CreateTime><MsgType><![CDATA[")
		.append(xml.getMsgType())
		.append("]]></MsgType><Content><![CDATA[")
		.append(xml.getContent())
		.append("]]></Content></xml>");
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getXmlResult(new ReceiveXmlEntity(), "eeee"));
	}
}
