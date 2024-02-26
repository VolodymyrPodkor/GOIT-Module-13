package GOIT_Module_12.Exersice2;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzDemo {
    private int n;
    private int count = 1;
    private Object lock = new Object();

    public FizzBuzzDemo(int n){
        this.n = n;
    }

    public void fizz()  {
        synchronized (lock) {
            while (count <= n) {
                if (count % 3 == 0 && count % 5 != 0) {
                    System.out.print("Fizz");
                    if(count < n){
                        System.out.print(", ");
                    }
                    else {
                        System.out.print("");
                    }
                    count++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void buzz(){
        synchronized (lock) {
            while (count <= n) {
                if (count % 5 == 0 && count % 3 != 0) {
                    System.out.print("Buzz");
                    if(count < n){
                        System.out.print(", ");
                    }
                    else {
                        System.out.print("");
                    }
                    count++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void fizzbuzz(){
        synchronized (lock) {
            while (count <= n) {
                if (count % 5 == 0 && count % 3 == 0) {
                    System.out.print("FizzBuzz");
                    if(count < n){
                        System.out.print(", ");
                    }
                    else {
                        System.out.print("");
                    }
                    count++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void number() {
        synchronized (lock) {
            while (count <= n) {
                if (count % 5 != 0 && count % 3 != 0) {
                    System.out.print(count);
                    if(count < n){
                        System.out.print(", ");
                    }
                    count++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
