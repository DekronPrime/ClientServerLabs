package org.example;

import java.util.*;

public class Main {
    public static AbiturientArray createAndInitializeAbiturientsArray() {
        Abiturient abiturient1 = new Abiturient("Newton","Isaac","Isaac","newtonis@gmail.com","85 647 2878",10.4,"1st St., England",true);
        Abiturient abiturient2 = new Abiturient("Einstein","Albert","Hermann","alberton@gmail.com","74 254 3314",10.9,"2nd St., Germany",false);
        Abiturient abiturient3 = new Abiturient("Tesla","Nikola","Milutin","tenicol@gmail.com","25 823 5686",9.4, "3rd St., Austria", true);
        Abiturient abiturient4 = new Abiturient("Edison","Thomas","Samuel","edisomas@gmail.com","59 365 1338",10.0,"4th St., USA",false);
        Abiturient abiturient5 = new Abiturient("Galilei","Galileo","Vincenzo","galilelio@gmail.com","46 172 6438",9.1,"5th St., Italy",false);

        Abiturient[] abiturients = new Abiturient[5];
        abiturients[0] = abiturient1;
        abiturients[1] = abiturient2;
        abiturients[2] = abiturient3;
        abiturients[3] = abiturient4;
        abiturients[4] = abiturient5;

        return new AbiturientArray(abiturients);
    }

    public static void main(String[] args) {
        AbiturientArray abiturients = createAndInitializeAbiturientsArray();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int answer;
        final String textFilename = "Abiturients.txt";
        final String binaryFilename = "Abiturients.dat";
        TextFileHandler textFileHandler = new TextFileHandler(textFilename);
        BinaryFileHandler binaryFileHandler = new BinaryFileHandler(binaryFilename);
        do {
            answer = Menu.showMenuAndChooseAction();
            switch (answer) {
                case 1 -> {
                    System.out.println("\tAdd new abiturient");
                    Abiturient newAbiturient = Abiturient.createNewAbiturient();
                    abiturients.addAbiturient(newAbiturient);
                }
                case 2 -> {
                    System.out.println("\tRemove abiturient by ID");
                    System.out.println(abiturients);
                    System.out.print("Enter abiturient's ID to remove: ");
                    try {
                        abiturients.removeAbiturientByID(scanner.nextLong());
                    } catch (NoSuchElementException e) {
                        System.err.println("Error! " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("\tFilter abiturients by given name");
                    System.out.print("Enter abiturient's name: ");
                    Abiturient[] filteredAbiturients = abiturients.filterAbiturientsByGivenName(scanner.nextLine());
                    AbiturientArray.printFilteredAbiturients(filteredAbiturients);
                }
                case 4 -> {
                    System.out.println("\tFilter abiturients by higher average point than given one");
                    System.out.print("Enter abiturient's average point: ");
                    Abiturient[] filteredAbiturients = abiturients.filterAbiturientsByAveragePoint(scanner.nextDouble());
                    AbiturientArray.printFilteredAbiturients(filteredAbiturients);
                }
                case 5 -> {
                    System.out.println("\tFilter abiturients by hostel needs");
                    Abiturient[] filteredAbiturients = abiturients.filterAbiturientsByHostelNeeds();
                    AbiturientArray.printFilteredAbiturients(filteredAbiturients);
                }
                case 6 -> {
                    System.out.println("\tSave abiturients to a text file");
                    textFileHandler.saveAbiturients(abiturients);
                }
                case 7 -> {
                    System.out.println("\tLoad abiturients from a text file");
                    AbiturientArray loadedAbiturients = textFileHandler.loadAbiturients();
                    if (loadedAbiturients.hasAbiturients())
                        System.out.println(loadedAbiturients);
                }
                case 8 -> {
                    System.out.println("\tSave abiturients to a binary file");
                    binaryFileHandler.saveAbiturients(abiturients);
                }
                case 9 -> {
                    System.out.println("\tLoad abiturients from a binary file");
                    AbiturientArray loadedAbiturients = binaryFileHandler.loadAbiturients();
                    if (loadedAbiturients.hasAbiturients())
                        System.out.println(loadedAbiturients);
                }
                case 10 -> {
                    System.out.println("\tPrint current abiturients array");
                    System.out.println(abiturients);
                }
                case 0 -> System.out.println("Bye");

                default -> System.out.println("Wrong option! Try again.");
            }
        } while (answer != 0);
    }
}