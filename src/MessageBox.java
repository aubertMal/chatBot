import java.util.HashMap;
import java.util.TreeMap;

public class MessageBox implements Runnable{

    static void ecritMessage(String message){
        System.out.println(message);
    }

    @Override
    public void run() {
        String message="";

        HashMap<String,String> mapCritereDestination=new HashMap<>();

        while(message!="Bye"){
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            message = Main.scanner.next();
            String[] motsMessages = message.split(" ");
            for (String mot:
                 motsMessages) {
                if (Main.mapListeCritere.containsKey("mot"))
                    ecritMessage(Main.mapListeCritere.get("mot"));
            }
        }
    }
}
