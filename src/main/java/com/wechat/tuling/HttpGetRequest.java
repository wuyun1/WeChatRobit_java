package com.wechat.tuling;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * http get 请求类
 * @author Administrator
 *
 */
public class HttpGetRequest {

	/**
	 * get请求
	 * @param url 请求的地址和参数
	 * @return url的结果
	 */
	public static String  get(String url){
		String result = "";
		try {
			HttpGet request = new HttpGet(url);
			HttpResponse response = HttpClients.createDefault().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(new String(get("http://www.qq.com").getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
