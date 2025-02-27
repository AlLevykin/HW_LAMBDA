package main.java;

import java.util.function.Consumer;
import netology.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(2, 1);
        int c = calc.divide.apply(a, b);
        Consumer<Integer> p = calc.println;
        p.accept(c);
    }
}
