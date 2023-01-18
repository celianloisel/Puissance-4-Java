package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Score {

    private String fileName;

    public Score(String fileName) {
        this.fileName = fileName;
    }

    public void afficherContenu() {
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] values = line.split(";");
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
