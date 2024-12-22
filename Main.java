/*Progetto di fine anno sui Gladiatori
[Realizzato da Camozzo e Petrini] 
*/

import java.util.Scanner;
import java.util.Random;
//import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=====================================");
        System.out.println(" Benvenuto nel gioco dei Gladiatori!");
        System.out.println("=====================================\n");

        int esperienza = random.nextInt(31)+40;
        int puntiSalute = random.nextInt(31)+40;
        int attacco = random.nextInt(31)+40;
        int difesa = random.nextInt(31)+40;
        int velocità = random.nextInt(31)+40;
        int attaccoSpeciale = random.nextInt(31)+40;
        String armamenti[] = {"Spada","Coltello"};
        System.out.println("Inserisci il nome: ");
        String nome = input.nextLine();
        System.out.println("Inserisci il tipo: ");
        String tipo = input.nextLine();
        System.out.println("Inserisci la provenienza: ");
        String provenienza = input.nextLine();
        //Il primo gladiatore
        Gladiatore g1 = new Gladiatore (nome, tipo, esperienza, puntiSalute, attacco, difesa, velocità, attaccoSpeciale, armamenti, provenienza, 0);
        System.out.println("\nPrimo Gladiatore: \n"+g1);

        esperienza = random.nextInt(31) + 40;
        puntiSalute = random.nextInt(31) + 40;
        attacco = random.nextInt(31) + 40;
        difesa = random.nextInt(31) + 40;
        velocità = random.nextInt(31) + 40;
        attaccoSpeciale = random.nextInt(31) + 40;
        armamenti = new String[]{"Lancia", "Scudo"};
        System.out.println("\nInserisci il nome: ");
        nome = input.nextLine();
        System.out.println("Inserisci il tipo: ");
        tipo = input.nextLine();
        System.out.println("Inserisci la provenienza: ");
        provenienza = input.nextLine();
        //Il secondo gladiatore
        Gladiatore g2 = new Gladiatore(nome, tipo, esperienza, puntiSalute, attacco, difesa, velocità, attaccoSpeciale, armamenti, provenienza, 0);
        System.out.println("\nSecondo Gladiatore: \n" + g2);
        
        //System.out.println("Vuoi continuare a giocare? [s/n]");
        input.close();
    }
}
