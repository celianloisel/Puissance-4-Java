package model;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

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
                    menuSecondaire();
                    System.out.println(Menu.couleur + Menu.nom);
                    break;
                case "2":
                    System.out.println("Jouer à 2");
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
        menus.add(ANSI_YELLOW + "\n⸺⸺⸺⸺⸺⸺⸺⸺⸺⸺⸺\n" + ANSI_RESET);
        for (String s : menus) {
            System.out.println(s);
        }
    }



    private static void menuSecondaire(){
        demanderNom();
        menuCouleur();
        System.out.println(Menu.couleur);
        return;

    }

    public static void demanderNom() {
        System.out.println("Saissisez le nom du joueur :");
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
                    break;
            }
            System.out.println("La couleur que vous avez choisi est "+couleur);
            break;
        }
    }


    private static void afficherMenuCouleur() {
        ArrayList<String> menus2 = new ArrayList<>();
        menus2.add("\nChoissisez votre couleur :\n");
        menus2.add(ANSI_YELLOW + "1 ➥ 🟡" + ANSI_RESET);
        menus2.add(ANSI_YELLOW + "2 ➥ 🔴" + ANSI_RESET);

        for (String s : menus2) {
            System.out.println(s);
        }
    }
    }
