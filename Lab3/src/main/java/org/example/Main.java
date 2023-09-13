package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter original text: ");
        String enteredText = scanner.nextLine();
        System.out.print("Enter a string to replace the words: ");
        String replacementString = scanner.nextLine();
        System.out.print("Enter the length of the words you want to replace: ");
        int wordLength = scanner.nextInt();

        Task task = new Task(enteredText, replacementString, wordLength);
        StringBuilder result = task.changeSpecialWordsToReplacementString();
        System.out.println(result + "\n");

        scanner.nextLine();
        System.out.print("Enter a password for validating: ");
        String password = scanner.nextLine();
        try {
            if (Task.checkPassword(password))
                System.out.println("Your password is valid");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}