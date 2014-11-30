 // import the classes of the abstract windows toolkit and swing to enable us to use components like buttons	
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* lines 10 - 11 : declare the class "ReadMessage" and "extends JFrame" means that our application is a sublcass
of the Swing JFrame class. Implements ActionListener is used because the program wants to "listen"
for events  such as the user pressing button  */

public class ReadMessage extends JFrame
        implements ActionListener {
    
    // declares a string instance variable of the frame called "id" used as argument of the class Read Message //   
    private String id;
    // creates "JTextField" object called "priority" , 2 columns wide
    private JTextField priority = new JTextField(2);
    // creates "JButton" object called "update".the button will show the word "Update" as reported in the brackets 
    private JButton update = new JButton("Update");
    // creates "JButton" object called "close". the button will show the word "close"
    private JButton close = new JButton("Close");
    // creates "JTextArea" object called "textArea which is a multi-line area that displays plain tex 
    private JTextArea textArea = new JTextArea();
    // scroll pane is implemented into the "textarea"  to provide a scrollable view of it
    private JScrollPane scrollPane = new JScrollPane(textArea);

    /*line 29 is the constructur declaration of the class ReadMessage
    which has a String argument called "id".
    */ 
    public ReadMessage(String id) {
        this.id = id;
        // sets the boder layout  
        setLayout(new BorderLayout());
        // sets size of the frame in pixel
        setSize(500, 250);
        // stops the user resizing the frame
        setResizable(false);
        // sets the text to be displayed in the title bar
        setTitle("Message Details");
        // dispose of the frame object, but keep the application running 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        /*JPanels creates a physical division of space. 
        Line 46 creates an object of the class JPanel called "top"
        
        */  
        JPanel top = new JPanel();
        // adds the Label "Enter Priority (1-5):" on the "top" panel
        top.add(new JLabel("Enter Priority (1-5):"));
        // adds the Text Field called "priority" on the "top" panel  
        top.add(priority);
        // adds the button "update" to the top panel
        top.add(update);
        /*line 55 registers this object as an action listener on the button "update" , 
         using the addActionListener method.  */
        update.addActionListener(this);
        // adds the button "close" to the top panel
        top.add(close);
        // registers this object as an  action listener on the button "close"
        close.addActionListener(this);
        // adds the panel top to the "north" region of the border layout
        add("North", top);
        
        /*sets the font of textArea previously declared to a 
        plain font with the font type Monospaced at a font size of 12*/
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        /*the lines of the text area will be wrapped if 
        they are too long to fit within the allocated width*/
        textArea.setLineWrap(true);
        /*the lines of the text area will be wrapped at word boundaries (whitespace)
        if they are too long to fit within the allocated width. */
        textArea.setWrapStyleWord(true); 
         // sets the size of the text area in pixels
        textArea.setPreferredSize(new Dimension(450, 150));
        //sets the previously declared JScrollPane object  to be displayed vertically
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // sets the dimensions of the scroll bar in pixels
        scrollPane.setPreferredSize(new Dimension(450, 150));

        // creates an object of the class JPanel called "middle"
        JPanel middle = new JPanel();
        // adds the scroll pane "scrollPane" on the "middle" panel
        middle.add(scrollPane);
        //adds the panel top to the "Center" region of the border layout
        add("Center", middle);
        // calls the method "displayMessage() to execute it and so show the e-mail"
        displayMessage();
        // sets the message displayd as visible
        setVisible(true);
    }
// when a user clicks a button or else the action performed method send a message to all action listeners that are registred
// on the relevant component
    public void actionPerformed(ActionEvent e) {
        // if the user click the button update then execute the intsructions below
        if (e.getSource() == update) {
            // converts a String type into Integer
            int priorityValue = Integer.parseInt(priority.getText());
            /*call the classe MessageData to use the method setPriority and so set the priority value
             taking as arguments "id" and "priorityValue"*/
            MessageData.setPriority(id, priorityValue);
            // this method display the message 
            displayMessage();
            // if the user clicks the button close 
        } else if (e.getSource() == close) {
            // this method which belongs to the class Window , closes the frame
            dispose();
        }
    }
    // declares of the method displayMessage
    private void displayMessage() {
        // declares a String variable to contain the variable "id"
        String subject = MessageData.getSubject(id);
        // if the variable subject has got a "null" value
        if (subject == null) {
            // the text area "textArea" will be set this message
            textArea.setText("No such message");
            // if subject contains a value non-null value will be execute the following instructions
        } else {
            // adds the variable "subject" to the text area "textArea"
            textArea.setText("Subject: " + subject);
            // through the getSender method of the class MessageData add the sender to the text area "textArea"
            textArea.setText("From: " + MessageData.getSender(id));
            //"append" method appends the given text to the end of the message
            textArea.append("\nTo: " + MessageData.getRecipient(id));
            textArea.append("\nPriority: " + MessageData.stars(MessageData.getPriority(id)));
            textArea.append("\n\n" + MessageData.getMessage(id));
        }
    }
}