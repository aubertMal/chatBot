import java.util.Scanner;

public class Main {

    static Scanner scanner;

    public static void main(String[]args){

        scanner = new Scanner (System.in);

        MessageBox messageBox = new MessageBox();
        Thread threadMessageBox = new Thread(messageBox);

        AttenteUtilisateur attenteUtilisateur = new AttenteUtilisateur();
        Thread threadAttente = new Thread(attenteUtilisateur);

        threadAttente.start();
        threadMessageBox.start();


    }
}