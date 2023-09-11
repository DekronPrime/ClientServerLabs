package org.example;

import com.example.Abiturient;

import java.util.Scanner;

public class Main {

    public static Abiturient[] createAndInitializeAbiturientsArray() {
        Abiturient[] abiturients = new Abiturient[5];

        abiturients[0] = new Abiturient(156874,"Newton","Isaac","Isaac","1st St., England","85 647 2878",10.4);
        abiturients[1] = new Abiturient(287946,"Einstein","Albert","Hermann","2nd St., Germany","74 254 3314",10.9);
        abiturients[2] = new Abiturient(175287,"Tesla","Nikola","Milutin","3rd St., Austria","25 823 5686",9.4);
        abiturients[3] = new Abiturient(989435,"Edison","Thomas","Samuel","4th St., USA","59 365 1338",10.0);
        abiturients[4] = new Abiturient(578216,"Galilei","Galileo","Vincenzo","5th St., Italy","46 172 6438",9.1);

        return abiturients;
    }

    public static void printAbiturientsWithGivenName(Abiturient[] abiturients, String name) {
        System.out.println("Abiturients list with name " + name + ":\n");
        int howMuch = 0;
        for (int i = 0; i < abiturients.length - 1; i++) {
            if (abiturients[i].getFirstName().equals(name)) {
                System.out.println(abiturients[i]);
                howMuch++;
            }
        }
        if (howMuch == 0)
            System.out.println("Abiturients with name " + name + " is not found");
    }
    public static void printAbiturientsWithHigherAveragePoint(Abiturient[] abiturients, double averagePoint) {
        System.out.println("Abiturients list with higher average point than " + averagePoint + ":\n");
        int howMuch = 0;
        for (int i = 0; i < abiturients.length - 1; i++) {
            if (abiturients[i].getAveragePoint() > averagePoint) {
                System.out.println(abiturients[i]);
                howMuch++;
            }
        }
        if (howMuch == 0)
            System.out.println("Abiturients with higher average point than " + averagePoint + " is not found");
    }

    public static void printNTopAbiturients(Abiturient[] abiturients, int n) {
        sortArrayByAveragePointDesc(abiturients);
        System.out.println("Top " + n + " Abiturients list with higher average point:\n");
        for (int i = 0; i < n; i++) {
            System.out.println(abiturients[i]);
        }
        if (abiturients == null)
            System.out.println("Abiturients list is empty");
    }

    private static void sortArrayByAveragePointDesc(Abiturient[] abiturients) {
        for (int i = 0; i < abiturients.length - 1; i++) {
            for (int j = i + 1; j < abiturients.length; j++) {
                if (abiturients[i].getAveragePoint() < abiturients[j].getAveragePoint()) {
                    Abiturient temp = abiturients[i];
                    abiturients[i] = abiturients[j];
                    abiturients[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Abiturient[] abiturients = createAndInitializeAbiturientsArray();
        int answer;
        do {
            answer = Menu.showMenu();
            Scanner scanner = new Scanner(System.in);
            switch (answer) {
                case 1 -> {
                    System.out.println("\tPrint abiturients with given name");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    printAbiturientsWithGivenName(abiturients, name);
                }
                case 2 -> {
                    System.out.println("\tPrint abiturients with higher average point than given one");
                    System.out.print("Enter average point: ");
                    double averagePoint = scanner.nextDouble();
                    printAbiturientsWithHigherAveragePoint(abiturients, averagePoint);
                }
                case 3 -> {
                    System.out.println("\tPrint top N abiturients");
                    int n;
                    do {
                        System.out.print("Enter N: ");
                        n = scanner.nextInt();
                    } while (n > abiturients.length || n < 0);
                    printNTopAbiturients(abiturients, n);
                }
                case 4 -> System.out.println("\tBye");
                default -> System.out.println("Wrong option! Try again.");
            }
        } while (answer != 4);
        System.exit(0);
    }
}