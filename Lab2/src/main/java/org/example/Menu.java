package org.example;

import java.util.Scanner;
public class Menu {
    public static int showMenuAndChooseOption() {
        System.out.println("---------------------------------------------------------");
        System.out.println("\t\tChoose operation from list below:");
        System.out.println("1 - Print abiturients with given name");
        System.out.println("2 - Print abiturients with higher average point than given one");
        System.out.println("3 - Print top N abiturients");
        System.out.println("4 - Exit");
        System.out.println("---------------------------------------------------------");
        System.out.print("Enter your answer: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }
}
