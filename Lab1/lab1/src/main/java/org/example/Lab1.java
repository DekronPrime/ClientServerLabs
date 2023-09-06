package org.example;

import java.util.Date;
import java.util.Scanner;

import static java.lang.Math.*;

public class Lab1 {
    private double x = 0.335;
    private double y = 0.025;

    public double findS() {
        return 1 + x + (pow(x,2)/2) + (pow(x,3)/6) + (pow(x,4)/24);
    }
    public double findF() {
        return x * (sin(pow(x,3)) + pow(cos(y),2));
    }
    public void printResults() {
        System.out.println("X = " + x + "\tY = " + y);
        System.out.println("S = " + findS() + "\tF = " + findF());
    }
    public void showDate() {
        Date date = new Date();
        System.out.printf("Current time: %1$tH:%1$tM:%1$tS\n", date);
    }

    public void inputValues() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        x = scanner.nextDouble();
        System.out.print("Enter y: ");
        y = scanner.nextDouble();
    }

    public void doEverything() {
        inputValues();
        printResults();
    }

    public static void main(String[] args) {
        Lab1 lab1 = new Lab1();
        System.out.println("Default result: ");
        lab1.printResults();
        lab1.showDate();
        System.out.println("\nNew result: ");
        lab1.doEverything();
    }
}
