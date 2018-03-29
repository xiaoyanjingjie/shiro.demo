package com.sojson.gorgeousturn.controller.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 服务器端 实现UDP的用户登入
 * 
 * */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		/**
		 * 接受数据
		 * */
		 //1。创建服务器端DatagramSockte,制定端口
		DatagramSocket socket=new DatagramSocket(8800);
		//2.创建数据报 用于接受客户端的发送到de数据
         byte[] data=new byte[1024];//创建字节数组，指定接受的数据包的大小
         //3.接受客户发送的数据
         System.out.println("服务器已经启动 等待客户端发送信息");
         DatagramPacket packet =new DatagramPacket(data,data.length);
         socket.receive(packet);//此方法会在接收到数据报一直堵塞
         //4 读取数据
         String info =new String(data,0,packet.getLength());
         System.out.println(" 我是服务器，客户端说：  "+info);
	   
         
         /**
          * 发送数据
          * 
          * */
         //1定义客户端的地址  端口号 数据
         InetAddress address =packet.getAddress();
         int port=packet.getPort();
         byte[] data2 ="欢迎你".getBytes();
         //2 创建数据报 包含响应数据信息
         DatagramPacket packet2=new DatagramPacket(data2, data2.length,address,port);
         //3响应客户端 
         socket.send(packet2);
         //4 关闭资源吗
         socket.close();
         
         
         
         
	
	}
 
}
