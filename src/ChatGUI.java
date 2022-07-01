import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChatGUI extends JFrame implements ActionListener {

    Container container = getContentPane();
    JButton jButton = new JButton("Send");
    JTextField messageField = new JTextField();
    JTextArea conversationBox = new JTextArea();
    JScrollPane scrollableConversationBox;
    String receivedMessage;



    public ChatGUI() {


        scrollableConversationBox = new JScrollPane(conversationBox,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jButton.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton.setVerticalTextPosition(SwingConstants.CENTER);
        this.setTitle("Simple JMS chat");
        this.setVisible(true);
        this.setBounds(10,10,650,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();




    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        scrollableConversationBox.setBounds(0,0,635,300);
        messageField.setBounds(0,330,500,40);
        jButton.setBounds(500,300,133,110);

    }

    public void addComponentsToContainer() {
        container.add(jButton);
        container.add(messageField);
        container.add(scrollableConversationBox);
    }

    public void addActionEvent() {
        jButton.addActionListener(this);
        //messageField.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton) {

            String message = messageField.getText();
            conversationBox.append("<Hassan Baba> : " + message + "\n");
            Sender sender = new Sender(message);
            messageField.setText("");

        }


    }

    public void setReceivedMessage(String receivedMessage) {
        this.receivedMessage = receivedMessage;

    }

    public void addMessageToGui() {
        conversationBox.append("<Baba Hassan> : " + receivedMessage + "\n");
    }


}
