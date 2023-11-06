package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = getConnection()) {
                System.out.println("Connection to DB successful!");

                AbiturientDAO abiturientDAO = new AbiturientDAO(connection);

                Scanner scanner = new Scanner(System.in);
                scanner.useLocale(Locale.US);

                int answer;
                do {
                    answer = Menu.showMenuAndChooseAction();
                    try {
                        switch (answer) {
                            case 1 -> {
                                System.out.println("\tCreate table with necessary fields");
                                abiturientDAO.createTable();
                                System.out.println("Table 'abiturients' was successfully created");
                            }
                            case 2 -> {
                                System.out.println("\tInitialize and insert default abiturients");
                                List<Abiturient> abiturients = createAndInitializeAbiturients();
                                int rowsInserted = 0;
                                for (Abiturient abiturient : abiturients)
                                    rowsInserted += abiturientDAO.insert(abiturient);
                                System.out.printf("Inserted default abiturients: %d\n", rowsInserted);
                            }
                            case 3 -> {
                                System.out.println("\tInsert a single abiturient");
                                Abiturient abiturient = Abiturient.initializeAbiturient();
                                int rowsInserted = abiturientDAO.insert(abiturient);
                                System.out.printf("Inserted abiturients: %d\n", rowsInserted);
                            }
                            case 4 -> {
                                System.out.println("\tSelect all abiturients");
                                List<Abiturient> selectedAbiturients = abiturientDAO.select();
                                selectedAbiturients.forEach(System.out::println);
                            }
                            case 5 -> {
                                System.out.println("\tFind abiturient by id");
                                System.out.print("Enter abiturient's id to find: ");
                                Abiturient selectedAbiturient = abiturientDAO.findById(scanner.nextLong());
                                System.out.println(selectedAbiturient);
                            }
                            case 6 -> {
                                System.out.println("\tUpdate abiturient");
                                System.out.print("Enter abiturient's id to update: ");
                                long idToUpdate = scanner.nextLong();
                                Abiturient abiturientToUpdate = Abiturient.initializeAbiturient();
                                abiturientToUpdate.setID(idToUpdate);
                                int rowsUpdated = abiturientDAO.update(abiturientToUpdate);
                                System.out.printf("Updated rows: %d\n", rowsUpdated);
                            }
                            case 7 -> {
                                System.out.println("\tDelete one or many abiturients");
                                Abiturient abiturientToDelete = Abiturient.initializeAbiturient();
                                int rowsDeleted = abiturientDAO.delete(abiturientToDelete);
                                System.out.printf("Deleted rows: %d\n", rowsDeleted);
                            }
                            case 8 -> {
                                System.out.println("\tDelete abiturient by id");
                                System.out.print("Enter abiturient's id to delete: ");
                                int rowsDeleted = abiturientDAO.deleteById(scanner.nextLong());
                                System.out.printf("Deleted rows: %d\n", rowsDeleted);
                            }
                            case 9 -> {
                                System.out.println("\tDrop table");
                                abiturientDAO.dropTable();
                                System.out.println("Table 'abiturients' was dropped");
                            }
                            case 0 -> System.out.println("Bye");
                            default -> System.out.println("Wrong option! Try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("Error! " + e.getMessage());
                    } catch (SQLException e) {
                        System.err.println("Error! " + e.getMessage());
                    }
                } while (answer != 0);
            }
        } catch(Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public static Connection getConnection() throws SQLException, IOException {
        Properties properties = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("src\\main\\resources\\database.properties"))){
            properties.load(in);
        }
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        return DriverManager.getConnection(url, username, password);
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