public class MessageBox implements Runnable{

    static void ecritMessage(String message){
        System.out.println(message);
    }

    static void litMessage(){
        Main.scanner.next();
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        ecritMessage("Bonjour!");
    }
}
