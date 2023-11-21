package org.example;

import jakarta.persistence.*;
import org.example.entities.Abiturient;

import java.util.*;

public class Main {
    private static final String PERSISTENCE_UNIT = "lab10.jpa";
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = getEntityManagerFactory();
        AbiturientDAO abiturientDAO = new AbiturientDAO(emf);
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int answer;
        do {
            answer = Menu.showMenuAndChooseAction();
            try {
                switch (answer) {
                    case 1 -> {
                        System.out.println("\t1 - Initialize and insert default abiturients");
                        List<Abiturient> abiturients = createAndInitializeAbiturients();
                        for (Abiturient abiturient: abiturients)
                            abiturientDAO.insert(abiturient);
                        System.out.println("Default abiturients successfully inserted");
                    }
                    case 2 -> {
                        System.out.println("\t2 - Insert abiturient");
                        Abiturient abiturient = Abiturient.initializeAbiturient();
                        abiturientDAO.insert(abiturient);
                        System.out.println("New abiturient successfully inserted");
                    }
                    case 3 -> {
                        System.out.println("\t3 - Select all abiturients");
                        List<Abiturient> abiturients = abiturientDAO.select();
                        if (abiturients != null)
                            System.out.println(abiturients);
                        else
                            System.out.println("Abiturients not found");
                    }
                    case 4 -> {
                        System.out.println("\t4 - Find abiturient by id");
                        System.out.print("Enter abiturient's id to find: ");
                        long idToFind = scanner.nextLong();
                        Abiturient abiturient = abiturientDAO.findById(idToFind);
                        if (abiturient != null)
                            System.out.println(abiturient);
                        else
                            System.out.println("Abiturient with id = " + idToFind + " is not found");
                    }
                    case 5 -> {
                        System.out.println("\t5 - Filter abiturients by given name");
                        System.out.print("Enter abiturient's firstname: ");
                        String firstname = scanner.nextLine();
                        List<Abiturient> filteredAbiturients = abiturientDAO.filterAbiturientsByGivenFirstname(firstname);
                        if (!filteredAbiturients.isEmpty())
                            System.out.println(filteredAbiturients);
                        else
                            System.out.println("Abiturients with name = " + firstname + " not found");
                    }
                    case 6 -> {
                        System.out.println("\t6 - Filter abiturients by higher average point than given one");
                        System.out.print("Enter abiturient's minimum average point: ");
                        double minAveragePoint = scanner.nextDouble();
                        List<Abiturient> filteredAbiturients = abiturientDAO.filterAbiturientsByHigherAveragePoint(minAveragePoint);
                        if (!filteredAbiturients.isEmpty())
                            System.out.println(filteredAbiturients);
                        else
                            System.out.println("Abiturients with higher average point than " + minAveragePoint + " not found");
                    }
                    case 7 -> {
                        System.out.println("\t7 - Filter abiturients by hostel needs");
                        List<Abiturient> filteredAbiturients = abiturientDAO.filterAbiturientsByHostelNeeds();
                        if (!filteredAbiturients.isEmpty())
                            System.out.println(filteredAbiturients);
                        else
                            System.out.println("Abiturients with hostel needs not found");
                    }
                    case 8 -> {
                        System.out.println("\t8 - Update abiturient");
                        System.out.print("Enter abiturient's id to update: ");
                        long idToUpdate = scanner.nextLong();
                        Abiturient updateToUpdate = Abiturient.initializeAbiturient();
                        updateToUpdate.setID(idToUpdate);
                        abiturientDAO.update(updateToUpdate);
                        System.out.println("Abiturient with id = " + idToUpdate + " successfully updated");
                    }
                    case 9 -> {
                        System.out.println("\t9 - Delete abiturient");
                        Abiturient abiturientToDelete = Abiturient.initializeAbiturient();
                        System.out.print("Enter abiturient's id to delete: ");
                        long idToDelete = scanner.nextLong();
                        abiturientToDelete.setID(idToDelete);
                        abiturientDAO.delete(abiturientToDelete);
                        System.out.println("Abiturient with such parameters and id = " + idToDelete + " successfully deleted");
                    }
                    case 10 -> {
                        System.out.println("\t10 - Delete abiturient by id");
                        System.out.print("Enter abiturient's id to delete: ");
                        long idToDelete = scanner.nextLong();
                        abiturientDAO.deleteById(idToDelete);
                        System.out.println("Abiturient with id = " + idToDelete + " successfully deleted");
                    }
                    case 0 -> { System.out.println("Bye"); }
                    default -> System.out.println("Wrong option! Try again.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } while (answer != 0);
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }

    public static List<Abiturient> createAndInitializeAbiturients() {
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

        return abiturients;
    }
}