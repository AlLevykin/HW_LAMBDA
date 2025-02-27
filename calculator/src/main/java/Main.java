package main.java;

import netology.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(2, 1);
        int c;
        try {
            c = calc.divide.apply(a, b);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        Calculator.println.accept(c);
    }
}
