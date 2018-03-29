package com.sojson.gorgeousturn.controller.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	/**
	 * 注意：Socket的发送与接收是需要同步进行的，即客户端发送一条信息，服务器必需先接收这条信息， 而后才可以向客户端发送信息，否则将会有运行时出错。
	 * Java Socket(套接字)通常也称作"套接字"，用于描述IP地址和端口，是一个通信链的句柄。应用程序通常通过"套接字"向网络发出请求或者应答网络请求。
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8888);
			System.out.println("服务器正在启动请稍后");
			//记录客户端的数量
			int count =0;
			Socket socket=null;
			//循环监听等待客户端的链接
			while(true) {
				count++;
				// 服务器接收到客户端的数据后，创建与此客户端对话的Socket
				socket = ss.accept();
				ServerThread serverThread =new ServerThread(socket);
				//启动线程
				serverThread.start();
				System.out.println("count"+count);
				
				InetAddress address =socket.getInetAddress();
				System.out.println("客户端的地址：  "+address.getHostAddress());
 				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}