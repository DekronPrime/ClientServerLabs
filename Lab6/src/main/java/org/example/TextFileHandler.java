package org.example;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileHandler {
    private final String filename;

    public TextFileHandler(String filename) {
        this.filename = filename;
    }
    public void saveAbiturients(AbiturientList abiturients) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(abiturients, writer);
            System.out.println("Abiturients saved to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error occurred while trying to save abiturients to file " + filename);
            e.printStackTrace();
        }
    }
    public AbiturientList loadAbiturients() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            AbiturientList loadedAbiturients = gson.fromJson(reader, AbiturientList.class);
            System.out.println("Abiturients loaded from file " + filename + ":");
            return loadedAbiturients;
        } catch (FileNotFoundException e) {
            System.err.println("File " + filename + " not found");
            return new AbiturientList();
        } catch (IOException e) {
            System.err.println("Error occurred while trying to load abiturients from file " + filename);
            e.printStackTrace();
            return new AbiturientList();
        }
    }
}
