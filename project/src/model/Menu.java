package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Grid;
import model.Joueur;

public class Menu {

    static String nom;
    static String couleur;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private static Scanner scan01 = new Scanner(System.in);
    private static Scanner scan02 = new Scanner(System.in);
    private static Scanner scan03 = new Scanner(System.in);

    public static void menuPrincipal(){
        afficherMenuPrincipal();
        while (true) {
            String choix = scan01.nextLine();
            switch (choix) {
                case "1":
                    menuSecondaireSolo();
                    break;
                case "2":
                    menuSecondaireDuo();
                    break;
                case "3":
                    Score topScore = new Score("project/src/score.csv");
                    topScore.afficherContenu();
                    break;
                case "q":
                    scan01.close();
                    return;
                default:
                    System.out.println("L'option n'existe pas !");
                    break;
            }
            afficherMenuPrincipal();
        }


}
    private static void afficherMenuPrincipal() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add(ANSI_YELLOW + "\n⸺⸺⸺⸺ MENU ⸺⸺⸺⸺\n" + ANSI_RESET);
        menus.add(ANSI_YELLOW + "1 ➥ Jouer tout seul" + ANSI_RESET);
        menus.add(ANSI_YELLOW + "2 ➥ Jouer à 2" + ANSI_RESET);
        menus.add(ANSI_YELLOW + "3 ➥ Afficher le TOP 10" + ANSI_RESET);

        menus.add(ANSI_RED + "\nq ➥ Quitter" + ANSI_RESET);
        menus.add(ANSI_YELLOW + "\n⸺⸺⸺⸺⸺⸺⸺⸺⸺⸺\n" + ANSI_RESET);
        for (String s : menus) {
            System.out.println(s);
        }
    }



    private static void menuSecondaireSolo(){
        demanderNom();
        menuCouleur();
        Joueur joueur = new Joueur(Menu.nom, Menu.couleur);
        // joueur01.nomJoueur = Menu.nom;
        // joueur01.couleurJoueur = Menu.couleur;
        System.out.println("Bienvenue "+joueur.getNomJoueur()+ " ! Votre couleur est "+joueur.getCouleurJoueur()+".");
        Grid grid = new Grid(6, 7);
        grid.display();

    }

    private static void menuSecondaireDuo(){
        System.out.println("\n--- Saissisez les informations du joueur 1 ---\n");
        demanderNom();
        menuCouleur();
        Joueur joueur01 = new Joueur(Menu.nom, Menu.couleur);
        System.out.println("Bienvenue "+joueur01.getNomJoueur()+ " ! Votre couleur est "+joueur01.getCouleurJoueur()+".");
        System.out.println("\n--- Saissisez les informations du joueur 2 ---\n");
        demanderNom();
        if (joueur01.getCouleurJoueur() == "🟡"){
            Menu.couleur = "🔴";
        }else{
            Menu.couleur = "🟡";
        }
        Joueur joueur02 = new Joueur(Menu.nom, Menu.couleur);
        System.out.println("Bienvenue "+joueur02.getNomJoueur()+ " ! Votre couleur est donc le "+joueur02.getCouleurJoueur()+".");
        Grid grid = new Grid(6, 7);
        grid.display();
    }


    public static void demanderNom() {
        System.out.println(">> Saissisez le nom du joueur :");
        Menu.nom = scan03.nextLine();
    }

    public static void menuCouleur(){
        afficherMenuCouleur();
        while (true) {
            String choix = scan02.nextLine();
            switch (choix) {
                case "1":
                    Menu.couleur = "🟡";
                    break;
                case "2":
                    Menu.couleur = "🔴";
                    break;
                default:
                    System.out.println("L'option n'existe pas !");
                    if (Menu.couleur != "🟡" || Menu.couleur != "🔴" ){
                        menuCouleur();
                }
            }
            break;
        }
    }

    private static void afficherMenuCouleur() {
        ArrayList<String> menus2 = new ArrayList<>();
        menus2.add("\n>> Choissisez votre couleur :\n");
        menus2.add(ANSI_YELLOW + "1 ➥ 🟡" + ANSI_RESET);
        menus2.add(ANSI_YELLOW + "2 ➥ 🔴" + ANSI_RESET);

        for (String s : menus2) {
            System.out.println(s);
        }
    }
}