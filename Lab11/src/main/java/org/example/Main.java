package org.example;

import org.example.entities.Abiturient;
import org.example.services.AbiturientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    private final AbiturientService abiturientService;

    public Main(AbiturientService abiturientService) {
        this.abiturientService = abiturientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int answer;
        do {
            answer = Menu.showMenuAndChooseAction();
            try {
                switch (answer) {
                    case 1 -> insertDefaultAbiturients();
                    case 2 -> insertAbiturient();
                    case 3 -> selectAllAbiturients();
                    case 4 -> findAbiturientById();
                    case 5 -> filterAbiturientsByGivenFirstName();
                    case 6 -> filterAbiturientsByGreaterAveragePointThan();
                    case 7 -> filterAbiturientsByHostelNeeds();
                    case 8 -> updateAbiturient();
                    case 9 -> deleteAbiturient();
                    case 10 -> deleteAbiturientById();
                    case 0 -> System.out.println("Bye");
                    default -> System.out.println("Wrong option! Try again.");
                }
            } catch (NoSuchElementException e) {
                System.err.println("Error: No such element");
            } catch (RuntimeException e) {
                System.err.println("Error: " + e.getMessage() + " | " + e.getCause());
            }
        } while (answer != 0);
    }

    public void insertDefaultAbiturients() {
        System.out.println("\t1 - Initialize and insert default abiturients");
        abiturientService.insertDefaultAbiturients();
        System.out.println("Default abiturients successfully inserted");
    }

    public void insertAbiturient() {
        System.out.println("\t2 - Insert abiturient");
        Abiturient abiturient = Abiturient.initializeAbiturient();
        abiturientService.insertAbiturient(abiturient);
        System.out.println("New abiturient successfully inserted");
    }

    public void selectAllAbiturients() {
        System.out.println("\t3 - Select all abiturients");
        List<Abiturient> abiturients = abiturientService.selectAllAbiturients();
        if (!abiturients.isEmpty()) {
            System.out.println(abiturients);
        } else {
            System.out.println("Abiturients not found");
        }
    }

    public void findAbiturientById() {
        System.out.println("\t4 - Find abiturient by id");
        System.out.print("Enter abiturient's id to find: ");
        long idToFind = scanner.nextLong();
        Abiturient abiturient = abiturientService.findAbiturientById(idToFind);
        System.out.println(abiturient);
    }

    public void filterAbiturientsByGivenFirstName() {
        System.out.println("\t5 - Filter abiturients by given name");
        System.out.print("Enter abiturient's firstname: ");
        String firstName = scanner.nextLine();
        List<Abiturient> filteredAbiturients = abiturientService.filterAbiturientsByGivenFirstName(firstName);
        if (!filteredAbiturients.isEmpty()) {
            System.out.println(filteredAbiturients);
        } else {
            System.out.println("Abiturients with name = " + firstName + " not found");
        }
    }

    public void filterAbiturientsByGreaterAveragePointThan() {
        System.out.println("\t6 - Filter abiturients by higher average point than given one");
        System.out.print("Enter abiturient's minimum average point: ");
        double minAveragePoint = scanner.nextDouble();
        List<Abiturient> filteredAbiturients = abiturientService.filterAbiturientsByHigherAveragePoint(minAveragePoint);
        if (!filteredAbiturients.isEmpty()) {
            System.out.println(filteredAbiturients);
        } else {
            System.out.println("Abiturients with higher average point than " + minAveragePoint + " not found");
        }
    }

    public void filterAbiturientsByHostelNeeds() {
        System.out.println("\t7 - Filter abiturients by hostel needs");
        List<Abiturient> filteredAbiturients = abiturientService.filterAbiturientsByHostelNeeds();
        if (!filteredAbiturients.isEmpty()) {
            System.out.println(filteredAbiturients);
        } else {
            System.out.println("Abiturients with hostel needs not found");
        }
    }

    public void updateAbiturient() {
        System.out.println("\t8 - Update abiturient");
        System.out.print("Enter abiturient's id to update: ");
        long idToUpdate = scanner.nextLong();
        Abiturient abiturientToUpdate = Abiturient.initializeAbiturient();
        abiturientToUpdate.setID(idToUpdate);
        abiturientService.updateAbiturient(abiturientToUpdate);
        System.out.println("Abiturient successfully updated");
    }

    public void deleteAbiturient() {
        System.out.println("\t9 - Delete abiturient");
        Abiturient abiturientToDelete = Abiturient.initializeAbiturient();
        System.out.print("Enter abiturient's id to delete: ");
        long idToDelete = scanner.nextLong();
        abiturientToDelete.setID(idToDelete);
        abiturientService.deleteAbiturient(abiturientToDelete);
        System.out.println("Abiturient successfully deleted");
    }

    public void deleteAbiturientById() {
        System.out.println("\t10 - Delete abiturient by id");
        System.out.print("Enter abiturient's id to delete: ");
        long idToDelete = scanner.nextLong();
        abiturientService.deleteAbiturientById(idToDelete);
        System.out.println("Abiturient successfully deleted");
    }
}