package fr.dampierre;

import java.util.Random;


public class App {
    
    public static void main(String[] args) {
    
        int nbLancers = 5;
        int caseObjectif = 20;
        
        jouerPartie(nbLancers, caseObjectif);
        
    }
    public static void jouerPartie(int nbLancers, int caseObjectif){
        
         int compteurSimulations = 0;
        boolean gagne = false;
        while (!gagne) {
            compteurSimulations++;
            int caseCourante = 0;
              Random generateur = new Random();

            for (int i = 1; i <= nbLancers; i++) {
                  caseCourante= LancerDes(generateur,caseCourante,i);
         } 
            gagne= testeVictoire(caseCourante, caseObjectif, compteurSimulations);
         }

}
        //jouer partie
    

         //Lancer de dés
     public static int LancerDes(Random generateur,int caseCourante,int nbrLancer){
        int lancer = generateur.nextInt(6) + 1;
        caseCourante = caseCourante + lancer;
        System.out.println(String.format("Lancer %d : vous avez fait %d. Vous êtes sur la case %d.",
        nbrLancer, lancer, caseCourante));
        return caseCourante;

     }


         // teste de victoire
     public static boolean testeVictoire(int caseCourante, int caseObjectif, int compteurSimulations){
        boolean gagne= false;
     if (caseCourante == caseObjectif) {
        System.out.println("Vous avez gagné !");
        System.out.println("Il aura fallu " + compteurSimulations + " simulations pour gagner.");
         gagne = true;
        } else if (caseCourante > caseObjectif) {
        System.out.println("Vous dépassez, vous avez perdu !");
        } else {
        System.out.println("Il vous en manque pour arriver à " + caseObjectif + " !");
        }

        return gagne;
     }
}
