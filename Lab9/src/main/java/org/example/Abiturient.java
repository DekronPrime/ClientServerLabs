package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Abiturient {
    private long ID;
    private String lastName;
    private String firstName;
    private String fatherName;
    private String email;
    private String phone;
    private double averagePoint;
    private String address;
    private boolean needHostel;
    public Abiturient() {
    }
    public Abiturient(String lastName, String firstName, String fatherName, String email, String phone, double averagePoint, String address, boolean needHostel) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.fatherName = fatherName;
        this.email = email;
        this.phone = phone;
        this.averagePoint = averagePoint;
        this.address = address;
        this.needHostel = needHostel;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(double averagePoint) {
        this.averagePoint = averagePoint;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isNeedHostel() {
        return needHostel;
    }

    public void setNeedHostel(boolean needHostel) {
        this.needHostel = needHostel;
    }

    public static Abiturient initializeAbiturient() throws InputMismatchException {
        try {
            Abiturient abiturient = new Abiturient();
            Scanner scanner = new Scanner(System.in);
            scanner.useLocale(Locale.US);
            System.out.print("Enter abiturient's lastname: ");
            abiturient.setLastName(scanner.nextLine());
            System.out.print("Enter abiturient's firstname: ");
            abiturient.setFirstName(scanner.nextLine());
            System.out.print("Enter abiturient's fathername: ");
            abiturient.setFatherName(scanner.nextLine());
            System.out.print("Enter abiturient's email: ");
            abiturient.setEmail(scanner.nextLine());
            System.out.print("Enter abiturient's phone: ");
            abiturient.setPhone(scanner.nextLine());
            System.out.print("Enter abiturient's average point: ");
            abiturient.setAveragePoint(scanner.nextDouble());
            scanner.nextLine();
            System.out.print("Enter abiturient's address: ");
            abiturient.setAddress(scanner.nextLine());
            System.out.println("Do abiturient needs a hostel? (by default: no)\n1 - Yes\n0 - No");
            System.out.print("Answer: ");
            int answer = scanner.nextInt();
            if (answer == 1)
                abiturient.setNeedHostel(true);
            else
                abiturient.setNeedHostel(false);
            return abiturient;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Entered data is invalid");
        }
    }

    @Override
    public String toString() {
        return "Abiturient{\n" +
                " id: " + this.getID() +
                ",\n lastName: '" + lastName + '\'' +
                ",\n firstName: '" + firstName + '\'' +
                ",\n fatherName: '" + fatherName + '\'' +
                ",\n email: '" + email + '\'' +
                ",\n phone: '" + phone + '\'' +
                ",\n averagePoint: " + averagePoint +
                ",\n address: '" + address + '\'' +
                ",\n needHostel: " + needHostel +
                "\n}";
    }
}