/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksimulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import static networksimulator.NetworkSimulator.hexArray;

/**
 *
 * @author wael
 */
public class GeneralFunction {
    
    
    public static String convertHexToString(String hex){

	  StringBuilder sb = new StringBuilder();
	  StringBuilder temp = new StringBuilder();

	  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
	  for( int i=0; i<hex.length()-1; i+=2 ){

	      //grab the hex in pairs
	      String output = hex.substring(i, (i + 2));
	      //convert hex to decimal
	      int decimal = Integer.parseInt(output, 16);
	      //convert the decimal to character
	      sb.append((char)decimal);

	      temp.append(decimal);
	  }
	  System.out.println("Decimal : " + temp.toString());

	  return sb.toString();
  }
    
    public static void sendMessageToServer(byte[] str) {	
	try{
            
            Socket socket = new Socket("192.168.30.54", 9190);
 
            //Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            os.write(str);            
            os.flush();
           
            
            System.out.println("Message sent to the server : "+new String(str));
 
            
            //Get the return message from the server
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
                
            
                   
            //int length = Integer.parseInt(message.substring(3));   
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
}
    
    public byte[] FormISOMessage (String Length,String MTI,String Bitmap, HashMap<String,String> isoFields){
    byte[] myBytes  = null;
      
        
        
    
    
    return myBytes;
    }
    
    public static String ReadBigStringIn(BufferedReader buffIn) throws IOException {
    StringBuilder everything = new StringBuilder();
    String line;
    while( (line = buffIn.readLine()) != null) {
       everything.append(line);
    }
    return everything.toString();
}
    
    public static  void receiveMsg(){
			new Thread(new Runnable()
			{
				@Override
				public void run() {
					// TODO Auto-generated method stub

					//final  String host="opuntia.cs.utep.edu";
					final String host="10.0.2.2";
					//final String host="localhost";
					Socket socket = null ;
					BufferedReader in = null;
					try {
						socket = new Socket(host,8008);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					while(true)
					{
						String msg = null;
						try {
							msg = in.readLine();
							//Log.d("","MSGGG:  "+ msg);

							//msgList.add(msg);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(msg == null)
						{
							break;
						}
						else
						{
                                                    System.out.print(msg);
							//displayMsg(msg);
						}
					}

				}
			}).start();


		}
      
    public static String bytesToHex(byte[] bytes) {
        
    char[] hexChars = new char[bytes.length * 2];
    for ( int j = 0; j < bytes.length; j++ ) {
        
        int v = bytes[j] & 0xFF;
        hexChars[j * 2] = hexArray[v >>> 4];
        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        
    }
    return new String(hexChars);
}
    
    public static String binaryToString(String num){
    String MessageHex =  "";
    for(int i = 0 ; i< 32 ; i++){        
        String temp = num.substring(0,4);
        num = num.substring(2);
        int dec = Integer.parseInt(temp,2);         
        String hex = Integer.toHexString(dec);
        MessageHex = MessageHex + hex;      
    }
    return MessageHex.toUpperCase();
    }
    
    
    public static  void writeLog(String Message) throws FileNotFoundException, UnsupportedEncodingException, IOException{
DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
DateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
Date date = new Date();
System.out.println(dateFormat.format(date));

PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Log_"+dateFormat.format(date)+".txt", true)));
writer.println(dateFormat2.format(date) + " : " + Message);    
writer.close();



}  

}
