package model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Grid grid;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int numberOfPlayers;
    private int iaLevel;

    public Game(int numberOfPlayers, ArrayList names, ArrayList colors, int iaLevel) {
        this.numberOfPlayers = numberOfPlayers;
        this.iaLevel = iaLevel;
        grid = new Grid();
        player1 = new Player((String) names.get(0), (String) colors.get(0));
        if (numberOfPlayers == 2) {
            player2 = new Player((String) names.get(1), (String) colors.get(1));
        } else {
            if (Objects.equals(colors.get(0), "🔴")) {
                colors.add("🟡");
            } else {
                colors.add("🔴");
            }
            player2 = new Player("ia", (String) colors.get(1));
        }
        currentPlayer = player1;
    }

    public void start() {
        grid.displayGrid();
        System.out.println(currentPlayer.getName());
        System.out.println(currentPlayer.getColor());
        while (!grid.checkForWin()) {
            if (grid.isFullGrid()) {
                System.out.println("Matche nul");
                break;
            }
            int column = getPlayerMove(false);
            grid.dropPiece(currentPlayer.getColor(), column);
            grid.displayGrid();
            if (!grid.checkForWin()) {
                switchPlayer();
            }
        }
        System.out.println(currentPlayer.getName() + " a gagné!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private int getPlayerMove(boolean error) {
        if (!Objects.equals(currentPlayer.getName(), "ia")) {
            Scanner scan = new Scanner(System.in);

            if (error) {
                System.out.println("le nombre choisis doit etre compris entre 1 et 7");
            }
            System.out.println("C'est à " + currentPlayer.getName() + " de jouer");
            System.out.println("Saisir la colonne dans laquelle vous souhaitez placer votre pion");

            int col = scan.nextInt();

            if (col > 7 || col < 1) return getPlayerMove(true);
            if (!checkColumn(col)) return getPlayerMove(false);
            return col;
        } else {
            System.out.println("L'ia joue");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Random random = new Random();
            int col = random.nextInt(7) + 1;
            if (!checkColumn(col)) return getPlayerMove(false);
            return col;
        }
    }

    public boolean checkColumn(int col) {
        if (grid.isFull(col - 1)) {
            System.out.println("La colonne choisie est pleine, veuillez choisir une autre colonne");
            return false;
        }
        return true;
    }


    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
