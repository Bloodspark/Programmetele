/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.manastria.programmetele;

/**
 *
 * @author Jérémy, Hans & Sylvain
 */
public class Divertissement extends Emission {
    String nomAnimateur;
    public Divertissement(String nom, String nomAnimateur) // constructeur de la classe Divertisdsement
		{
			this.nomEmission = nom;
                        this.duree = 2;
                        this.nomAnimateur = nomAnimateur;
                        this.heureDebut = -1;  //programme non encore programé dans la grille
                        this.heureFin = -1;    //programme non encore programé dans la grille
		}


                // méthode Programmer : programmer l'objet dans la grille de programmes à l'heure indiquée en paramètre avec les con,traintes spécifiques le la classe héritée
                public int Programmer(int heure)
		{
                    int error;
                    if ((heure < 18)|| (heure > 23))
                    //contraintes horaies non respectées => pas de programmation, génération d'une erreur 

                    {
                        return -1;
                    } 
                    else
                    //contraintes horaires respéctées => programmation effectuée
                    {    
                        this.heureDebut = heure;
                        this.heureFin = this.heureDebut + this.duree;
                        error = 0;
                    }
                    return error;
                }
                public void AfficherColonne()  // Méthode pour afficher tous les attributs de la classe , en colonne
                {
                    System.out.println ("nomEmission:\t\t" + this.nomEmission);
                    System.out.println ("duree:\t\t" + this.duree + "h");
                    System.out.println ("Animateur:\t" + this.nomAnimateur);
                    System.out.println ("Début:\t\t" + this.heureDebut + "h");
                    System.out.println ("Fin:\t\t" + this.heureFin + "h");
                    System.out.println ("-----------------");
                }
	}    
