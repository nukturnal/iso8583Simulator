/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksimulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author wael
 */
public class Client {
    private static Socket ClientSocket;

    public Socket getClientSocket() {
        return ClientSocket;
    }

    public  void setClientSocket(Socket ClientSocket) {
        this.ClientSocket = ClientSocket;
    }
    
    public static Socket connect(String Host, int Port) throws IOException{  
           Socket socket = new Socket(Host, Port);
           
          if(socket.isConnected()){
          GeneralFunction.writeLog("Client Connected");
          }
          else{
          GeneralFunction.writeLog("Connection not established");
          }
          Client.ClientSocket = socket;
    return socket;
    }
   
    public static void sendData(byte[] b,Socket socket) throws IOException{
            
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        os.write(b);            
        os.flush();
        System.out.println("Message sent to the server : "+new String(b));
        
             InputStream is = socket.getInputStream();      
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);           
          
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j <  4 ; j++){
            sb.append((char)br.read());
            }
            
            for(int i = 0 ; i<Integer.parseInt(sb.toString());i++){               
            System.out.println("Message received from the server index :"+ i +" message : "+ (char) br.read());
         }
             
    }
    
    
}
