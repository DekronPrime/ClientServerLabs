package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class AbiturientSet {
    private SortedSet<Abiturient> abiturientSet;

    public AbiturientSet() {
        abiturientSet = new TreeSet<>();
    }

    public AbiturientSet(SortedSet<Abiturient> abiturientSet) {
        this.abiturientSet = abiturientSet;
    }

    public SortedSet<Abiturient> filterAbiturientsByGivenNameAndSortByAveragePoint(String name) {
        Comparator<Abiturient> comparator = Comparator.comparing(Abiturient::getAveragePoint).reversed();
        return abiturientSet.stream()
                .filter(abiturient -> abiturient.getFirstName().equalsIgnoreCase(name))
                .sorted(comparator)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public SortedSet<Abiturient> filterAbiturientsByHigherAveragePoint(double minAveragePoint) {
        return abiturientSet.stream()
                .filter(abiturient -> abiturient.getAveragePoint() > minAveragePoint)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public SortedSet<Abiturient> filterAbiturientsByHostelNeeds() {
        return abiturientSet.stream()
                .filter(Abiturient::isNeedHostel)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public SortedSet<Abiturient> sortAbiturientsByLastameThenByFirstname() {
        Comparator<Abiturient> comparator = Comparator.comparing(Abiturient::getLastName)
                .thenComparing(Abiturient::getFirstName);
        return abiturientSet.stream()
                .sorted(comparator)
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));

    }

    public SortedSet<Integer> sortBirthYears() {
        return abiturientSet.stream()
                .mapToInt(abiturient -> abiturient.getBirthday().getYear())
                .distinct()
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public SortedMap<Integer, Long> countAbiturientsByBirthYear() {
        Map<Integer, Long> countedAbiturients =  abiturientSet.stream()
                .collect(Collectors.groupingBy(
                        abiturient -> abiturient.getBirthday().getYear(),
                        Collectors.counting()
                ));
        return new TreeMap<>(countedAbiturients);
    }

    @Override
    public String toString() {
        return "AbiturientSet{" +
                "abiturientSet=" + abiturientSet +
                '}';
    }
}