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
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Random random = new Random();
        Gladiatore g[] = new Gladiatore[2];

        System.out.println(blue + "=====================================");
        System.out.println(" Benvenuto nel gioco dei Gladiatori!");
        System.out.println("=====================================\n" + reset);
        System.out.println("Inserisci il nome: ");
        String nome = input.nextLine();
        System.out.println("Inserisci la provenienza: ");
        String provenienza = input.nextLine();
        String armamenti[] = new String []{"pugnale","scudo"};
        //Il primo gladiatore
        g[0] = new Gladiatore(nome, armamenti, provenienza);
        String tipo=g[0].personaggio();
        g[0].setTipo(tipo);
        System.out.println("\nPrimo Gladiatore: \n" + g[0]);
        
        armamenti = new String[]{"Lancia", "Scudo"};
        System.out.println("\nInserisci il nome: ");
        nome = input.nextLine();
        System.out.println("Inserisci il tipo: ");
        tipo = input.nextLine();
        System.out.println("Inserisci la provenienza: ");
        provenienza = input.nextLine();
        //Il secondo gladiatore
        g[1] = new Gladiatore(nome, tipo, armamenti, provenienza);
        System.out.println("\nSecondo Gladiatore: \n" + g[1]);

        System.out.println(blue + "\n--- INIZIA LA BATTAGLIA! ---\n" + reset);
        //Inizio vero proprio della battaglia
        String risposta = "si";
        boolean risp = true;
        while(risp){
            g[0].combattimento(g[1]);

            if(g[0].getPuntiSalute() <= 0){
                System.out.println(red + "Il Gladiatore \"" + g[0].getNome() + "\" ha perso!" + reset); // Stampare gli HP rimasti, e stampare che l'altro gadiatore ha vinto
                break;
            } else if(g[1].getPuntiSalute() <= 0){
                System.out.println(green + "Il Gladiatore \"" + g[1].getNome() + "\" è morto!" + reset); // Stampare gli HP rimasti, e stampare che l'altro gladiatore ha vinto
                break;
            }

            System.out.println("Vuoi continuare la battaglia? (si/no)");
            risposta = input.nextLine();
            risposta = risposta.toLowerCase();
            if(risposta.equals("si")){
                System.out.println(green + "Si continua la battaglia!" + reset);
            } else if(risposta.equals("no")){
                System.out.println("Fine della battaglia!");
                risp = false;
                if(g[0].getPuntiSalute() > g[1].getPuntiSalute()){
                    System.out.println(green + "Il Gladiatore \"" + g[0].getNome() + "\" ha vinto la battaglia! (HP rimasti: " + g[0].getPuntiSalute() + ")" + reset);
                } else {
                    System.out.println(red + "Il Gladiatore \"" + g[1].getNome() + "\" ha vinto la battaglia! (HP rimasti: " + g[1].getPuntiSalute() + ")" + reset);
                } 
            } else {
                System.out.println(green + "Continua la battaglia!" + reset);
            }
        }
        System.out.println("Il Gladiatore \"" + g[1].getNome() + "\" ha guadagnato " + g[1].getEsperienza() + " XP!");
        System.out.println("Il Gladiatore \"" + g[0].getNome() + "\" ha guadagnato " + g[0].getEsperienza() + " XP!");
        //Continuare a scrivere il codice di questo blocco graffo per la battaglia
        System.out.println(blue + "\n--- FINE BATTAGLIA! ---" + reset);
        
        input.close();
    }
}
