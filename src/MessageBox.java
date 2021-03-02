import java.util.TreeMap;

public class MessageBox implements Runnable{

    static void ecritMessage(String message){
        System.out.println(message);
    }

    static String litMessage(){
        return Main.scanner.next();
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        ecritMessage("Bonjour!");
        ecritMessage("Comment t'appelles Tu?");
        ecritMessage("Que dirais tu de partir en voyage "+ litMessage() + "?");
        if (litMessage() == "Non")
            return;

        TreeMap<String,String> mapCritereDestination=new TreeMap<String,String>();

        while(litMessage()!="FIN"){
            for (String critere:Main.listeCriteres) {
            }
        }
    }
}
