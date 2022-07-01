import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.ArrayList;
import java.util.List;

public class Receiver {

    String receivedMessage;
    List<String> allMessages = new ArrayList<>();



    public Receiver(ChatGUI chatGUI) {

        try{

            Context context = new InitialContext();
            ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) context.lookup("queue1");
            MessageConsumer receiver = session.createConsumer(destination);
            receiver.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage text = (TextMessage) message;
                    try {
                        //System.out.println("Tomaszew.exe : " + text.getText());
                        setReceivedMessage(text.getText());
                        allMessages.add(receivedMessage);
                        chatGUI.setReceivedMessage(receivedMessage);
                        chatGUI.addMessageToGui();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            connection.start();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getReceivedMessage() {
        return receivedMessage;
    }

    public void setReceivedMessage(String receivedMessage) {
        this.receivedMessage = receivedMessage;
    }

    public List<String> getAllMessages() {
        return allMessages;
    }
}