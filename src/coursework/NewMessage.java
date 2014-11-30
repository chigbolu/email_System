/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Student
 */

    public class NewMessage extends JFrame
        implements ActionListener {

    
    private JTextField idTextField = new JTextField(10);
    private JTextField subTextField = new JTextField(10);
    private JButton quit = new JButton("Exit");
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textArea);
    private JButton send = new JButton ("SEND");
    
    public NewMessage () {
         
        setLayout(new BorderLayout());
        setSize(600, 300);
        setResizable(false);
        setTitle("New Message");
         
         JPanel top = new JPanel();
         top.add(new JLabel("Message ID: "));
        top.add(idTextField);
        top.add(new JLabel("Subject:"));
        top.add(subTextField);
        
        top.add(quit);
        quit.addActionListener(this);
        add("North", top);
        
        // creating the text area previously declared as "textArea"
        textArea.setBackground(Color.yellow);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(560, 200));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(560, 200));
        
        textArea.setText("Type your message here ...");
        JPanel middle = new JPanel();
        middle.add(scrollPane);
        add("Center", middle);
        JPanel bottom = new JPanel();
        bottom.add(send);
        send.addActionListener(this);
        add("South",bottom);

       

        setVisible(true);
       
    }
    
    
    
    
    
    
    
     public void actionPerformed(ActionEvent e) {
       
          if (e.getSource() == quit) {
            // to quit the program by the button "quit"
            System.exit(0);
         
         
      
        }
     }
    }
    
     
    
