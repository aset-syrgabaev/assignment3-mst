package edu.astanait.mst;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtils {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static InputData readInput(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, InputData.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeOutput(String filePath, OutputData outputData) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(outputData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
