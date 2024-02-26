package GOIT_Module_12.Exersice2;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        FizzBuzzDemo fizzBuzzDemo = new FizzBuzzDemo(n);

        Thread threadA = new Thread(() -> fizzBuzzDemo.fizz());
        Thread threadB = new Thread(() -> fizzBuzzDemo.buzz());
        Thread threadC = new Thread(() -> fizzBuzzDemo.fizzbuzz());
        Thread threadD = new Thread(() -> fizzBuzzDemo.number());

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }
}
