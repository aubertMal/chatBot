import java.lang.reflect.Array;
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
        mapListeCritere.put("vacances","Bonne idée! Que préfères-tu? plage ou montagne?");
        mapListeCritere.put("Plage", "C'est cool! Mer ou Océan?");
        mapListeCritere.put("Mer", "OK; en France ou à l'étranger?");
        mapListeCritere.put("Océan", "OK; en France ou à l'étranger?");
        mapListeCritere.put("Montagne", "OK; en France ou à l'étranger?");
        mapListeCritere.put("France", "Préfères tu un séjour culturel ou un séjour détente?");
        mapListeCritere.put("Etranger","Préfères tu un séjour culturel ou un séjour détente?");
        mapListeCritere.put("Culturel","D'accord! Voici ce que je te propose:");
        mapListeCritere.put("Détente","D'accord! Voici ce que je te propose:");
        mapListeCritere.put("Non","");
        mapListeCritere.put("Oui","Cool Bonnes vacances alors :) !");
        mapListeCritere.put("Bye!", "Au revoir!");


        ChatBot chatBot = new ChatBot();
        Thread threadMessageBox = new Thread(chatBot);

        saisieUtilisateur = new SaisieUtilisateur(chatBot);
        Thread threadSaisie = new Thread(saisieUtilisateur);

        threadMessageBox.start();
        threadSaisie.start();

    }
}