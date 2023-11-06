package org.example;

import java.util.Scanner;

public class Menu {
    public static int showMenuAndChooseAction() {
        System.out.println("---------------------------------------------------------");
        System.out.println("\t\tChoose action from list below:");
        System.out.println("1 - Create table with necessary fields");
        System.out.println("2 - Initialize and insert default abiturients");
        System.out.println("3 - Insert a single abiturient");
        System.out.println("4 - Select all abiturients");
        System.out.println("5 - Find abiturient by id");
        System.out.println("6 - Update abiturient");
        System.out.println("7 - Delete one or many abiturients");
        System.out.println("8 - Delete abiturient by id");
        System.out.println("9 - Drop table");
        System.out.println("0 - Exit");
        System.out.println("---------------------------------------------------------");
        System.out.print("Enter your answer: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}