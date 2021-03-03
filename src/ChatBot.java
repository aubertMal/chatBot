import java.util.HashMap;

public class ChatBot implements Runnable{

    static void ecritMessage(String message){
        System.out.println(message);
    }

    @Override
    public void run() {
        String message="";
        boolean motTrouve;

        HashMap<String,String> mapCritereDestination=new HashMap<>();

        Connexion connexion = new Connexion("Destinations.db");
        connexion.connect();
        connexion.close();

        while(!message.equals("Bye!")){
            try {
                synchronized (this) {
                    wait();
                    message = Main.saisieUtilisateur.getMessageSaisi();
                    String[] motsMessages = message.split(" ");
                    motTrouve = false;

                    for (int i=0;i<motsMessages.length;i++) {//TODO remplacer par forEach et trouver un moyen de récupérer le prénom
                        if (Main.mapListeCritere.containsKey(motsMessages[i])) {
                            motTrouve = true;
                            if (motsMessages[i].equals("m'appelle"))
                                ecritMessage(Main.mapListeCritere.get(motsMessages[i])+ motsMessages[i+1] +"?" );
                            else
                                ecritMessage(Main.mapListeCritere.get(motsMessages[i]));
                        }
                    }

                    if (!motTrouve)
                        ecritMessage("Désolé je ne comprends pas ce que vous dites:"+ message);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
