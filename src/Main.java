import java.util.Scanner;

public class Main {
    public static void main(String [] args) {


        ChatGUI chatGUI = new ChatGUI();
        Receiver receiver = new Receiver(chatGUI);

        //ChatGUI  chatGUI = new ChatGUI();

        //Sender sender =  new Sender("Działa teraz ok?");
        /*
        Receiver receiver = new Receiver();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            System.out.println("Chrzastowski.exe: " + message);
            Sender sender1 = new Sender(message);
        }


         */


    }
}
