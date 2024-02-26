package GOIT_Module_12.Exersice1;

public class Demo {
    public static void main(String[] args) {
        SecondsAfterStart secondAfterStart = new SecondsAfterStart();
        FiveSecondsPeriod fiveSecondPeriod = new FiveSecondsPeriod();

        secondAfterStart.start();
        fiveSecondPeriod.start();
    }
}
