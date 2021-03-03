import java.util.HashMap;

public class ChatBot implements Runnable{

    static void ecritMessage(String message){
        System.out.println(message);
    }

    @Override
    public void run() {
        String message="";
        boolean motTrouve;
        String elementMessage = "";

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
                        elementMessage = motsMessages[i];
                        if (Main.mapListeCritere.containsKey(elementMessage)) {
                            motTrouve = true;
                            switch(elementMessage){
                                case "m'appelle":
                                    ecritMessage(Main.mapListeCritere.get(elementMessage)+ motsMessages[i+1] +"?" );
                                    break;
                                case "Plage":
                                case "Montagne":
                                    mapCritereDestination.put("lieu", elementMessage);
                                    break;
                                case "Culturel":
                                case "Détente":
                                    mapCritereDestination.put("typeVacances",elementMessage);
                                    break;
                                case "Etranger":
                                case "France":
                                    mapCritereDestination.put("localisation",elementMessage);
                                    break;
                                case "Mer":
                                case "Océan":
                                    mapCritereDestination.put("typePlage",elementMessage);
                                    break;
                                default:
                                    ecritMessage(Main.mapListeCritere.get(motsMessages[i]));
                                    break;
                            }
                        }
                    }

                    if (!motTrouve)
                        ecritMessage("Désolé je ne comprends pas ce que vous dites:"+ message);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        ecritMessage("Tu as choisi: " + mapCritereDestination);
    }
}
