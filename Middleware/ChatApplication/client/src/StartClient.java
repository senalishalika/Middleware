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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class StartClient {
 
    /**
     * @param args the command line arguments
     * 
     */
    public static JTextArea textArea;
    public static void main(String[] args) {
      try {
	    ORB orb = ORB.init(args, null);
	    org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
	    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    Addition addobj = (Addition) AdditionHelper.narrow(ncRef.resolve_str("ABC"));
 
            Scanner c=new Scanner(System.in);
            System.out.println("Welcome to the addition system:");      
            JFrame frame = new JFrame("Chat System(Client 1)");
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            JTextField field = new JTextField(20);
            textArea = new JTextArea();

            textArea.setSize(400, 800);

            textArea.setLineWrap(true);

            JScrollPane scroll = new JScrollPane(textArea,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            scroll.setPreferredSize(new Dimension(250, 250));
            textArea.setEditable(true);
            JLabel hh = new JLabel();
            hh.setText(" Enter Message ");

            JButton but = new JButton(" Enter ");
            but.addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {
                    //System.out.println("text:" + textArea.getText());
                    String bb = field.getText();
                    String h = addobj.client1(bb);
                    //System.out.println("dd" + h);
                    textArea.append(h);

                    String p = addobj.client2Data();

                  textArea.append(p);
//                    scroll.add(textArea);
//                    
                }
            });
            //panel.add(sbrText2);

//            panel.add(txt);
            panel.add(scroll);
            panel.add(hh);
            panel.add(field);
            panel.add(but);

            frame.add(panel);
            frame.setSize(300, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);            
//		    for(;;){
//                       String s= addobj.client2Data();
//                         System.out.println(s);
//                      
//		      System.out.println("Enter ");
//		      String bb = c.nextLine();
//                      String h=addobj.client1(bb);
//                      System.out.println(h);
//                      String p= addobj.client2Data();
//                      System.out.println(p);
//		      
//            }
       }
       catch (Exception e) {
          System.out.println("Hello Client exception: " + e);
	  e.printStackTrace();
       }
 
    }
 
}
