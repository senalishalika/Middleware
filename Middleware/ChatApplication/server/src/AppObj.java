/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mas shalika
 */
import App.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
 
class AppObj extends AdditionPOA {
  private ORB orb;
 
  public void setORB(ORB orb_val) {
    orb = orb_val; 
  }
 
  // implement add() method
  public int add(int a, int b) {
    int r=a+b;
    return r;
  }
 
  // implement shutdown() method
  public void shutdown() {
    orb.shutdown(false);
  }
  
  private String client1Datas="";
  private String client2Datas="";

    @Override
    public String client1(String a) {
        if(client2Datas !=  ""){
        String r="Client 2: "+client2Datas+"\n"+"Client 1: "+a+"\n";
        client2Datas="";
    
        return r;
       }else{
            client1Datas=a+"\n";
          return "Client 1: "+a+"\n";
        }
        }
    

    @Override
    public String client2(String b) {
       if(client1Datas != ""){
        String r="Client 1: "+client1Datas+"\n"+"Client 2: "+b+"\n";
        client1Datas="";
    
        return r;
       }else{
          client2Datas = b+"\n"; 
          return "Client 2: "+b+"\n";
        } 
    }

    @Override
    public String client1Data() {
        
         if(client1Datas != ""){
      String r= "Client 1: " + client1Datas+"\n";
      client1Datas="";
      return r;
         }else{
             return "";
         }
    }

    @Override
    public String client2Data() {
        if(client2Datas != ""){    
       String v= "Client 2: " + client2Datas+"\n";
       client2Datas="";
       return v;
    }else{
        return "";
    }
}
}