package model;

import com.sun.tools.javac.Main;

public class Game {

    public static void grid() {
        for (int i = 0; i < 7; i++) {
            System.out.print("   " + (i + 1));
        }

        for (int i = 0; i < 6; i++) {
            System.out.println();
            System.out.print(" ");
            for (int j = 0; j < 7; j++) {
                System.out.print("|   ");
            }
            System.out.print("|");
            System.out.println();
            System.out.print(" |");
            for (int j = 0; j < 6; j++) {
                System.out.print("---+");
            }
            System.out.print("---|");
        }
    }
}
