package model;

import java.io.*;

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

    public void saveScore(String name, int move) throws IOException {
        int score = 42 - move;
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
            pw.println(name + ";" + score);
        }
    }
}
