import java.io.IOException;

public class SaisieUtilisateur implements Runnable{

    private ChatBot chatBot;
    private String messageSaisi;

    public SaisieUtilisateur(ChatBot chatBot) {
        this.chatBot = chatBot;
    }

    public void run () {
        while(true) {
            setMessageSaisi(Main.scanner.nextLine());
            synchronized (chatBot) {
                chatBot.notify();
                try {
                    Thread.sleep(1);
                } catch(IllegalArgumentException e){
                    System.out.println("la valeur du sleep est négative");
                } catch(InterruptedException e){
                    System.out.println("Thread interrompu");
                }
            }
        }
    }

    public String getMessageSaisi() {
        return messageSaisi;
    }

    public void setMessageSaisi(String messageSaisi) {
        this.messageSaisi = messageSaisi;
    }
}
