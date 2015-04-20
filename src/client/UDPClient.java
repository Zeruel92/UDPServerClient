package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class UDPClient {
	
	private DatagramSocket sock;
	private DatagramPacket pack;
	private InetSocketAddress server;
	
	public UDPClient(){
		System.out.println("Client");
		try {
			sock=new DatagramSocket();
			server=new InetSocketAddress("localhost", 12345);
			byte[] data="prova".getBytes();
			pack=new DatagramPacket(data,data.length,server);
			sock.send(pack);
			sock.receive(pack);
			String res=new String(pack.getData());
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
