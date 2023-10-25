package org.example;

import java.util.*;

public class Main {

    public static AbiturientList createAndInitializeAbiturientsArray() {
        Abiturient abiturient1 = new Abiturient("Newton","Isaac","Isaac","newtonis@gmail.com","85 647 2878",10.4,"1st St., England",true);
        Abiturient abiturient2 = new Abiturient("Einstein","Albert","Hermann","alberton@gmail.com","74 254 3314",10.9,"2nd St., Germany",false);
        Abiturient abiturient3 = new Abiturient("Tesla","Nikola","Milutin","tenicol@gmail.com","25 823 5686",9.4, "3rd St., Austria", true);
        Abiturient abiturient4 = new Abiturient("Edison","Thomas","Samuel","edisomas@gmail.com","59 365 1338",10.0,"4th St., USA",false);
        Abiturient abiturient5 = new Abiturient("Galilei","Galileo","Vincenzo","galilelio@gmail.com","46 172 6438",9.1,"5th St., Italy",false);

        List<Abiturient> abiturients = new ArrayList<>();
        abiturients.add(abiturient1);
        abiturients.add(abiturient2);
        abiturients.add(abiturient3);
        abiturients.add(abiturient4);
        abiturients.add(abiturient5);

        return new AbiturientList(abiturients);
    }

    public static void main(String[] args) {
        AbiturientList abiturients = createAndInitializeAbiturientsArray();
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
                    String name = scanner.nextLine();
                    List<Abiturient> filteredAbiturients = abiturients.filterAbiturientsByGivenName(name);
                    if (!filteredAbiturients.isEmpty())
                        System.out.println(filteredAbiturients);
                    else
                        System.out.println("Abiturients with name = " + name + " are not found");
                }
                case 4 -> {
                    System.out.println("\tFilter abiturients by higher average point than given one");
                    System.out.print("Enter abiturient's average point: ");
                    Double averagePoint = scanner.nextDouble();
                    List<Abiturient> filteredAbiturients = abiturients.filterAbiturientsByAveragePoint(averagePoint);
                    if (!filteredAbiturients.isEmpty())
                        System.out.println(filteredAbiturients);
                    else
                        System.out.println("Abiturients with average point = " + averagePoint + " are not found");
                }
                case 5 -> {
                    System.out.println("\tFilter abiturients by hostel needs");
                    List<Abiturient> filteredAbiturients = abiturients.filterAbiturientsByHostelNeeds();
                    if (!filteredAbiturients.isEmpty())
                        System.out.println(filteredAbiturients);
                    else
                        System.out.println("Abiturients with hostel needs = true are not found");
                }
                case 6 -> {
                    System.out.println("\tSave abiturients to a text file");
                    textFileHandler.saveAbiturients(abiturients);
                }
                case 7 -> {
                    System.out.println("\tLoad abiturients from a text file");
                    AbiturientList loadedAbiturients = textFileHandler.loadAbiturients();
                    if (loadedAbiturients.hasAbiturients())
                        System.out.println(loadedAbiturients);
                }
                case 8 -> {
                    System.out.println("\tSave abiturients to a binary file");
                    binaryFileHandler.saveAbiturients(abiturients);
                }
                case 9 -> {
                    System.out.println("\tLoad abiturients from a binary file");
                    AbiturientList loadedAbiturients = binaryFileHandler.loadAbiturients();
                    if (loadedAbiturients.hasAbiturients())
                        System.out.println(loadedAbiturients);
                }
                case 10 -> {
                    System.out.println("\tFind abiturient by ID");
                    System.out.print("Enter abiturient's ID: ");
                    long enteredId = scanner.nextLong();
                    try {
                        Abiturient abiturient = abiturients.findAbiturientByID(enteredId);
                        System.out.println(abiturient);
                        System.out.println("Remove abiturient? (by default: no)\n1 - Yes\n0 - No");
                        System.out.print("Answer: ");
                        int option = scanner.nextInt();
                        if (option == 1)
                            abiturients.removeAbiturientByID(enteredId);
                    } catch (NoSuchElementException e) {
                        System.err.println("Error! " + e.getMessage());
                    }
                }
                case 11 -> {
                    System.out.println("\tPrint current abiturients list");
                    System.out.println(abiturients);
                }
                case 0 -> System.out.println("I'll be back!");

                default -> System.out.println("Wrong option! Try again.");
            }
        } while (answer != 0);
    }
}