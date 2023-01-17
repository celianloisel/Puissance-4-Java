package model;

public class Joueur {
    private final String couleurJoueur;
    private final String nomJoueur;

    public Joueur(String name, String color){
        this.nomJoueur = name;
        this.couleurJoueur = color;
    }


    public String getNomJoueur() {
        return nomJoueur;
    }

    public String getCouleurJoueur() {
        return couleurJoueur;
    }
}
