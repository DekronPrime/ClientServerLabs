package org.example;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyDoubleArrayReader reader = new MyDoubleArrayReader();

        File file1 = new File("lab41.txt");
        File file2 = new File("lab42.txt");
//        double[] array = reader.readOneDimensionalArray("lab41.txt");
//        double[][] array2 = reader.readTwoDimensionalArray("lab42.txt");
        double[] array = reader.readOneDimensionalArray(file1);
        double[][] array2 = reader.readTwoDimensionalArray(file2);

        MyArrayProcessor arrProcessor = new MyArrayProcessor();

        System.out.println("One dimensional array: ");
        arrProcessor.processArray(array);
        System.out.println("Module of sum of the array: " + arrProcessor.calculateModuleOfSum(array));
        System.out.println("Sqrt of product of the array: " + arrProcessor.calculateSqrtOfProduct(array));
        System.out.println("Two dimensional array: ");
        arrProcessor.processArray(array2);
        double resArray = arrProcessor.calculate(array2);
        if (resArray == 0.0)
            System.out.println("The array doesn't have positive values.");
        else
            System.out.println("The smallest element in the array: " + resArray);
    }
}