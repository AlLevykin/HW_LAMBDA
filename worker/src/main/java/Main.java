package main.java;

import netology.OnTaskDoneListener;
import netology.Worker;

public class Main {
    public static void main() {
        OnTaskDoneListener listener = System.out::println;
        Worker worker = new Worker(listener);
        worker.start();
    }
}
