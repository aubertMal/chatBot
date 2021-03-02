import java.io.IOException;

public class AttenteUtilisateur implements Runnable{

    private MessageBox messageBox;

    public AttenteUtilisateur(MessageBox msgBox) {
        messageBox = msgBox;
    }

    public void run () {
        String s = Main.scanner.next();
        synchronized (messageBox) {
            messageBox.notify();
        }
    }
}
