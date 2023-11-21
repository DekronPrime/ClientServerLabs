package org.example;

import java.util.Scanner;

public class Menu {

    public static int showMenuAndChooseAction() {
        System.out.println("---------------------------------------------------------");
        System.out.println("\t\tChoose action from list below:");
        System.out.println("1 - Add new abiturient");
        System.out.println("2 - Remove abiturient by ID");
        System.out.println("3 - Filter abiturients by given name");
        System.out.println("4 - Filter abiturients by higher average point than given one");
        System.out.println("5 - Filter abiturients by hostel needs");
        System.out.println("6 - Save abiturients to a text file");
        System.out.println("7 - Load abiturients from a text file");
        System.out.println("8 - Save abiturients to a binary file");
        System.out.println("9 - Load abiturients from a binary file");
        System.out.println("10 - Find abiturient by ID");
        System.out.println("11 - Print current abiturients list");
        System.out.println("0 - Exit");
        System.out.println("---------------------------------------------------------");
        System.out.print("Enter your answer: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
