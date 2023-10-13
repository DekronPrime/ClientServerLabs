package org.example;

import java.io.Serializable;
import java.util.*;

public class AbiturientArray implements Serializable {
    private Abiturient[] abiturients;
    public AbiturientArray() {
        this.abiturients = new Abiturient[0];
    }
    public AbiturientArray (Abiturient[] abiturients) {
        this.abiturients = abiturients;
    }
    public Abiturient[] createEmptyArray() { return new Abiturient[100]; }
    public void addAbiturient(Abiturient newAbiturient) {
        if (isFullArray())
            expandArray();
        abiturients[abiturients.length - 1] = newAbiturient;
        System.out.println("New abiturient (" + newAbiturient.getFirstName() + " " + newAbiturient.getLastName() + ") was successfully added");
    }
    public void removeAbiturientByID(long ID) throws NoSuchElementException {
        if (isArrayContainsID(ID)) {
            for (int i = 0; i < abiturients.length; i++)
                if (abiturients[i].getID() == ID) {
                    abiturients[i] = null;
                    break;
                }
            if (!isFullArray())
                shrinkArray();
            System.out.println("Abiturient with ID = " + ID + " was successfully removed");
        } else throw new NoSuchElementException("No such abiturient with ID = " + ID + " in array");
    }
    public Abiturient[] filterAbiturientsByGivenName(String name) {
        List<Abiturient> filteredAbiturients = new ArrayList<>();
        for(Abiturient abiturient: abiturients)
            if (abiturient.getFirstName().equalsIgnoreCase(name))
                filteredAbiturients.add(abiturient);
        if (filteredAbiturients.isEmpty())
            return new Abiturient[0];
        return filteredAbiturients.toArray(new Abiturient[0]);
    }
    public Abiturient[] filterAbiturientsByAveragePoint(double minAveragePoint) {
        List<Abiturient> filteredAbiturients = new ArrayList<>();
        for(Abiturient abiturient: abiturients)
            if (abiturient.getAveragePoint() > minAveragePoint)
                filteredAbiturients.add(abiturient);
        if (filteredAbiturients.isEmpty())
            return new Abiturient[0];
        return filteredAbiturients.toArray(new Abiturient[0]);
    }
    public Abiturient[] filterAbiturientsByHostelNeeds() {
        List<Abiturient> filteredAbiturients = new ArrayList<>();
        for(Abiturient abiturient: abiturients)
            if (abiturient.isNeedHostel())
                filteredAbiturients.add(abiturient);
        if (filteredAbiturients.isEmpty())
            return new Abiturient[0];
        return filteredAbiturients.toArray(new Abiturient[0]);
    }
    public static void printFilteredAbiturients(Abiturient[] filteredAbiturients) {
        if (filteredAbiturients.length > 0) {
            System.out.println("Filtered abiturients:");
            for (Abiturient abiturient: filteredAbiturients)
                System.out.println(abiturient);
        } else
            System.out.println("No abiturients found");
    }
    public boolean hasAbiturients() {
        return abiturients != null && abiturients.length > 0;
    }
    private boolean isFullArray() {
        for (int i = 0; i < abiturients.length; i++)
            if (abiturients[i] == null)
                return false;
        return true;
    }
    private void expandArray() {
        abiturients = Arrays.copyOf(abiturients, abiturients.length + 1);
    }
    private void shrinkArray() {
        int shrinkedArrayIndex = 0;
        Abiturient[] shrinkedArray = new Abiturient[abiturients.length - 1];
        for (Abiturient abiturient : abiturients)
            if (abiturient != null) {
                shrinkedArray[shrinkedArrayIndex] = abiturient;
                shrinkedArrayIndex++;
            }
        abiturients = shrinkedArray;
    }
    private boolean isArrayContainsID(long ID) {
        boolean isIdExists = false;
        for (Abiturient abiturient: abiturients)
            if (abiturient.getID() == ID)
                return true;
        return isIdExists;
    }
    @Override
    public String toString() {
        return "AbiturientArray { \n" +
                "abiturients = " + Arrays.toString(abiturients) +
                "\n}";
    }
}
