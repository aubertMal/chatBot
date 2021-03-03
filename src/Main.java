import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static Scanner scanner;
    static HashMap<String,String> mapListeCritere=new HashMap<>();


    public static void main(String[]args){

        scanner = new Scanner (System.in);
        mapListeCritere.put("","Bonjour!");
        mapListeCritere.put("Bonjour","Comment t'appelles-tu?");
        mapListeCritere.put("m'appelle","Que puis je faire pour toi");
        mapListeCritere.put("vacances","Bonne idée! Que préfères-tu? rester en France ou partir à l'étranger?");
        mapListeCritere.put("France","D'accord! Es tu plutôt Plage ou Montagne?");
        mapListeCritere.put("Plage", "C'est cool! Mer ou Océan?");
        mapListeCritere.put("Bye!", "Au revoir et bonnes vacances!");


        MessageBox messageBox = new MessageBox();
        Thread threadMessageBox = new Thread(messageBox);

        AttenteUtilisateur attenteUtilisateur = new AttenteUtilisateur(messageBox);
        Thread threadAttente = new Thread(attenteUtilisateur);

        threadAttente.start();
        threadMessageBox.start();

    }
}