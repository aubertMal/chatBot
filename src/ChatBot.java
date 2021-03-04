import com.sun.source.tree.TryTree;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ChatBot implements Runnable{

    static Connexion connexion = new Connexion("Destinations.db");
    static ResultSet resultSet;

    static void ecritMessage(String message){
        System.out.println(message);
    }

    @Override
    public void run() {
        String message="";
        String messageProposition ="";
        boolean motTrouve;
        String elementMessage = "";
        int nbrTry =0;

        CriteresUtilisateur criteresUtilisateur = new CriteresUtilisateur();

        String destination="";

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

                            //On va stocker le choix de l'utilisateur
                            switch(elementMessage){
                                case "Plage":
                                case "Montagne":
                                    criteresUtilisateur.setLieu(elementMessage);
                                    break;
                                case "Etranger":
                                case "France":
                                    criteresUtilisateur.setLocalisation(elementMessage);
                                    break;
                                case "Mer":
                                case "Océan":
                                    criteresUtilisateur.setTypePlage(elementMessage);
                                    break;
                                case "Culturel":
                                case "Détente":
                                    criteresUtilisateur.setTypesVacances(elementMessage);
                                    break;
                                default:
                                    break;
                            }
                            //Puis on lui répond
                            if (elementMessage.equals("m'appelle"))
                                ecritMessage(Main.mapListeCritere.get(elementMessage)+ motsMessages[i+1] +"?" );
                            else if (elementMessage.equals("Culturel") || elementMessage.equals("Détente") || elementMessage.equals("Non")){
                                if (elementMessage.equals("Non"))
                                    nbrTry++;

                                destination = getDestination(criteresUtilisateur,nbrTry);
                                if (!destination.isEmpty())
                                {
                                    messageProposition = elementMessage.equals("Non")?"Et si je te propose "+destination+" sinon?":"Aimerais tu aller à "+destination;
                                    ecritMessage(messageProposition);
                                    openUrl(getUrl(destination));
                                }
                                else
                                    ecritMessage("Je suis désolé aucune destination ne correspond à tes attentes");
                            }
                            else
                                ecritMessage(Main.mapListeCritere.get(elementMessage));
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

    static String getDestination(CriteresUtilisateur criteres, int nbrProposition ){
         String destination="";

        connexion.connect();

        resultSet = connexion.query("SELECT destination FROM destinations WHERE typevacances ='"+ criteres.getTypesVacances() + "'\n" +
                "AND lieu = '" + criteres.getLieu()+ "'\n" +
                "AND localisation = '"+ criteres.getLocalisation()+"'");
        try{
            if (resultSet!=null) { //il faut qu'on le fasse une fois pour pointer sur la 1ere ligne sinon on va avoir le résultat de la 1ere ligne 2 fois
                resultSet.next();
                while (nbrProposition != 0) {
                    resultSet.next();
                    nbrProposition--;
                }
                destination = resultSet.getString("destination");
            }
        } catch(SQLException e){
            System.out.println("Problème d'accès à la base");
        }
        connexion.close();

        return destination;
    }

    static String getUrl(String destination){

        String url ="";
        connexion.connect();

        resultSet = connexion.query("SELECT url FROM destinations WHERE destination = '"+destination+"'");

        try {
            url = resultSet.getString("url");
        } catch (SQLException e){
            System.out.println("Problème d'accès à la base pour récupérer l'url");
        }
        connexion.close();
        return url;
    }

    static void openUrl(String urlAOuvrir){

        if (Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI(urlAOuvrir));
            } catch(URISyntaxException | IOException e) {
                ecritMessage("Echec à l'ouverture de la page");
            }
        }

    }
}
