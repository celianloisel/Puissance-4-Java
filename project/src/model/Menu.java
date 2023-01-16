package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Joueur;

public class Menu {

    static String nom;
    static String couleur;
    public static Joueur joueur01 = new Joueur();
    public static Joueur joueur02 = new Joueur();
    public static Joueur joueur03 = new Joueur();

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
                    System.out.println("Afficher le TOP 10");
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
        joueur01.nomJoueur = Menu.nom;
        joueur01.couleurJoueur = Menu.couleur;
        System.out.println("Bienvenue "+joueur01.nomJoueur+ " ! Votre couleur est "+joueur01.couleurJoueur+".");
        return;

    }

    private static void menuSecondaireDuo(){
        System.out.println("\n--- Saissisez les informations du joueur 1 ---\n");
        demanderNom();
        menuCouleur();
        joueur02.nomJoueur = Menu.nom;
        joueur02.couleurJoueur = Menu.couleur;
        System.out.println("Bienvenue "+joueur02.nomJoueur+ " ! Votre couleur est "+joueur02.couleurJoueur+".");
        System.out.println("\n--- Saissisez les informations du joueur 2 ---\n");
        demanderNom();
        choixCouleurDuo();
        joueur03.nomJoueur = Menu.nom;
        System.out.println("Bienvenue "+joueur03.nomJoueur+ " ! Votre couleur est donc le "+joueur03.couleurJoueur+".");

    }

    public static void choixCouleurDuo(){
        if (Menu.couleur == "🟡"){
            joueur03.couleurJoueur = "🔴";
        }else{
            joueur03.couleurJoueur = "🟡";
        }
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

