import client.UDPClient;
import server.UDPServer;


public class Main {

	public static void main(String[] args) {
		if(args[0].equals("--server")){
			UDPServer a=new UDPServer();
		}
		else{
			UDPClient c=new UDPClient();
		}
	}

}
