package org.example;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static AbiturientSet createAndInitializeAbiturientSet() {
        Abiturient abiturient1 = new Abiturient("Newton", "Isaac", "Isaac", LocalDate.of(1864, 8, 22), "newtonis@gmail.com", "85 647 2878", 10.4, "1st St., England", true);
        Abiturient abiturient2 = new Abiturient("Einstein", "Albert", "Hermann", LocalDate.of(1910, 5, 14), "alberton@gmail.com", "74 254 3314", 10.9, "2nd St., Germany", false);
        Abiturient abiturient3 = new Abiturient("Tesla", "Nikola", "Milutin", LocalDate.of(1678, 11, 8), "tenicol@gmail.com", "25 823 5686", 9.4, "3rd St., Austria", true);
        Abiturient abiturient4 = new Abiturient("Edison", "Isaac", "Samuel", LocalDate.of(1889, 5, 21), "edisomas@gmail.com", "59 365 1338", 10.0, "4th St., USA", false);
        Abiturient abiturient5 = new Abiturient("Galilei", "Galileo", "Vincenzo", LocalDate.of(1547, 6, 19), "galilelio@gmail.com", "46 172 6438", 9.1, "5th St., Italy", false);

        SortedSet<Abiturient> abiturientSet = new TreeSet<>();
        abiturientSet.add(abiturient1);
        abiturientSet.add(abiturient2);
        abiturientSet.add(abiturient3);
        abiturientSet.add(abiturient4);
        abiturientSet.add(abiturient5);

        return new AbiturientSet(abiturientSet);
    }

    public static void main(String[] args) {
        AbiturientSet abiturientSet = createAndInitializeAbiturientSet();
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
                    abiturientSet.addAbiturient(newAbiturient);
                }
                case 2 -> {
                    System.out.println("\tRemove abiturient by ID");
                    System.out.println(abiturientSet);
                    System.out.print("Enter abiturient's ID to remove: ");
                    try {
                        abiturientSet.removeAbiturientByID(scanner.nextLong());
                    } catch (NoSuchElementException e) {
                        System.err.println("Error! " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("\tFilter abiturients by given name");
                    System.out.print("Enter abiturient's name: ");
                    String name = scanner.nextLine();
                    SortedSet<Abiturient> filteredAndSortedAbiturients = abiturientSet.filterAbiturientsByGivenNameAndSortByAveragePoint(name);
                    if (!filteredAndSortedAbiturients.isEmpty())
                        System.out.println(filteredAndSortedAbiturients);
                    else
                        System.out.println("Abiturients with name = " + name + " are not found");
                }
                case 4 -> {
                    System.out.println("\tFilter abiturients by higher average point than given one");
                    System.out.print("Enter abiturient's average point: ");
                    Double averagePoint = scanner.nextDouble();
                    SortedSet<Abiturient> filteredAbiturients = abiturientSet.filterAbiturientsByHigherAveragePoint(averagePoint);
                    if (!filteredAbiturients.isEmpty())
                        System.out.println(filteredAbiturients);
                    else
                        System.out.println("Abiturients with average point = " + averagePoint + " are not found");
                }
                case 5 -> {
                    System.out.println("\tFilter abiturients by hostel needs");
                    SortedSet<Abiturient> filteredAbiturients = abiturientSet.filterAbiturientsByHostelNeeds();
                    if (!filteredAbiturients.isEmpty())
                        System.out.println(filteredAbiturients);
                    else
                        System.out.println("Abiturients with hostel needs = true are not found");
                }
                case 6 -> {
                    System.out.println("\tSort abiturients by lastname, then by fistname");
                    SortedSet<Abiturient> sortedAbiturients = abiturientSet.sortAbiturientsByNameThenByAge();
                    if (!sortedAbiturients.isEmpty())
                        System.out.println(sortedAbiturients);
                    else
                        System.out.println("Abiturients are not found");
                }
                case 7 -> {
                    System.out.println("\tSort birth years");
                    SortedSet<Integer> years = abiturientSet.sortBirthYears();
                    if (!years.isEmpty()) {
                        System.out.println("Birth years:");
                        for (Integer year : years)
                            System.out.println(year);
                    } else
                        System.out.println("Abiturients are not found");
                }
                case 8 -> {
                    System.out.println("Abiturients count by birth year");
                    SortedMap<Integer, Integer> abiturientsCount = abiturientSet.countAbiturientsByBirthYear();
                    if (!abiturientsCount.isEmpty()) {
                        System.out.println("Birth year\tcount");
                        for (Map.Entry<Integer, Integer> entry : abiturientsCount.entrySet())
                            System.out.println(entry.getKey() + "\t" + entry.getValue());
                    } else
                        System.out.println("Abiturients are not found");
                }
                case 9 -> {
                    System.out.println("\tSave abiturients to a text file");
                    textFileHandler.saveAbiturients(abiturientSet);
                }
                case 10 -> {
                    System.out.println("\tLoad abiturients from a text file");
                    AbiturientSet loadedAbiturients = textFileHandler.loadAbiturients();
                    if (loadedAbiturients.hasAbiturients())
                        System.out.println(loadedAbiturients);
                }
                case 11 -> {
                    System.out.println("\tSave abiturients to a binary file");
                    binaryFileHandler.saveAbiturients(abiturientSet);
                }
                case 12 -> {
                    System.out.println("\tLoad abiturients from a binary file");
                    AbiturientSet loadedAbiturients = binaryFileHandler.loadAbiturients();
                    if (loadedAbiturients.hasAbiturients())
                        System.out.println(loadedAbiturients);
                }
                case 13 -> {
                    System.out.println("\tFind abiturient by ID");
                    System.out.print("Enter abiturient's ID: ");
                    long enteredId = scanner.nextLong();
                    try {
                        Abiturient abiturient = abiturientSet.findAbiturientByID(enteredId);
                        System.out.println(abiturient);
                        System.out.println("Remove abiturient? (by default: no)\n1 - Yes\n0 - No");
                        System.out.print("Answer: ");
                        int option = scanner.nextInt();
                        if (option == 1)
                            abiturientSet.removeAbiturientByID(enteredId);
                    } catch (NoSuchElementException e) {
                        System.err.println("Error! " + e.getMessage());
                    }
                }
                case 14 -> {
                    System.out.println("\tPrint current abiturients list");
                    System.out.println(abiturientSet);
                }
                case 0 -> System.out.println("I'll be back!");

                default -> System.out.println("Wrong option! Try again.");
            }
        } while (answer != 0);
    }
}