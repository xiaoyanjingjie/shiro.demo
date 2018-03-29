package com.sojson.gorgeousturn.controller.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 服务器端线程处理类
 * 
 * */
public class ServerThread extends Thread {
  //和本线程相关的socket
	Socket socket = null;
	
	public ServerThread(Socket socket){
		this.socket=socket;
	}
	
	//线程执行的操作 相应客户端的请求
	public void run() {
		
		// 获取输出流，用于客户端向服务器端发送数据
		DataOutputStream dos=null;
		DataInputStream dis=null;
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			 dis = new DataInputStream(socket.getInputStream());
			// 客户端向服务器端发送数据
			dos.writeUTF("我是客户端，请求连接000!");
			// 打印出从服务器端接收到的数据
			System.out.println(dis.readUTF());
			// 不需要继续使用此连接时，记得关闭哦
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			
				try {
					if(dis != null){
					dis.close();
				    }
					if(dos!=null) {
						dos.close();
					}
					if(socket !=null) {
						socket.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
		}
		// 获取输入流，用于接收服务器端发送来的数据
		
	}
}
