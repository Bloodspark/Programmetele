    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.manastria.programmetele;

/**
 *
 * @author Jérémy, Hans & Sylvai
 */
public class Emission {
    public int duree;
    public String nomEmission; 
    public int heureDebut;
    public int heureFin;
    
            public void Programme() {} ; // constructeur de la classe Programme
        public void Destroy() {} ;   // Destructeur de la classe Programme
// méthode Programmer : programmer l'objet dans la grille de programmes à l'heure indiquée en paramètre
	public int Programmer(int heure)
		{
                    int error;
                    this.heureDebut = heure;
                    this.heureFin = this.heureDebut + this.duree;
                    error =0;
                    return error;
                }
// Méthode AfficherColonne : Afficher le programme avec les attributs en colonne
        public void AfficherColonne()
                {
                    System.out.println (this.nomEmission);
                    System.out.println (this.duree);
                    System.out.println (this.heureDebut);
                    System.out.println (this.heureFin);
                }
// Méthode AfficherLigne : Afficher le programme avec les attributs en colonne
        public void AfficherLigne(int heure)
                {
                    System.out.println (heure+"h\t:\t"+this.nomEmission + "[" +this.duree+"h"+"]");
                }
// Méthode ComparerHeures : vérifie que le programme n'intersecte pas le programme passé en paramètre
        public boolean ComparerHeures (Emission prgTV)
                {
                  return  (
                  (((prgTV.heureDebut >= this.heureDebut) && (prgTV.heureDebut < this.heureFin))
                  ||
                  ((prgTV.heureFin > this.heureDebut) && (prgTV.heureFin <= this.heureFin)))
                          );
                 }
// Méthode ProgrammeHeure : teste que le programme est en cours à l'heure donnée en paramètre.
        public boolean ProgrammeHeure (int heure)
                {
                  return  ((heure >= this.heureDebut)  && (heure < this.heureFin)) ;
                }
}

