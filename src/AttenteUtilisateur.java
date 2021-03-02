import java.io.IOException;

public class AttenteUtilisateur implements Runnable{
    public void run () {

        String s = Main.scanner.next();
        notify();
    }
}
