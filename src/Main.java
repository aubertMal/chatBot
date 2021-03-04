
import java.util.*;

public class Main {

    static Scanner scanner;
    static HashMap<String,String> mapListeCritere=new HashMap<>();
    static SaisieUtilisateur saisieUtilisateur;


    public static void main(String[]args){

        scanner = new Scanner (System.in);
        scanner.useDelimiter("\n");

        mapListeCritere.put("","Bonjour!");
        mapListeCritere.put("Bonjour","Comment t'appelles-tu?");
        mapListeCritere.put("m'appelle","Que puis je faire pour toi ");
        mapListeCritere.put("vacances","Bonne idée! Préfères Tu partir à l'Etranger ou rester en France?");
        mapListeCritere.put("Etranger", "OK; Es tu plutôt Plage ou Montagne?");
        mapListeCritere.put("France", "OK; Es tu plutôt Plage ou Montagne?");
        mapListeCritere.put("Plage", "C'est cool! Mer ou Océan?");
        mapListeCritere.put("deux", "C'est cool! En plage aimes tu la Mer ou l' Océan?");
        mapListeCritere.put("Mer", "Préfères tu un séjour culturel ou un séjour détente?");
        mapListeCritere.put("Océan","Préfères tu un séjour culturel ou un séjour détente?");
        mapListeCritere.put("Montagne","Préfères tu un séjour culturel ou un séjour détente?");
        mapListeCritere.put("Culturel","Y'a t-il une activité que tu aimerais faire?");
        mapListeCritere.put("Détente","Y'a t-il une activité que tu aimerais faire?");
        mapListeCritere.put("Baignade", "");
        mapListeCritere.put("Escalade", "");
        mapListeCritere.put("Randonnée", "");
        mapListeCritere.put("Surf", "");
        mapListeCritere.put("Non","");
        mapListeCritere.put("Oui","Cool Bonnes vacances alors :) !");
        mapListeCritere.put("Bye!", "Au revoir!");


        ChatBot chatBot = new ChatBot();
        Thread threadChatBot = new Thread(chatBot);

        saisieUtilisateur = new SaisieUtilisateur(chatBot);
        Thread threadSaisie = new Thread(saisieUtilisateur);

        threadChatBot.start();
        threadSaisie.start();

    }
}