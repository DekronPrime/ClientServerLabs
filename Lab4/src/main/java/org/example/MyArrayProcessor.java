package org.example;

import java.util.ArrayList;
import java.util.List;

public class MyArrayProcessor implements ArrayProcessor{

    @Override
    public double calculateModuleOfSum(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        return Math.abs(sum);
    }

    @Override
    public double calculate(double[][] array) {
        List<Double> positiveElements = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                double currentValue = array[i][j];
                if (currentValue > 0)
                    positiveElements.add(currentValue);
            }
        }
        if (positiveElements.isEmpty()) {
            return 0;
        }
        double smallestPositiveValue = positiveElements.get(0);
        for (double element : positiveElements) {
            if (smallestPositiveValue > element)
                smallestPositiveValue = element;
        }
        return smallestPositiveValue;
    }

    @Override
    public double calculateSqrtOfProduct(double[] array) {
        double product = 1.0;
        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }
        return Math.sqrt(product);
    }

    @Override
    public void processArray(double[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("]");
    }

    @Override
    public void processArray(double[][] array) {
        System.out.println("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t{ ");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("}");
        }
        System.out.println("]");
    }
}
