package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class MyDoubleArrayReader implements DoubleArrayReader {

    @Override
    public double[] readOneDimensionalArray(File file) {
        try (Scanner in = new Scanner(file)) {
            in.useLocale(Locale.US);
            int arrayLength = in.nextInt();
            double[] array = new double[arrayLength];
            for (int i = 0; i < arrayLength; i++)
                array[i] = in.nextDouble();
            return array;
        } catch (IOException e) {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[] readOneDimensionalArray(String fileName) {
        try (Scanner in = new Scanner(new File(fileName))) {
            in.useLocale(Locale.US);
            int arrayLength = in.nextInt();
            double[] array = new double[arrayLength];
            for (int i = 0; i < arrayLength; i++)
                array[i] = in.nextDouble();
            return array;
        } catch (IOException e) {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[][] readTwoDimensionalArray(File file) {
        try (Scanner in = new Scanner(file)) {
            in.useLocale(Locale.US);
            int arrayLength = in.nextInt();
            double[][] array = new double[arrayLength][arrayLength];
            for (int i = 0; i < arrayLength; i++)
                for (int j = 0; j < arrayLength; j++)
                    array[i][j] = in.nextDouble();
            return array;
        } catch (IOException e) {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[][] readTwoDimensionalArray(String fileName) {
        try (Scanner in = new Scanner(new File(fileName))) {
            in.useLocale(Locale.US);
            int arrayLength = in.nextInt();
            double[][] array = new double[arrayLength][arrayLength];
            for (int i = 0; i < arrayLength; i++)
                for (int j = 0; j < arrayLength; j++)
                    array[i][j] = in.nextDouble();
            return array;
        } catch (IOException e) {
            System.err.println("Error reading file");
            return null;
        }
    }
}
