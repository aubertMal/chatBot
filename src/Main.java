import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static Scanner scanner;
    static TreeMap<String,String[]> mapListeCritere=new TreeMap<String,String[]>();


    public static void main(String[]args){

        scanner = new Scanner (System.in);

        String[] listeValeur = new String[]{"France","Etranger"};
        mapListeCritere.put("Destination",listeValeur);
        

        MessageBox messageBox = new MessageBox();
        Thread threadMessageBox = new Thread(messageBox);

        AttenteUtilisateur attenteUtilisateur = new AttenteUtilisateur(messageBox);
        Thread threadAttente = new Thread(attenteUtilisateur);

        threadAttente.start();
        threadMessageBox.start();

    }
}