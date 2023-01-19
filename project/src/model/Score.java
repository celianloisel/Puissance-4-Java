package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Score {

    private String fileName;

    public Score(String fileName) {
        this.fileName = fileName;
    }

    // afficher le top 10
    public void afficherContenu() {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(data, (a, b) -> Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1])));

        if (data.size() < 10) {
            for (int i = 0; i < data.size(); i++) {
                String[] player = data.get(i);
                for (String value : player) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < 10; i++) {
                String[] player = data.get(i);
                for (String value : player) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }

    // Sauvegarder le score
    public void saveScore(String name, int move) throws IOException {
        int score = 42 - move;
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
            pw.println(name + ";" + score);
        }
    }
}
