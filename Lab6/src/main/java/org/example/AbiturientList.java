package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AbiturientList implements Serializable {
    private List<Abiturient> abiturients;

    public AbiturientList() {
        this.abiturients = new ArrayList<>();
    }

    public AbiturientList(List<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }

    public void addAbiturient(Abiturient newAbiturient) {
        abiturients.add(newAbiturient);
        System.out.println("New abiturient (" + newAbiturient.getFirstName() + " " + newAbiturient.getLastName() + ") was successfully added");
    }

    public void removeAbiturientByID(long ID) {
        if (containsAbiturient(ID)) {
            abiturients.remove(getAbiturient(ID));
            System.out.println("Abiturient with ID = " + ID + " was successfully removed");
        } else throw new NoSuchElementException("No such abiturient with ID = " + ID + " in list");
    }

    public List<Abiturient> filterAbiturientsByGivenName(String name) {
        List<Abiturient> filteredAbiturients = new ArrayList<>();
        for(Abiturient abiturient: abiturients)
            if (abiturient.getFirstName().equalsIgnoreCase(name))
                filteredAbiturients.add(abiturient);
        if (filteredAbiturients.isEmpty())
            return new ArrayList<>(0);
        return filteredAbiturients;
    }

    public List<Abiturient> filterAbiturientsByAveragePoint(double minAveragePoint) {
        List<Abiturient> filteredAbiturients = new ArrayList<>();
        for(Abiturient abiturient: abiturients)
            if (abiturient.getAveragePoint() > minAveragePoint)
                filteredAbiturients.add(abiturient);
        if (filteredAbiturients.isEmpty())
            return new ArrayList<>(0);
        return filteredAbiturients;
    }

    public List<Abiturient> filterAbiturientsByHostelNeeds() {
        List<Abiturient> filteredAbiturients = new ArrayList<>();
        for(Abiturient abiturient: abiturients)
            if (abiturient.isNeedHostel())
                filteredAbiturients.add(abiturient);
        if (filteredAbiturients.isEmpty())
            return new ArrayList<>(0);
        return filteredAbiturients;
    }

    public Abiturient findAbiturientByID(long ID) {
        if (containsAbiturient(ID))
            return getAbiturient(ID);
        else throw new NoSuchElementException("No such abiturient with ID = " + ID + " in array");
    }

    private boolean containsAbiturient(long ID) {
        boolean containsAbiturient = false;
        for (Abiturient abiturient: abiturients)
            if (abiturient.getID() == ID) {
                containsAbiturient = true;
                break;
            }
        return containsAbiturient;
    }

    private Abiturient getAbiturient(long ID) {
        Abiturient abiturientToFind = null;
        for (Abiturient abiturient: abiturients) {
            if (abiturient.getID() == ID)
                abiturientToFind = abiturient;
        }
        return abiturientToFind;
    }

    public boolean hasAbiturients() {
        return abiturients != null && abiturients.size() > 0;
    }

    @Override
    public String toString() {
        return "AbiturientList{" +
                "abiturients=" + abiturients +
                '}';
    }
}
