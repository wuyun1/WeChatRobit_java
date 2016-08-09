package com.wechat.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.wechat.entity.ReceiveXmlEntity;

/**
 * 解析微信端xml数据，转换为对象
 * @author Administrator
 *
 */
public class ParseReceiveXML {
	
	/**
	 * 解析微信XML消息
	 * @param content 微信端的xml数据
	 * @return 转换之后的对象
	 */
	public static ReceiveXmlEntity getMsgEntity(String content) {
		ReceiveXmlEntity msg = null;
		try {
			// 将字符串转换成xml对象
			Document doc = DocumentHelper.parseText(content);
			
			//获取文档的根节点
			 Element root = doc.getRootElement();
			 
			 //遍历根节点下的所有子元素
			 Iterator iter = root.elementIterator();
			 
			 //利用反射机制，调用对象的set方法
			 Class<ReceiveXmlEntity> c = ReceiveXmlEntity.class;
			 
			 msg = c.newInstance();
			 
			 while(iter.hasNext()){
				 Element ele = (Element) iter.next();
				 //获取set方法中的参数字段(实体类的属性)
				 Field filed = c.getDeclaredField(ele.getName());
				 //获取set方法
				 Method method = c.getDeclaredMethod("set"+ele.getName(),filed.getType());
				 //调用set方法
				 method.invoke(msg, ele.getText());
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}
