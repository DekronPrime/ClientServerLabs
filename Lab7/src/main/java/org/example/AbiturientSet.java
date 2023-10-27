package org.example;

import com.sun.source.tree.Tree;

import java.net.SocketException;
import java.util.*;

public class AbiturientSet {
    private SortedSet<Abiturient> abiturientSet;

    public AbiturientSet() {
        abiturientSet = new TreeSet<>();
    }

    public AbiturientSet(SortedSet<Abiturient> abiturientSet) {
        this.abiturientSet = abiturientSet;
    }

    public void addAbiturient(Abiturient newAbiturient) {
        abiturientSet.add(newAbiturient);
        System.out.println("New abiturient (" + newAbiturient.getFirstName() + " " + newAbiturient.getLastName() + ") was successfully added");
    }

    public void removeAbiturientByID(long ID) {
        if (containsAbiturient(ID)) {
            abiturientSet.remove(getAbiturient(ID));
            System.out.println("Abiturient with ID = " + ID + " was successfully removed");
        } else throw new NoSuchElementException("No such abiturient with ID = " + ID + " in set");
    }

    public SortedSet<Abiturient> filterAbiturientsByGivenNameAndSortByAveragePoint(String name) {
        SortedSet<Abiturient> filteredAndSortedAbiturientSet = new TreeSet<>(new Comparator<Abiturient>() {
            @Override
            public int compare(Abiturient o1, Abiturient o2) {
                return Double.compare(o2.getAveragePoint(), o1.getAveragePoint());
            }
        });
        for (Abiturient abiturient : abiturientSet)
            if (abiturient.getFirstName().equalsIgnoreCase(name))
                filteredAndSortedAbiturientSet.add(abiturient);
        return filteredAndSortedAbiturientSet;
    }

    public SortedSet<Abiturient> filterAbiturientsByHigherAveragePoint(double minAveragePoint) {
        SortedSet<Abiturient> filteredAbiturientSet = new TreeSet<>();
        for (Abiturient abiturient : abiturientSet)
            if (abiturient.getAveragePoint() > minAveragePoint)
                filteredAbiturientSet.add(abiturient);
        return filteredAbiturientSet;
    }

    public SortedSet<Abiturient> filterAbiturientsByHostelNeeds() {
        SortedSet<Abiturient> filteredAbiturients = new TreeSet<>();
        for (Abiturient abiturient : abiturientSet)
            if (abiturient.isNeedHostel())
                filteredAbiturients.add(abiturient);
        return filteredAbiturients;
    }

    public SortedSet<Abiturient> sortAbiturientsByNameThenByAge() {
        Comparator<Abiturient> comparator = new Comparator<Abiturient>() {
            @Override
            public int compare(Abiturient o1, Abiturient o2) {
                return o1.getLastName().compareToIgnoreCase(o2.getLastName());
            }
        }.thenComparing(new Comparator<Abiturient>() {
            @Override
            public int compare(Abiturient o1, Abiturient o2) {
                return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
            }
        });
        SortedSet<Abiturient> newAbiturientSet = new TreeSet<>(comparator);
        newAbiturientSet.addAll(abiturientSet);
        return newAbiturientSet;
    }

    public SortedSet<Integer> sortBirthYears() {
        SortedSet<Integer> years = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (Abiturient abiturient: abiturientSet)
            years.add(abiturient.getBirthday().getYear());
        return years;
    }

    public SortedMap<Integer, Integer> countAbiturientsByBirthYear() {
        SortedSet<Integer> years = sortBirthYears();
        SortedMap<Integer, Integer> abiturientsCount = new TreeMap<>();
        for (Integer year : years)
            abiturientsCount.put(year, 0);
        for (Abiturient abiturient : abiturientSet) {
            int birthYear = abiturient.getBirthday().getYear();
            int countInMap = abiturientsCount.get(birthYear);
            abiturientsCount.put(birthYear, countInMap + 1);
        }
        return abiturientsCount;
    }

    public Abiturient findAbiturientByID(long ID) {
        if (containsAbiturient(ID))
            return getAbiturient(ID);
        else throw new NoSuchElementException("No such abiturient with ID = " + ID + " in array");
    }

    public boolean hasAbiturients() {
        return abiturientSet != null && !abiturientSet.isEmpty();
    }

    private boolean containsAbiturient(long ID) {
        boolean containsAbiturient = false;
        for (Abiturient abiturient : abiturientSet)
            if (abiturient.getID() == ID) {
                containsAbiturient = true;
                break;
            }
        return containsAbiturient;
    }

    private Abiturient getAbiturient(long ID) {
        Abiturient abiturientToFind = null;
        for (Abiturient abiturient : abiturientSet)
            if (abiturient.getID() == ID) {
                abiturientToFind = abiturient;
                break;
            }
        return abiturientToFind;
    }

    @Override
    public String toString() {
        return "AbiturientSet{" +
                "abiturientSet=" + abiturientSet +
                '}';
    }
}
