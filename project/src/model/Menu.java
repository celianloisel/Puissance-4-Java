package model;

import java.util.ArrayList;
import java.util.Objects;

public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private int numberOfPlayer;
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> colors = new ArrayList<String>();

    public Menu() {
        numberOfPlayer = getNumberOfPlayers();
        names = getNames();
        colors = getColors();
    }

    public void displayMenu(String choice) {
        if (Objects.equals(choice, "main")) {
            ArrayList<String> menu = new ArrayList<>();
            menu.add(ANSI_YELLOW + "\n⸺⸺⸺⸺ MENU ⸺⸺⸺⸺\n" + ANSI_RESET);
            menu.add(ANSI_YELLOW + "1 ➥ Jouer tout seul" + ANSI_RESET);
            menu.add(ANSI_YELLOW + "2 ➥ Jouer à 2" + ANSI_RESET);
            menu.add(ANSI_YELLOW + "3 ➥ Afficher le TOP 10" + ANSI_RESET);
            menu.add(ANSI_RED + "\nq ➥ Quitter" + ANSI_RESET);
            menu.add(ANSI_YELLOW + "\n⸺⸺⸺⸺⸺⸺⸺⸺⸺⸺\n" + ANSI_RESET);
            for (String s : menu) {
                System.out.println(s);
            }
        } else if (Objects.equals(choice, "color")) {
            ArrayList<String> colorMenu = new ArrayList<>();
            colorMenu.add("\n>> Choissisez votre couleur :\n");
            colorMenu.add(ANSI_YELLOW + "1 ➥ 🟡" + ANSI_RESET);
            colorMenu.add(ANSI_YELLOW + "2 ➥ 🔴" + ANSI_RESET);

            for (String s : colorMenu) {
                System.out.println(s);
            }
        }
    }

    public int getNumberOfPlayers() {
        return numberOfPlayer;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(String name) {
        if (names.isEmpty()) {
            this.names = new ArrayList<String>();
        }
        this.names.add(name);
    }


    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(String color) {
        if (colors.isEmpty()) {
            this.colors = new ArrayList<String>();
        }
        this.colors.add(color);
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.colors.clear();
        this.names.clear();
        this.numberOfPlayer = numberOfPlayer;
    }
}
