/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksimulator;

import java.io.File;
import java.util.ArrayList;
import  java.util.*;
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
public class RequestForm extends javax.swing.JFrame {
    List<field> s = new ArrayList<field>();
    public static String Message ;
    /**
     * Creates new form RequestForm
     */
    public RequestForm() {
               
        initComponents();
       
        
        
        try {	
         File inputFile = new File("Message"+Message+".xml");
         DocumentBuilderFactory dbFactory 
            = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :"  + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("field");
         System.out.println("----------------------------");
        
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;             
              
               if(Integer.parseInt(eElement.getAttribute("id"))==7){
             
                 }
               
               try{
                        s.add(new field(Integer.parseInt(eElement.getAttribute("id"))
                                ,eElement.getAttribute("name"),null,
                                eElement.getAttribute("status").charAt(0),
                                eElement.getAttribute("encoding"),eElement.getTextContent(),eElement.getAttribute("type")));
                       }
              catch(Exception ex){
                        s.add(new field(Integer.parseInt(eElement.getAttribute("id"))
                                 ,eElement.getAttribute("name"),null,
                                 ' ',
                                 eElement.getAttribute("encoding"),eElement.getTextContent(),eElement.getAttribute("type")));
                        }
               
               
               
               System.out.println("Field Id : " + eElement.getAttribute("id"));
               System.out.println("name : " + eElement.getAttribute("name"));
               System.out.println("status : " + eElement.getAttribute("status"));
               System.out.println("encoding : " + eElement.getAttribute("encoding"));
               System.out.println("type : " + eElement.getAttribute("type"));
               
            }
         }
        
         
      } catch (Exception e) {
         e.printStackTrace();
      }
        if(!Message.equals(null)){
                Object[][] fields = new Object[s.size()][5];
         for(int i = 0 ; i <s.size();i++){
         fields[i][0] = s.get(i).getId();
         fields[i][1] = s.get(i).getName();
         fields[i][2] = s.get(i).getLength();
         fields[i][3] = s.get(i).getStatus();
         fields[i][4] = s.get(i).getValue();
          
         }
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    fields,
                    new String [] {
                        "id", "name", "length", "M/C", "value"
                    }
                ) {
                    Class[] types = new Class [] {
                        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }
                });
        }
        else{
                
                
        
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                    },
                    new String [] {
                        "id", "name", "length", "M/C", "value"
                    }
                ) {
                    Class[] types = new Class [] {
                        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }
                });
             }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "name", "length", "M/C", "value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Send Message to Server");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String MessageToSend = "";
    try{    
        GeneralFunction.writeLog("Start "+Message+" transaction");
        GeneralFunction.writeLog("----------------------------------------");
        
        for(int i = 0; i< jTable1.getRowCount();i++){   
            if( !jTable1.getModel().getValueAt(i, 4).toString().equals("")){
                switch(s.get(i).getEncoding()){
                    case "ASCII":
                        if(s.get(i).getType().contains("L")){      
                            int occurance = countChar(s.get(i).getType(),'L');
                            String appededmessage = GeneralFunction.convertHexToString(jTable1.getModel().getValueAt(i, 4).toString());
                            Message = Message +String.format("%0"+occurance+"d",appededmessage.length() )  + appededmessage  ;                        
                         }
                        else{
                        Message = Message + GeneralFunction.convertHexToString(jTable1.getModel().getValueAt(i, 4).toString());
                        }
                        break;
                    case "Binary":
                        if(s.get(i).getType().contains("L")){
                                int occurance = countChar(s.get(i).getType(),'L');
                                String appededmessage = GeneralFunction.convertHexToString(jTable1.getModel().getValueAt(i, 4).toString());
                                Message = Message +String.format("%0"+occurance+"d",appededmessage.length() )  + appededmessage  ;                        
                        }
                        else{
                                Message = Message + GeneralFunction.convertHexToString(jTable1.getModel().getValueAt(i, 4).toString());
                        }
                        break;
                    case "UTF8":
                        if(s.get(i).getType().contains("L")){
                                int occurance = countChar(s.get(i).getType(),'L');
                                String appededmessage = jTable1.getModel().getValueAt(i, 4).toString();
                                Message = Message +String.format("%0"+occurance+"d",appededmessage.length() )  + appededmessage  ;                        
                        }else{                      
                                Message = Message + jTable1.getModel().getValueAt(i, 4).toString();
                        }
                        break;
                    default:
                        break;
                }
                 
                
                //GeneralFunction.writeLog("Index: " + i + " id : "+ (String) jTable1.getModel().getValueAt(i, 0) + " Value : " +(String) jTable1.getModel().getValueAt(i, 4));            
            }
        }
        System.out.println("Message : " + Message);
        Message =  String.format("%04d", Message.length()) + Message;
        GeneralFunction.writeLog("Generated Message : " + new String(Message.getBytes("ISO-8859-1")));
       
       Client.sendData(Message.getBytes("ISO-8859-1"),new Client().getClientSocket());
    
    }
    catch(Exception e){
    e.printStackTrace();
    }

        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public int countChar(String str,char temp){
    
    int charCount = 0;

            for( int i = 0; i < str.length( ); i++ )
            {
                if(temp == str.charAt( i )){
                charCount++;   }
            }

    return charCount;
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RequestForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
