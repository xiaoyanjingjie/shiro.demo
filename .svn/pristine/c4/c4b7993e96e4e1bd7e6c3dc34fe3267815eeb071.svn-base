package com.sojson.gorgeousturn.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 
 * 
 * */
public class inetAdressUrl {

	public static void main(String[] args) {
       try {
		URL imook=new URL("http://www.imooc.com");
		//?后面表示参数 #后面表示锚点
		URL url = new URL(imook,"/index.html?username=tom#test");
		System.out.println("协议："+url.getProtocol()+ "  主机："+url.getHost()+" 端口："+url.getPort() +" 文件路径："+url.getPath() +" 文件名："+url.getFile() +" 相对路径："+url.getRef()+" 查询字符串："+url.getQuery());
		//如果未指定端口号，则使用的是默认的端口号    端口号返回的是getPost 是-1 
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      //使用URL获取页面内容 
       try {
    	   //创建以恶搞url实例
		URL url1=new URL("https://www.jd.com");
		try {
			//通过url的openStream方法获取url对象所表示的资源的字节输入流
			InputStream is=url1.openStream();
			//将字节输入流转换为字符输入流
			InputStreamReader isr =new InputStreamReader(is,"utf-8");
			//为字符输入流添加缓冲
			BufferedReader br =new BufferedReader(isr);
			String data=br.readLine();//读取数据
			while(data!=null) {
				System.out.println(data);
				data =br.readLine();
						
			}
			br.close();
			isr.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	

}
