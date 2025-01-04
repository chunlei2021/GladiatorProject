/*Progetto di fine anno sui Gladiatori
[Realizzato da Camozzo e Petrini] 
*/

import java.util.Scanner;
//import java.util.Random;
//import java.util.Arrays;

public class Main{
    static final String red = "\u001B[31m";
    static final String green = "\u001B[32m";
    static final String reset = "\u001B[0m";
    static final String blue = "\u001B[34m";
    static final String bold = "\u001B[1m";
    static final String underline = "\u001B[4m";
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Random random = new Random();
        Gladiatore g[] = new Gladiatore[2];

        System.out.println(blue + bold + "=====================================");
        System.out.println(" Benvenuto nel gioco dei Gladiatori!");
        System.out.println("=====================================\n" + reset);

        System.out.println("Configurazione del tuo galadiatore...\n");
        //Il primo gladiatore
        g[0] = new Gladiatore();
        g[0].configGladiatore(g[0]);
        System.out.println("\nPrimo Gladiatore >>");
        System.out.println(g[0]);
        
        System.out.println("\nConfigurazione del secondo gladiatore...");
        //Il secondo gladiatore
        g[1] = new Gladiatore();
        g[1].configGladiatoreNemico(g[1], g[0]);
        System.out.println("Secondo Gladiatore >>");
        System.out.println(g[1]);

        System.out.println(blue + "Vuoi iniziare la battaglia? (si/no)" + reset);
        String inizio = input.nextLine();
        inizio = inizio.toLowerCase();
        
        if(inizio.equals("si")){
            
            System.out.println(blue + bold + "\n---- INIZIA LA BATTAGLIA! ----\n" + reset);
            //Inizio vero proprio della battaglia
            String risposta = "si";
            boolean risp = true;
            while(risp){
                g[0].combattimento(g[1]);

                if(g[0].getPuntiSalute() <= 0){
                    System.out.println(red + bold + "Il tuo Gladiatore \"" + g[0].getNome() + "\" ha perso!" + reset); // Stampare gli HP rimasti, e stampare che l'altro gadiatore ha vinto
                    g[0].checkStatus(g[0]);
                    break;
                } else if(g[1].getPuntiSalute() <= 0){
                    System.out.println(green + bold + "Il Gladiatore \"" + g[1].getNome() + "\" è morto! Hai vinto!!" + reset); // Stampare gli HP rimasti, e stampare che l'altro gladiatore ha vinto
                    g[1].checkStatus(g[1]);
                    break;
                }
                System.out.println("[Per vedere la lista dei gladiatori scrivere \"listagladiatori\"]");
                risposta = input.nextLine(); risposta = risposta.toLowerCase();
                if(risposta.equals("listagladiatori")){
                    g[0].listaGladiatori(g);
                }

                System.out.println("Vuoi continuare la battaglia? (si/no oppure premere \"Invio\")");
                risposta = input.nextLine(); risposta = risposta.toLowerCase();
                if(risposta.equals("si")){
                    System.out.println(green + "Si continua la battaglia!" + reset);
                } else if(risposta.equals("no")){
                    System.out.println("Fine della battaglia!");
                    risp = false;
                    if(g[0].getPuntiSalute() > g[1].getPuntiSalute()){
                        System.out.println(green + bold + "Il tuo Gladiatore \"" + g[0].getNome() + "\" ha vinto la battaglia! (HP rimasti: " + g[0].getPuntiSalute() + ")" + reset);
                    } else {
                        System.out.println(red + bold + "Il Gladiatore \"" + g[1].getNome() + "\" ha vinto la battaglia! (HP rimasti: " + g[1].getPuntiSalute() + ")" + reset);
                    } 
                } else {
                    System.out.println(green + "Continua la battaglia!" + reset);
                }
            }
            g[0].incrementaLivello(g[0].getEsperienza());
            g[1].incrementaLivello(g[1].getEsperienza());
            System.out.println("Il Gladiatore \"" + g[1].getNome() + "\" ha guadagnato " + g[1].getEsperienza() + " XP! [Livello: " + g[1].getLivello() + "]");
            System.out.println("Il tuo Gladiatore \"" + g[0].getNome() + "\" ha guadagnato " + g[0].getEsperienza() + " XP! [Livello: " + g[0].getLivello() + "]");
            //Fine battaglia
            System.out.println("\nLa lista dei gladiatori disponibili: ");
            g[0].listaGladiatori(g);
            System.out.println(blue + "\n---- FINE BATTAGLIA! ----" + reset);
    } else {
        System.out.println(red + bold + "Fine del gioco!" + reset);
    }
    input.close();

    }
}
