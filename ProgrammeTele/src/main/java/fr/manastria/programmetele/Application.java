package fr.manastria.programmetele;
//importation de tous les packages Java nécessaires

import fr.manastria.programmetele.Reportage.TypeTheme;
import java.util.ArrayList;
import java.util.logging.*;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Application
{
    public static void main( String[] args )
    {
        Emission[] prgTV;       // Tableau d'objets Emission qui va contenir tous les programmes televisuels.
        int[] error;            // Tableau d'entiers qui va contenir les erreurs
        int index1;             // 1er indice de boucle
        int index2;             // 2eme indice de boucle
        int nbEmissions;        // nombres d'emissions du programme 
        int hit=0;              // valeur retour de la recherche d'un programme à une heure donnée.
        boolean intersection;   // Prend la valeur vrai si deux programmes se chevauchent dans le planning.
        boolean rediff;         // Est vrai si l'emission est une rediffusion.
        String[] strEmission;   // Tableau de chaines de caractère utilisé pour traiter les données entrée (l'arrayList)
        String[] substr;        // Tableau de sous chaines de caractère utilisé pour traiter les données entrées.
        
        strEmission = new String[24];   //dimensionnement du tableau de chaines de caractère 
        prgTV = new Emission[24];       //dimensionnement du tableau d'Emission
        error = new int[24];           // dimensionnement du tableau d'erreurs
        
        // création de l'objet date0 (classe Date) pour insertion de la date dans le fichier de Log
        DateFormat dateFormat0 = new SimpleDateFormat("ddMMMyyyy_HH.mm.ss");
        Date date0 = new Date();
        
        // création et nommage du fichier de Log
        File fichierLog = new File ("Application."+dateFormat0.format(date0)+".log");
                //initalisation de l'arrayList contenant les programmes à programmer
        {
        
        try {                                       // sequence try/catch pour pouvoir gérer les ecritures sur le fichier de Log
                FileWriter fw = new FileWriter (fichierLog);// création objet fw (classe FileWrtiter) sur fichier de Log
                DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // création de l'objet date1 (classe Date) pour affichage de la dfate dans les messages Log
                Date date1 = new Date();                                              // création de l'objet date1 (classe Date) pour affichage de la dfate dans les messages Log      
                //Affichage sur console
                System.out.println(dateFormat1.format(date1)); 

                //Ecriture dans le fichier de Log
                fw.write ("INFO  :"+dateFormat1.format(date1)+": Démarrage du programme\r\n");
                fw.write ("INFO  :"+dateFormat1.format(date1)+": Création de la liste de programmes\r\n");
                                // Création de la ArrayList d'entrée
                ArrayList<String> emissionList = new ArrayList<>();

        // ArrayList 1 , sans erreur
       /*       emissionList.add("Fiction,15,2,A.I.,2001,Steven Spielberg,oui");
                emissionList.add("Reportage,0,1,La Picardie,culturel");
                emissionList.add("Reportage,3,1,Les Tigres,animalier");
                emissionList.add("Reportage,2,1,Les Lions,animalier");
                emissionList.add("Reportage,1,1,Le Journal,information");
                emissionList.add("Reportage,17,1,Le Journal,information");
                emissionList.add("Fiction,10,2,A.I.,2001,Steven Spielberg,oui");
                emissionList.add("Reportage,14,1,52 minutes à la Une,information"); 
                emissionList.add("Divertissement,23,Les Sardines,Patrick Sebastien"); 
                emissionList.add("Fiction,20,1,Santa Barbara,1999,robert Patureau,oui") ;
                emissionList.add("Fiction,21,2,2001 Odyssée de l'espace,1968,Stanley Kubrick,non") ;
                emissionList.add("Fiction,4,3,2010 Odyssée 2,1992,Stanley Kubrick,oui") ;
                emissionList.add("Fiction,18,2,cube 0,2004,Athur Lanz,oui") ;
                emissionList.add("Fiction,7,2,Les tontons flingueurs,1964,Bo Diddley,oui") ;
                emissionList.add("Fiction,12,1,Mission impossible,1965,John Doe,oui") ;
             */   


         // ArrayList 2 , avec erreurs
                emissionList.add("Fiction,15,2,A.I.,2001,Steven Spielberg,oui");
                emissionList.add("Reportage,3,1,Les Tigres,animalier");
                emissionList.add("Reportage,2,1,Les Lions,animalier");
                emissionList.add("Reportage,1,1,Le Journal,information");
                emissionList.add("Reportage,20,1,Le Journal,information");
                emissionList.add("Fiction,10,2,A.I.,2001,Steven Spielberg,oui");
                emissionList.add("Reportage,14,1,52 minutes à la Une,information"); 
                emissionList.add("Divertissement,23,Les Sardines,Patrick Sebastien"); 
                emissionList.add("Fiction,21,1,Santa Barbara,1999,robert Patureau,oui") ;
                emissionList.add("Fiction,21,2,2001 Odyssée de l'espace,1968,Stanley Kubrick,non") ;
                emissionList.add("Fiction,4,3,2010 Odyssée 2,1992,Stanley Kubrick,oui") ;
                emissionList.add("Fiction,18,2,cube 0,2004,Athur Lanz,oui") ;
                emissionList.add("Fiction,7,2,Les tontons flingueurs,1964,Bo Diddley,oui") ;
                emissionList.add("Fiction,12,1,Mission impossible,1965,John Doe,oui") ;


        // ArrayList 3 , avec erreurs
            /*    emissionList.add("Fiction,15,2,A.I.,2001,Steven Spielberg,oui");
                emissionList.add("Reportage,0,1,La Picardie,culturel");
                emissionList.add("Reportage,3,1,Les Tigres,animalier");
                emissionList.add("Reportage,2,1,Les Lions,animalier");
                emissionList.add("Reportage,1,1,Le Journal,information");
                emissionList.add("Reportage,17,1,Le Journal,information");
                emissionList.add("Fiction,10,2,A.I.,2001,Steven Spielberg,oui");
                emissionList.add("Reportage,14,1,52 minutes à la Une,information"); 
                emissionList.add("Divertissement,23,Les Sardines,Patrick Sebastien"); 
                emissionList.add("Fiction,20,1,Santa Barbara,1999,robert Patureau,oui") ;
                emissionList.add("Fiction,21,2,2001 Odyssée de l'espace,1968,Stanley Kubrick,non") ;
                emissionList.add("Fiction,4,3,2010 Odyssée 2,1992,Stanley Kubrick,oui") ;
                emissionList.add("Fiction,18,2,cube 0,2004,Athur Lanz,oui") ;
                emissionList.add("Fiction,7,2,Les tontons flingueurs,1964,Bo Diddley,oui") ;
                emissionList.add("Fiction,12,1,Mission impossible,1965,John Doe,oui") ;
                    */
                // calcul du nombre de programmes à programmer
                nbEmissions = emissionList.size();

                //Ecriture dans le fichier de Log
                fw.write ("INFO  :"+dateFormat1.format(date1)+": Création des objets programmes avec la liste de programmes\r\n");
                fw.write ("INFO  :"+dateFormat1.format(date1)+": Programmation horaire de chaque programme\r\n");
                fw.write ("INFO  :"+dateFormat1.format(date1)+": Vérification de l'heure de programmation de chaque programme\r\n");

        // création des instances de classes correspodantes aux données de la liste des programmes
                for (index1=0; index1<nbEmissions;index1++)  
                   {
                        strEmission[index1]= emissionList.get(index1);
                        substr = strEmission[index1].split(",");
                         switch (substr[0]) 
                        {
                            case "Reportage" :
                                  prgTV[index1] = new Reportage(substr[3], Integer.valueOf(substr[2]), TypeTheme.valueOf(substr[4]));
                                  break;
                            case "Divertissement" :
                                  prgTV[index1] = new Divertissement (substr[2] , substr[3]);
                                  break;
                            case "Fiction" :
                                  prgTV[index1] = new Fiction (substr[3], Integer.valueOf(substr[2]), Integer.valueOf(substr[4]), substr[5],(substr[6].equals("oui")));
                                  break;
                        }
                        //programmation horaire des programmes  
                         error[ index1] = prgTV[index1].Programmer(Integer.valueOf(substr[1]));

                        // detection d'erreur : mauvaise programmation horaire
                        if (error[index1] == 0)
                        {
                            prgTV[index1].AfficherColonne();
                        }
                        else
                        {
                        // detection d'erreur : mauvaise programmation horaire
                        //Ecriture dans le fichier de Log
                        fw.write ("ERREUR:"+dateFormat1.format(date1)+": Mauvaise programmation de:"+ prgTV[index1].nomEmission +"\r\n");

                        //Affichage sur console
                        System.out.println("Erreur dans l'horaire de programmation de:"+ prgTV[index1].nomEmission);
                        System.out.println("-----------------");
                        }
                   }
               // vérification du non recouvrement des programmes entre eux
               fw.write ("INFO  :"+dateFormat1.format(date1)+": Vérification dsu non recouvrement des programmes entre eux\r\n");
               for (index1=0; index1<nbEmissions; index1++)
                    {
                        for (index2=0; index2<nbEmissions; index2++)
                        {
                            if (index1 != index2) 
                            {
                                intersection = prgTV[index1].ComparerHeures(prgTV[index2]);

                                //Ecriture dans le fichier de Log
                                if (intersection) fw.write ("ERREUR:"+dateFormat1.format(date1)+": Recouvrement des programmes:" + prgTV[index1].nomEmission+" et " + prgTV[index2].nomEmission +"\r\n");
                                //Affichage sur console
                                if (intersection) System.out.println("Erreur, recouvrement des programmes:" + prgTV[index1].nomEmission+" et " + prgTV[index2].nomEmission);
                            }
                        }
                    }

                //Ecriture dans le fichier de Log
               fw.write ("INFO  :"+dateFormat1.format(date1)+": Affichage de la grille des programmes de la journée"+"\r\n");

                // Affichage sur console de la grille des programmes du jour
               System.out.println("--------------------------------------------");
               System.out.println("Affichage de la grille dee programme du jour");
               System.out.println("--------------------------------------------");

               for (index1=0; index1<24; index1++)
                   {
                   hit = 0;
                   for ( index2=0 ; index2<nbEmissions; index2++) // Boucle sur les heures de la journée 0h-23h
                   {   
                       // Recherche du programme présent à l'heure donnée
                       if (prgTV[index2].ProgrammeHeure(index1))
                       // Affichage du programme trouvé
                       { prgTV[index2].AfficherLigne(index1);
                         hit =1;
                       }
                   }
                   // Si aucun programme trouvé, on affiche "rien" dans la grille
                   if (hit==0) System.out.println(index1+"h\t:\trien");

                   } 
               //Ecriture dans le fichier de Log
               fw.write ("INFO  :"+dateFormat1.format(date1)+": Fermeture du programme\r\n");
               // fermeture du fichier de Log
               fw.close();
           
           
            } // sequence try/catch pour pouvoir gérer les ecritures sur le fichier de Log
            catch(IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
}