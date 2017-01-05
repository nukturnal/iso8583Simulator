/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksimulator;

/**
 *
 * @author wael
 */
public class field {
    
    private int id ;
    private String name ;
    private char status;
    private String length;
    private String encoding;
    private String value;
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
   
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setValue(String value) {
        this.value = value;
    }
     
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLength() {
        return length;
    }

    public char getStatus() {
        return status;
    }

    public String getEncoding() {
        return encoding;
    }

    public String getValue() {
        return value;
    }
   

    public field(int id, String name, String length, char status, String encoding, String value,String type) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.status = status;
        this.encoding = encoding;
        this.value = value;
        this.type = type;
    }
   
    
   

   
   
    
    
    
    
}
