package linxits;

import java.net.*;
import java.io.*;

public class ServerJava extends Thread {
         private ServerSocket serverSocket;

	 public ServerJava (int port) throws IOException {
		 serverSocket = new ServerSocket(port);
		 /*serverSocket.setSoTimeout(10000);*/
	 }

	 public void run() {
		while(true){
                     try{
		        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
	                Socket server = serverSocket.accept();
	                System.out.println("Now connected to " + server.getRemoteSocketAddress());
			DataInputStream in = new DataInputStream(server.getInputStream());
	                System.out.println(in.readUTF());
	                DataOutputStream out = new DataOutputStream(server.getOutputStream());
	               out.writeUTF("Thnak you for Connecting to "+ server.getLocalSocketAddress() + "\n Goodbye!");
                      server.close();		       
		     } catch (SocketTimeoutException s) {
			  System.out.println("Socket timed out!");
		          break;	  
		     } catch (IOException e){
			  e.printStackTrace();
		          break;	  
		     }

		}
	 }

	 public static void main(String [] args){
	        int port = Integer.parseInt(args[0]);
	        try{
                   Thread t = new ServerJava(port);
	           t.start();
		}catch (IOException e){
	           e.printStackTrace();		
		}	
	 }
		 
}
