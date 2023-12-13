package org.example;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    public static int showMenuAndChooseAction() {
        System.out.println("---------------------------------------------------------");
        System.out.println("\t\tChoose action from list below:");
        System.out.println("1 - Initialize and insert default abiturients");
        System.out.println("2 - Insert abiturient");
        System.out.println("3 - Select all abiturients");
        System.out.println("4 - Find abiturient by id");
        System.out.println("5 - Filter abiturients by given name");
        System.out.println("6 - Filter abiturients by higher average point than given one");
        System.out.println("7 - Filter abiturients by hostel needs");
        System.out.println("8 - Update abiturient");
        System.out.println("9 - Delete abiturient");
        System.out.println("10 - Delete abiturient by id");
        System.out.println("0 - Exit");
        System.out.println("---------------------------------------------------------");
        System.out.print("Enter your answer: ");
        return scanner.nextInt();
    }
}