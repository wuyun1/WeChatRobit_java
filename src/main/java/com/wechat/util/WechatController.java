package com.wechat.util;

import com.wechat.entity.ReceiveXmlEntity;
import com.wechat.tuling.TulingController;

/**
 * 微信流程控制类
 * @author Administrator
 *
 */
public class WechatController {
	public String wechatProcess (String content){
		
		ReceiveXmlEntity xml = ParseReceiveXML.getMsgEntity(content);
		
		//调用图灵机器人接口处理模块，获取图灵机器人结果
		String tlResult = new TulingController().getTulingRe(xml.getContent());
		
		String xmlResult = FormatXmlResult.getXmlResult(xml, tlResult);
		
		return xmlResult;
		
	}
}

