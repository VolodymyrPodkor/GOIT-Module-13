package GOIT_Module_12.Exersice1;

public class FiveSecondsPeriod extends Thread{

    private final int FIVE_SECONDS = 5;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000L);
                System.out.println("Минуло " + FIVE_SECONDS + " секунд.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
