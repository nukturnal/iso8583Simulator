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


/**
 *
 * @author wael
 */
public class GeneralFunction {
    
final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();  
    
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

    
    public static void writeResponse(String response) throws FileNotFoundException, UnsupportedEncodingException, IOException{
     DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            DateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date));

            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Log_"+dateFormat.format(date)+".txt", true)));
           
            String line = "";
            for(int i = 0 ; i<response.length();i++){               
                if(i%10==0 && i != 0){
                line = line + response.charAt(i);
                String temp =  bytesToHex(line.getBytes());
                writer.println(dateFormat2.format(date) + " : " + sepratehex(temp) + "      |"+ line + "|" );
                line= "";
                }
                else{
                line = line + response.charAt(i);               
                }
               
         }
           
            writer.close();
    }
    
    
    static String sepratehex(String mystring){
            String corrected= "";
            
            for(int i = 0 ; i<mystring.length();i++){
                
                if(i%2==0){
                corrected = corrected +" " +  mystring.charAt(i);       
                }
                else{
                 corrected = corrected +  mystring.charAt(i); 
                }
            }
            
            
      return corrected ;
    }
}
