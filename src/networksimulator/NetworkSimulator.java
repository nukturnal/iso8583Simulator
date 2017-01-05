/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksimulator;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author wael
 */
public class NetworkSimulator {
final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        
        ServerConnection Sc = new ServerConnection();
        Sc.show();
        
        
        
//        Socket s = Client.connect("",0);
//    
       
   
        
//      String ss = "1804" + GeneralFunction.convertHexToString("82300100080000000400000000000000")+"0804120010280728160804120010301621716280728001";
//                                     //82 30 01 00 08 00 00 00 04 00 00 00 00 00 
//      System.out.println(GeneralFunction.convertHexToString("82300100080000000400000000000000").substring(1));
//      System.out.println(GeneralFunction.convertHexToString(GeneralFunction.binaryToString("10101101101000000000000000100000000000000011000000000000000100000000001000000000000000000000000000000000000000000000000000000001")));
//      
//      String Message =  null;
//                
//                
//      Message =  String.format("%04d", 66) + 
//                          "1804" + 
//                         GeneralFunction.convertHexToString("82300100080000000400000000000000") + 
//                          "0804120010280728160804120010301621716280728001";
//       
//      Client.sendData(Message.getBytes("ISO-8859-1"), s);
//       
//      System.out.println(new String(Message.getBytes()));
//
//     //  System.out.println(bytesToHex(Message.getBytes("ISO-8859-1")));
//     
//       String Message2 =  String.format("%04d", 66) + 
//                          "1804" + 
//                         GeneralFunction.convertHexToString("82300100080000000400000000000000") + 
//                          "0804120010280728160804120010301621716280728003";
//       
//       Client.sendData(Message2.getBytes("ISO-8859-1"), s);
       
       
    }
    
    
    
 
    
}
