package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer implements Runnable {
	
	private DatagramSocket sock;
	private DatagramPacket pack;
	private String response;
	private Thread T;
	
	public UDPServer(){
		System.out.println("Server");
		try {
			sock=new DatagramSocket(12345);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		T=new Thread(this);
		T.start();
	}
	
	public void run(){
		while(true){
			try {
				byte[] bufferIn=new byte[1024];
				pack=new DatagramPacket(bufferIn, bufferIn.length);
				sock.receive(pack);
				process();
				DatagramPacket responseDatagram=new DatagramPacket(response.getBytes(),response.getBytes().length,pack.getSocketAddress());
				sock.send(responseDatagram);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void process(){
		byte[] data= pack.getData();
		response =new String(data);
		response=response.toUpperCase();		
	}
}
