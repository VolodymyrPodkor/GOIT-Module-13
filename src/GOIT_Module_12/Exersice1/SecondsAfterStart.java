package GOIT_Module_12.Exersice1;

public class SecondsAfterStart extends Thread {

    private int second;
    @Override
    public void run() {
        while (true){
            try {
                second++;
                Thread.sleep(1000L);
                System.out.println("Час з моменту запуску програми " + second + " секунд");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
