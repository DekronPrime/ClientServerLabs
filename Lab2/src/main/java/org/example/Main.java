package org.example;

import com.example.Abiturient;

import java.util.Locale;
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
            if (abiturients[i].getFirstName().equalsIgnoreCase(name)) {
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
        for (int i = 0; i < abiturients.length; i++) {
            if (abiturients[i].getAveragePoint() > averagePoint) {
                System.out.println(abiturients[i]);
                howMuch++;
            }
        }
        if (howMuch == 0)
            System.out.println("Abiturients with higher average point than " + averagePoint + " is not found");
    }

    public static void printNTopAbiturients(Abiturient[] abiturients, int n) {
        Abiturient[] sortedAbiturientsArray = sortArrayByAveragePointDesc(abiturients);
        for (int i = 0; i < sortedAbiturientsArray.length; i++) {
            System.out.println(sortedAbiturientsArray[i]);
        }
        System.out.println("Top " + n + " Abiturients list with higher average point:\n");
        for (int i = 0; i < n; i++) {
            System.out.println(sortedAbiturientsArray[i]);
        }
    }

    private static Abiturient[] sortArrayByAveragePointDesc(Abiturient[] abiturients) {
        Abiturient[] sortedAbiturientsArray = abiturients.clone();
        for (int i = 0; i < sortedAbiturientsArray.length - 1; i++) {
            for (int j = i + 1; j < sortedAbiturientsArray.length; j++) {
                if (sortedAbiturientsArray[i].getAveragePoint() < sortedAbiturientsArray[j].getAveragePoint()) {
                    Abiturient temp = sortedAbiturientsArray[i];
                    sortedAbiturientsArray[i] = sortedAbiturientsArray[j];
                    sortedAbiturientsArray[j] = temp;
                }
            }
        }
        return  sortedAbiturientsArray;
    }

    public static void main(String[] args) {
        Abiturient[] abiturients = createAndInitializeAbiturientsArray();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int answer;
        do {
            answer = Menu.showMenuAndChooseOption();
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
                    System.out.print("Enter number of top abiturients (0 > n < 6): ");
                    int n = scanner.nextInt();
                    if (n < 0 || n > 5)
                        System.out.println("Number n is out of range (0 > n < 6)");
                    else
                        printNTopAbiturients(abiturients, n);
                }
                case 4 -> System.out.println("\tBye");
                default -> System.out.println("Wrong option! Try again.");
            }
        } while (answer != 4);
        System.exit(0);
    }
}