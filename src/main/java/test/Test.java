package test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test {
	
	
	/**
	 * post璇锋眰
	 * @param url 璇锋眰鍦板潃
	 * @param param 璇锋眰鍐呭
	 * @return 鎺ュ彛杩斿洖鐨勫唴瀹�
	 */
	private static String post(String url , String param) {
		
		try{
			HttpPost request = new HttpPost(url);
			request.setEntity(new StringEntity(param));
			HttpResponse response = HttpClients.createDefault().execute(request);
			
			//鏍规嵁杩斿洖鐮佸垽鏂姹傛槸鍚︽垚鍔�
			if(200 == response.getStatusLine().getStatusCode()){
				return EntityUtils.toString(response.getEntity());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String content = URLEncoder.encode("你好","UTF-8");
		String param = "<xml>"
 +"<ToUserName><![CDATA[toUser]]></ToUserName>"
 +"<FromUserName><![CDATA[fromUser]]></FromUserName>"
 +"<CreateTime>1348831860</CreateTime>"
 +"<MsgType><![CDATA[text]]></MsgType>"
 +"<Content><![CDATA["+content+"]]></Content>"
 +"<MsgId>1234567890123456</MsgId>"
 +"</xml>";
		String url = "http://115.28.242.47:8080/wechatrobit/wechatio.do";
		
		String result = post(url,param);
		System.out.println(result);
	}
}

