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
public class Fiction extends Emission {
    int anneeRealisation;
    String nomRealisateur;
    boolean rediffusion = false;
    
    		public Fiction(String nom, int durée, int année, String nomRéalisateur, Boolean rediffusion) // constructeur de la classe Fiction
		{
			this.nomEmission = nom;
                        this.duree = durée;
                        this.anneeRealisation = année;
                        this.nomRealisateur = nomRéalisateur;
                        this.rediffusion = rediffusion;
                        this.heureDebut = -1;  //programme non encore programé dans la grille
                        this.heureFin = -1;    //programme non encore programé dans la grille
		}

// méthode Programmer : programmer l'objet dans la grille de programmes à l'heure indiquée en paramètre avec les con,traintes spécifiques le la classe héritée
   public int Programmer(int heure)
		{
                    int error;
                    //gestion des contraintes horaires pour la programmation horaire
                    if ((this.rediffusion) || ( heure == 21))
                    {
                        this.heureDebut = heure;
                        this.heureFin = this.heureDebut + this.duree;
                        error = 0;
                    } 
                    else
                    //contraintes horaies non respectées => pas de programmation, génération d'une erreur 
                    {    
                        this.heureDebut = -1;
                        this.heureFin = -1;
                        error = -1;
                    }
                    return error;
                }
                public void AfficherColonne()  // Méthode pour afficher tous les attributs de la classe , en colonne
                {
                    System.out.println ("Nom:\t\t" + this.nomEmission);
                    System.out.println ("duree:\t\t" + this.duree + "h");
                    System.out.println ("anneeRealisation:\t\t" + this.anneeRealisation);
                    System.out.println ("Animateur:\t" + this.nomRealisateur);
                    System.out.println ("rediffusion:\t" + this.rediffusion);
                    System.out.println ("Début:\t\t" + this.heureDebut + "h");
                    System.out.println ("Fin:\t\t" + this.heureFin + "h");
                    System.out.println ("-----------------");
                }
	}    
