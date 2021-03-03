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
        mapListeCritere.put("vacances","Bonne idée! Que préfères-tu? rester en France ou partir à l'étranger?");
        mapListeCritere.put("France","D'accord! Es tu plutôt Plage ou Montagne?");
        mapListeCritere.put("Plage", "C'est cool! Mer ou Océan?");
        mapListeCritere.put("Bye!", "Au revoir et bonnes vacances!");


        ChatBot chatBot = new ChatBot();
        Thread threadMessageBox = new Thread(chatBot);

        saisieUtilisateur = new SaisieUtilisateur(chatBot);
        Thread threadSaisie = new Thread(saisieUtilisateur);

        threadMessageBox.start();
        threadSaisie.start();

    }
}