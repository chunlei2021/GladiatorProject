/*Progetto di fine anno sui Gladiatori
[Realizzato da Camozzo e Petrini] 
*/

import java.util.Scanner;
//import java.util.Random;
//import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Random random = new Random();

        System.out.println("=====================================");
        System.out.println(" Benvenuto nel gioco dei Gladiatori!");
        System.out.println("=====================================\n");

        String armamenti[] = {"Spada","Coltello"};
        System.out.println("Inserisci il nome: ");
        String nome = input.nextLine();
        System.out.println("Inserisci il tipo: ");
        String tipo = input.nextLine();
        System.out.println("Inserisci la provenienza: ");
        String provenienza = input.nextLine();
        //Il primo gladiatore
        Gladiatore g1 = new Gladiatore (nome, tipo, armamenti, provenienza);
        System.out.println("\nPrimo Gladiatore: \n"+g1);

        armamenti = new String[]{"Lancia", "Scudo"};
        System.out.println("\nInserisci il nome: ");
        nome = input.nextLine();
        System.out.println("Inserisci il tipo: ");
        tipo = input.nextLine();
        System.out.println("Inserisci la provenienza: ");
        provenienza = input.nextLine();
        //Il secondo gladiatore
        Gladiatore avversario = new Gladiatore(nome, tipo, armamenti, provenienza);
        System.out.println("\nSecondo Gladiatore: \n" + avversario);

        System.out.println("\n--- INIZIA LA BATTAGLIA! ---\n");
        //Inizio vero proprio della battaglia
        while(g1.getPuntiSalute() > 0 && avversario.getPuntiSalute() > 0){
            g1.combattimento(avversario);

            int xp;
            if(g1.getPuntiSalute() <= 0){
                System.out.println("Il Gladiatore \"" + g1.getNome() + "\" è morto!");
                System.out.println("Il Gladiatore \"" + avversario.getNome() + "\" ha guadagnato " + avversario.getEsperienza() + " XP!");
                System.out.println("Il Gladiatore \"" + g1.getNome() + "\" ha guadagnato " + g1.getEsperienza() + " XP!");
                break;
            } else if(avversario.getPuntiSalute() <= 0){
                System.out.println("Il Gladiatore \"" + avversario.getNome() + "\" è morto!");
                System.out.println("Il Gladiatore \"" + g1.getNome() + "\" ha guadagnato " + g1.getEsperienza() + " XP!");
                System.out.println("Il Gladiatore \"" + avversario.getNome() + "\" ha guadagnato " + avversario.getEsperienza() + " XP!");
                break;
            }
        }
        //Continuare a scrivere il codice di questo blocco graffo per la battaglia
        System.out.println("\n--- FINE BATTAGLIA! ---");
        
        input.close();
    }
}
