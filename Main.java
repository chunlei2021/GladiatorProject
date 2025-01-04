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
        Gladiatore gUtente[] = new Gladiatore[6];
        Gladiatore gNemico[] = new Gladiatore[6];

        System.out.println(blue + bold + "=====================================");
        System.out.println(" Benvenuto nel gioco dei Gladiatori!");
        System.out.println("=====================================\n" + reset);

        //Configurazione dei gladiatori utente
        for(int i = 0; i < gUtente.length; i++){
            System.out.println("\nConfigurazione del Gladiatore " + (i+1) + "...");
            gUtente[i] = new Gladiatore();
            int temp = i+1;
            gUtente[i].setId(temp);
            gUtente[i].configGladiatore(gUtente[i]);
        }
        gUtente[0].listaGladiatori(gUtente);

        //Configurazione dei gladiatori nemici
        for(int i = 0; i < gNemico.length; i++){
            System.out.println("Configurazione del Gladiatore nemico " + (i+1) + "...");
            gNemico[i] = new Gladiatore();
            int temp = i+1;
            gNemico[i].setId(temp);
            gNemico[i].configGladiatoreNemico(gNemico[i], gUtente[i]);
        }
        gNemico[0].listaGladiatori(gNemico);

        System.out.println(blue + "Vuoi iniziare la battaglia? (si/no)" + reset);
        String inizio = input.nextLine();
        inizio = inizio.toLowerCase();
        
        if(inizio.equals("si")){
            
            System.out.println(blue + bold + "\n---- INIZIA LA BATTAGLIA! ----\n" + reset);
            boolean risp2 = true;
            while(risp2){
                int sceltaUtente = gUtente[0].scegliGladiatore(gUtente); //Da controllare
                int sceltaNemico = gNemico[0].scegliGladiatore(gNemico); //Da controllare
                //Inizio vero proprio della battaglia
                String risposta;
                boolean risp = true;
                while(risp){
                    System.out.println("Stai combattendo con il Gladiatore ID \"" + gUtente[sceltaUtente].getId() + "\" contro il Gladiatore ID \"" + gNemico[sceltaNemico].getId() + "\"");
                    gUtente[sceltaUtente].combattimento(gNemico[sceltaNemico]);
                    gUtente[0].checkStatus(gUtente);
                    gNemico[0].checkStatus(gNemico); 
                    if(gUtente[sceltaUtente].getPuntiSalute() <= 0){
                        System.out.println(red + bold + "Il tuo Gladiatore \"" + gUtente[sceltaUtente].getNome() + "\" ha perso!" + reset); // Stampare gli HP rimasti, e stampare che l'altro gadiatore ha vinto
                        break;
                    } else if(gNemico[sceltaNemico].getPuntiSalute() <= 0){
                        System.out.println(green + bold + "Il Gladiatore \"" + gNemico[sceltaNemico].getNome() + "\" è morto! Hai vinto!!" + reset); // Stampare gli HP rimasti, e stampare che l'altro gladiatore ha vinto
                        break;
                    }
                    System.out.println("[Per vedere la lista corta dei gladiatori scrivere \"lista\"]");
                    risposta = input.nextLine(); risposta = risposta.toLowerCase();
                    if(risposta.equals("lista")){
                        gUtente[0].listaGladiatoriCorto(gUtente);
                    }

                    System.out.println("Vuoi continuare la battaglia? (si/no oppure premere \"Invio\")");
                    risposta = input.nextLine(); risposta = risposta.toLowerCase();
                    if(risposta.equals("si")){
                        System.out.println(green + "Si continua la battaglia!" + reset);
                    } else if(risposta.equals("no")){
                        System.out.println("Fine della battaglia!");
                        risp = false;
                        if(gUtente[sceltaUtente].getPuntiSalute() > gNemico[sceltaNemico].getPuntiSalute()){
                            System.out.println(green + bold + "Il tuo Gladiatore \"" + gUtente[sceltaUtente].getNome() + "\" ha vinto la battaglia! (HP rimasti: " + gUtente[sceltaUtente].getPuntiSalute() + ")" + reset);
                        } else {
                            System.out.println(red + bold + "Il Gladiatore \"" + gNemico[sceltaNemico].getNome() + "\" ha vinto la battaglia! (HP rimasti: " + gNemico[sceltaNemico].getPuntiSalute() + ")" + reset);
                        } 
                    } else {
                        System.out.println(green + "Continua la battaglia!" + reset);
                    }
                }
                gUtente[sceltaUtente].incrementaLivello(gUtente[sceltaUtente].getEsperienza());
                gNemico[sceltaNemico].incrementaLivello(gNemico[sceltaNemico].getEsperienza());
                System.out.println("Il Gladiatore \"" + gNemico[sceltaNemico].getNome() + "\" ha guadagnato " + gNemico[sceltaNemico].getEsperienza() + " XP! [Livello: " + gNemico[sceltaNemico].getLivello() + "]");
                System.out.println("Il tuo Gladiatore \"" + gUtente[sceltaUtente].getNome() + "\" ha guadagnato " + gUtente[sceltaUtente].getEsperienza() + " XP! [Livello: " + gUtente[sceltaUtente].getLivello() + "]");
                //Prossima battaglia con i gladiatori rimasti
                System.out.println(blue + "Vuoi iniziare la prossima battaglia? (si/no)" + reset);
                inizio = input.nextLine(); inizio = inizio.toLowerCase();
                if(inizio.equals("no")){
                    risp2 = false;
                } else {
                    //controlla se ci sono gladiatori rimasti
                    int check = 0;
                    for(int i = 0; i < gUtente.length; i++){
                        if(gUtente[i].getPuntiSalute() > 0 && gUtente[i].getStatus().equals("Disponibile")){
                            check++;
                        }
                    }
                    if(check == 6){
                        System.out.println(red + bold + "Non ci sono più gladiatori rimasti! Fine del gioco!" + reset);
                        risp2 = false;
                    }
                }
                
            }
            //Fine battaglia
            int vivoUtenti = 0;
            int vivoNemici = 0;
            for(int i = 0; i < gUtente.length; i++){
                if(gUtente[i].getPuntiSalute() <= 0 && gUtente[i].getStatus().equals("Disponibile")){
                    vivoUtenti = vivoUtenti+1;
                }
            }
            for(int i = 0; i < gNemico.length; i++){
                if(gNemico[i].getPuntiSalute() <= 0 && gNemico[i].getStatus().equals("Disponibile")){
                    vivoNemici = vivoNemici+1;
                }
            }
            if(vivoUtenti > vivoNemici){
                System.out.println(green + bold + "Hai vinto la battaglia! Complimenti! [Gladiatori Rimasti: " + vivoUtenti + "]" + reset);
            } else if(vivoUtenti < vivoNemici){
                System.out.println(red + bold + "Hai perso la battaglia! Peccato! [Gladiatori Rimasti: " + vivoNemici + "]" + reset);
            } else {
                System.out.println(blue + bold + "Pareggio! Nessuno ha vinto!" + reset);
            }
            System.out.println("\nLa lista corta dei gladiatori fine battaglia: ");
            gUtente[0].listaGladiatoriCorto(gNemico);
            gNemico[0].listaGladiatoriCorto(gNemico);
            System.out.println(blue + "\n---- FINE GIOCO! ----" + reset);

    } else {
        System.out.println(red + bold + "Fine del gioco!" + reset);
    }
    input.close();

    }
}
