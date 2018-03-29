package com.sojson.gorgeousturn.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
/**
 * InetAddress 
 * 
 * */
public class inetAddress {

	public static void main(String[] args) throws UnknownHostException {
		 InetAddress address = InetAddress.getLocalHost();
		 System.out.println("计算机名称："+address.getHostName()+"IP:"+address.getHostAddress());
		 System.out.println(address);
		 byte[] bytes=address.getAddress();
		 System.out.println("字节形式的ip:"+Arrays.toString(bytes));
	
		 //根据机器名称获取InetAddress 实例
		 //InetAddress address2 =InetAddress.getByName("DESKTOP-5SJTFQO");
		 InetAddress address2 = InetAddress.getByName("192.168.129.1");
		 System.out.println("计算机名称："+address2.getHostName()+"IP:"+address2.getHostAddress());
		 

	}

}
