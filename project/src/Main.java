import model.Game;
import model.Menu;
import model.Score;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                menu.displayMenu("main");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> {
                        menu.setNumberOfPlayer(1);
                        System.out.println("Saisir le nom:");
                        String name = scanner.nextLine();
                        if (!name.isEmpty()) {
                            menu.setNames(name);
                        } else {
                            System.out.println("Aucune entrée utilisateur n'a été détectée pour le nom");
                        }
                        choiceColor(false, menu, scanner);
                        Game gameSolo = new Game(menu.getNumberOfPlayers(), menu.getNames(), menu.getColors(), 2);
                        gameSolo.start();
                    }
                    case "2" -> {
                        menu.setNumberOfPlayer(2);
                        System.out.println("Saisir le nom du joueur 1:");
                        String name1 = scanner.nextLine();
                        if (!name1.isEmpty()) {
                            menu.setNames(name1);
                        } else {
                            System.out.println("Aucune entrée utilisateur n'a été détectée pour le nom");
                        }
                        choiceColor(false, menu, scanner);
                        System.out.println("Saisir le nom du joueur 2:");
                        String name2 = scanner.nextLine();
                        if (!name2.isEmpty()) {
                            menu.setNames(name2);
                        } else {
                            System.out.println("Aucune entrée utilisateur n'a été détectée pour le nom");
                        }
                        if (Objects.equals(menu.getColors().get(0), "🔴")) {
                            menu.setColors("🟡");
                        } else {
                            menu.setColors("🔴");
                        }
                        Game gameMulti = new Game(menu.getNumberOfPlayers(), menu.getNames(), menu.getColors(), 1);
                        gameMulti.start();
                    }
                    case "3" -> {
                        Score topScore = new Score("project/src/score.csv");
                        topScore.afficherContenu();
                    }
                    case "q" -> exit = true;
                    default -> System.out.println("La valeur n'est pas definit");
                }
            }
        }
    }

    private static void choiceColor(boolean isValidInput, Menu menu, Scanner scanner) {
        while (!isValidInput) {
            menu.displayMenu("color");
            System.out.println("Saisir la couleur:");
            String colorChoice = scanner.nextLine();
            switch (colorChoice) {
                case "1" -> {
                    menu.setColors("🟡");
                    isValidInput = true;
                }
                case "2" -> {
                    menu.setColors("🔴");
                    isValidInput = true;
                }
                default -> System.out.println("L'option n'existe pas !");
            }
        }
    }
}