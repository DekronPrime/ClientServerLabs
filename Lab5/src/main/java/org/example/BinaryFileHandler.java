package org.example;

import java.io.*;

public class BinaryFileHandler {
    private final String filename;
    public BinaryFileHandler(String filename) {
        this.filename = filename;
    }
    public void saveAbiturients(AbiturientArray abiturients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(abiturients);
            System.out.println("Abiturients saved to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error occurred while trying to save abiturients to file " + filename);
            e.printStackTrace();
        }
    }
    public AbiturientArray loadAbiturients() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            AbiturientArray loadedAbiturients = (AbiturientArray) ois.readObject();
            return loadedAbiturients;
        } catch (FileNotFoundException e) {
            System.err.println("File " + filename + " not found");
            return new AbiturientArray();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error occurred while trying to load abiturients from file " + filename);
            e.printStackTrace();
            return new AbiturientArray();
        }
    }
}
