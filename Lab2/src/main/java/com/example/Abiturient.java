package com.example;

import java.util.Scanner;

public class Abiturient {
    private long id;
    private String lastName;
    private String firstName;
    private String fatherName;
    private String address;
    private String phone;
    private double averagePoint;
    public Abiturient() {
    }
    public Abiturient(long id, String lastName, String firstName, String fatherName, String address, String phone, double averagePoint) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.fatherName = fatherName;
        this.address = address;
        this.phone = phone;
        this.averagePoint = averagePoint;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Abiturient {" +
                "id: " + id +
                ",\n lastName: '" + lastName + '\'' +
                ",\n firstName: '" + firstName + '\'' +
                ",\n fatherName: '" + fatherName + '\'' +
                ",\n address: '" + address + '\'' +
                ",\n phone: '" + phone + '\'' +
                ",\n averagePoint: " + averagePoint +
                "}\n";
    }

    public static void main(String[] args) {
        Abiturient abiturient = new Abiturient();
        System.out.println(abiturient);
    }
}
