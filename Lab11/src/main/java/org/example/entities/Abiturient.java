package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

@Entity
@Table(name = "abiturients")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Abiturient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name = "last_name")
    @NonNull
    private String lastName;
    @Column(name = "first_name")
    @NonNull
    private String firstName;
    @Column(name = "father_name")
    @NonNull
    private String fatherName;
    @Column(name = "email")
    @NonNull
    private String email;
    @Column(name = "phone")
    @NonNull
    private String phone;
    @Column(name = "average_point")
    @NonNull
    private double averagePoint;
    @Column(name = "address")
    @NonNull
    private String address;
    @Column(name = "need_hostel")
    @NonNull
    private boolean needHostel;

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
            if (answer == 1) {
                abiturient.setNeedHostel(true);
            } else {
                abiturient.setNeedHostel(false);
            }
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