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
public class LabelMessages extends JFrame
        implements ActionListener {
    private JTextField idTextField = new JTextField(4);
    private JTextField labTextField = new JTextField(6);
    private JButton addLabel = new JButton("Add Label");
    
    private JButton quit = new JButton("Close");
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textArea);
    
    public LabelMessages () {
        
        setLayout(new BorderLayout());
        setSize(600, 300);
        setResizable(false);
        setTitle("Label Messages");
           JPanel top = new JPanel();
        top.add(new JLabel("Message ID :"));
        top.add(idTextField);
        idTextField.addActionListener(this);
        top.add(new JLabel("Label: "));
        top.add(labTextField);
        labTextField.addActionListener(this);
        top.add(addLabel);
        addLabel.addActionListener(this);
        top.add(quit);
        quit.addActionListener(this);
        add("North", top);
        
        // creating a text area with a vertial scroll pane
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(560, 200));
         scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(560, 200));

        JPanel middle = new JPanel();
        middle.add(scrollPane);
        add("Center", middle);
        
       
        
        setVisible(true);
        
        
    }
 public void actionPerformed(ActionEvent e) {
     if (e.getSource() == quit) {
           
          // to clos the program by the button "quit"
           
            System.exit(0);
         
         
      
        }
     
     
 }
 
 
    
    
}
