import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Sender {

    String myMessage;

    public Sender(String myMessage) {
        try {

            this.myMessage = myMessage;
            Context context = new InitialContext();
            ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) context.lookup("queue2");
            connection.start();
            MessageProducer sender = session.createProducer(destination);
            TextMessage message = session.createTextMessage(myMessage);
            sender.send(message);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}