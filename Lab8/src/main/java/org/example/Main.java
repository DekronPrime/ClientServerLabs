package org.example;

import java.time.LocalDate;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static AbiturientSet createAndInitializeAbiturientSet() {
        Abiturient abiturient1 = new Abiturient("Newton", "Isaac", "Isaac", LocalDate.of(1864, 8, 22), "newtonis@gmail.com", "8 647 2878", 10.4, "1st St., England", true);
        Abiturient abiturient2 = new Abiturient("Edison", "Albert", "Hermann", LocalDate.of(1910, 5, 14), "alberton@gmail.com", "74 254 3314", 10.9, "2nd St., Germany", false);
        Abiturient abiturient3 = new Abiturient("Tesla", "Nikola", "Milutin", LocalDate.of(1678, 11, 8), "tenicol@gmail.com", "25 823 5686", 9.4, "3rd St., Austria", true);
        Abiturient abiturient4 = new Abiturient("Edison", "Isaac", "Samuel", LocalDate.of(1889, 5, 21), "edisomas@gmail.com", "59 365 1338", 10.0, "4th St., USA", false);
        Abiturient abiturient5 = new Abiturient("Galilei", "Galileo", "Vincenzo", LocalDate.of(1889, 6, 19), "galilelio@gmail.com", "46 172 6438", 9.1, "5th St., Italy", false);

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

        System.out.println("\n\tAbiturients with name Isaac:");
        SortedSet<Abiturient> filteredAbiturientsByGivenName = abiturientSet.filterAbiturientsByGivenNameAndSortByAveragePoint("Isaac");
        System.out.println(filteredAbiturientsByGivenName);

        System.out.println("\n\tAbiturients with average point higher then 9.9:");
        SortedSet<Abiturient> filteredAbiturientsByAveragePoint = abiturientSet.filterAbiturientsByHigherAveragePoint(9.9);
        System.out.println(filteredAbiturientsByAveragePoint);

        System.out.println("\n\tAbiturients with hostel needs:");
        SortedSet<Abiturient> filteredAbiturientsByHostelNeeds = abiturientSet.filterAbiturientsByHostelNeeds();
        System.out.println(filteredAbiturientsByHostelNeeds);

        System.out.println("\n\tSort abiturients by lastname, then sort by firstname:");
        SortedSet<Abiturient> sortedAbiturientsByLastnameThenByFirstname = abiturientSet.sortAbiturientsByLastameThenByFirstname();
        System.out.println(sortedAbiturientsByLastnameThenByFirstname);

        System.out.println("\n\tSort birth years:");
        SortedSet<Integer> sortedBirthYears = abiturientSet.sortBirthYears();
        System.out.println(sortedBirthYears);

        System.out.println("\n\tCount abiturients by birth year:");
        System.out.println("Year\tCount");
        SortedMap<Integer, Long> countedAbiturients = abiturientSet.countAbiturientsByBirthYear();
        for (Map.Entry<Integer, Long> entry : countedAbiturients.entrySet())
            System.out.println(entry.getKey() + "\t" + entry.getValue());
    }
}