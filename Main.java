/*Progetto di fine anno sui Gladiatori
[Realizzato da Camozzo e Petrini] 
*/

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Benvenuto nel gioco dei Gladiatori!");
        System.out.println("Test");
        int esperienza = random.nextInt(31)+40;
        int puntiSalute = random.nextInt(31)+40;
        int attacco = random.nextInt(31)+40;
        int difesa = random.nextInt(31)+40;
        int velocità = random.nextInt(31)+40;
        int attaccoSpeciale = random.nextInt(31)+40;
        String armamenti[] = {"Spada","Coltello"};
        
        Gladiatore g1 = new Gladiatore ("Marco", "Attacante",esperienza,puntiSalute,attacco,difesa,velocità,attaccoSpeciale,armamenti,"Roma",0);
        System.out.println("g1: \n"+g1);
        
    }
}
 
