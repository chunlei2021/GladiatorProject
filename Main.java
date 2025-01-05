/*Progetto di fine anno sui Gladiatori
[Realizzato da Camozzo e Petrini] 

Il gioco dei Gladiatori è un gioco di combattimento a turni in cui il giocatore deve scegliere il proprio gladiatore e combattere contro i gladiatori nemici.
Il gioco è composto da 12 gladiatori, 6 per il giocatore e 6 per il nemico. Ogni gladiatore ha delle caratteristiche come il nome, il livello, i punti salute, l'attacco, la difesa e l'attacco speciale.
Il giocatore può scegliere il proprio gladiatore e combattere contro i gladiatori nemici. Il gioco termina quando il giocatore o i nemici non hanno più gladiatori disponibili.
*/
import java.util.Scanner;
//import java.util.Random;
//import java.util.Arrays;

public class Main{
    //Colori per la console
    static final String red = "\u001B[31m";
    static final String green = "\u001B[32m";
    static final String reset = "\u001B[0m";
    static final String blue = "\u001B[34m";
    static final String bold = "\u001B[1m";
    static final String underline = "\u001B[4m";
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Random random = new Random();
        //Creazione dei gladiatori
        Gladiatore gUtente[] = new Gladiatore[6];
        Gladiatore gNemico[] = new Gladiatore[6];

        System.out.println(blue + bold + "=====================================");
        System.out.println(" Benvenuto nel gioco dei Gladiatori!");
        System.out.println("=====================================\n" + reset);

        //Configurazione dei gladiatori utente
        for(int i = 0; i < gUtente.length; i++){
            System.out.println("\nConfigurazione del Gladiatore " + i + "...");
            gUtente[i] = new Gladiatore();
            gUtente[i].setId(i);
            gUtente[i].configGladiatore(gUtente[i]);
        }
        gUtente[0].listaGladiatori(gUtente); //Stampa lista gladiatori

        //Configurazione dei gladiatori nemici
        for(int i = 0; i < gNemico.length; i++){
            System.out.println("Configurazione del Gladiatore nemico " + i + "...");
            gNemico[i] = new Gladiatore();
            gNemico[i].setId(i);
            gNemico[i].configGladiatoreNemico(gNemico[i], gUtente);
        }
        // Controllo se ci sono gladiatori con lo stesso nome
        for (int i = 0; i < gNemico.length; i++) {
            for (int j = i + 1; j < gNemico.length; j++) {
            do {
                if (gNemico[i].getNome().equals(gNemico[j].getNome())) {
                String temp = gNemico[i].configNomeNemico(gNemico);
                gNemico[i].setNome(temp);
                }
            } while (gNemico[i].getNome().equals(gNemico[j].getNome()));
            }
        }
        gNemico[0].listaGladiatori(gNemico); //Stampa lista gladiatori nemici

        System.out.println(blue + "Vuoi iniziare la battaglia? (si/no)" + reset);
        String inizio = input.nextLine();
        inizio = inizio.toLowerCase();
        
        if(inizio.equals("si")){
            
            System.out.println(blue + bold + "\n---------- INIZIA LA BATTAGLIA! ---------\n" + reset);
            boolean risp2 = true;
            while(risp2){
                int sceltaUtente = gUtente[0].scegliGladiatore(gUtente); //scelta del gladiatore utente
                int sceltaNemico = gNemico[0].scegliGladiatoreNemico(gNemico); //scelta del gladiatore nemico
                //Inizio vero proprio della battaglia
                String risposta;
                boolean risp = true;
                int cond1 = 0; int cond2 = 0;
                while(risp){
                    //Inizio combattimento
                    System.out.println(blue + bold + "\n---- " + gUtente[sceltaUtente].getNome() + " VS " + gNemico[sceltaNemico].getNome() + " ----\n" + reset);
                    gUtente[sceltaUtente].combattimento(gNemico[sceltaNemico]);
                    gUtente[0].checkStatus(gUtente);
                    gNemico[0].checkStatus(gNemico); 
                    cond1 = gUtente[sceltaUtente].modificaCondizione(cond1); 
                    gUtente[sceltaUtente].rigeneraAttaccoSpeciale(cond1);
                    cond2 = gNemico[sceltaNemico].modificaCondizione(cond2); 
                    gNemico[sceltaNemico].rigeneraAttaccoSpeciale(cond2); //Rigenera attacco speciale
                    //Controlla se uno dei due gladiatori ha perso
                    if(gUtente[sceltaUtente].getPuntiSalute() <= 0){
                        System.out.println(red + bold + "Il tuo Gladiatore \"" + gUtente[sceltaUtente].getNome() + "\" ha perso! (HP rimasti a te: " + gUtente[sceltaUtente].getPuntiSalute() + ", XP: " + gUtente[sceltaUtente].getEsperienza() + ")" + reset);
                        break;
                    } else if(gNemico[sceltaNemico].getPuntiSalute() <= 0){
                        System.out.println(green + bold + "Il Gladiatore \"" + gNemico[sceltaNemico].getNome() + "\" è morto! Hai vinto!! (HP rimasti a te: " + gUtente[sceltaUtente].getPuntiSalute() + ", XP: " + gUtente[sceltaUtente].getEsperienza() + ")" + reset);
                        break;
                    }
                    //Stampa lista gladiatori
                    System.out.println("[Per vedere la lista corta dei gladiatori scrivere \"lista\", del nemico scrivere \"listanemico\", altrimenti premere \"Invio\"]");
                    risposta = input.nextLine(); risposta = risposta.toLowerCase();
                    if(risposta.equals("lista")){
                        gUtente[0].listaGladiatoriCorto(gUtente);
                    } else if(risposta.equals("listanemico")){
                        gNemico[0].listaGladiatoriCorto(gNemico);
                    } 
                    System.out.println("Vuoi continuare la battaglia? (si/no oppure premere \"Invio\")");
                    risposta = input.nextLine(); risposta = risposta.toLowerCase();
                    if(risposta.equals("si")){
                        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------+");
                        System.out.println(green + "Si continua la battaglia!" + reset);
                    } else if(risposta.equals("no")){
                        System.out.println("Fine del combattimento!");
                        risp = false;
                        if(gUtente[sceltaUtente].getPuntiSalute() > gNemico[sceltaNemico].getPuntiSalute()){
                            System.out.println(green + bold + "Il tuo Gladiatore \"" + gUtente[sceltaUtente].getNome() + "\" ha vinto la battaglia! (HP rimasti: " + gUtente[sceltaUtente].getPuntiSalute() + ", XP: " + gUtente[sceltaUtente].getEsperienza() + ")" + reset);
                        } else {
                            System.out.println(red + bold + "Il Gladiatore \"" + gNemico[sceltaNemico].getNome() + "\" ha vinto la battaglia! (HP rimasti: " + gNemico[sceltaNemico].getPuntiSalute() + ", XP: " + gNemico[sceltaNemico].getEsperienza() + ")" + reset);
                        } 
                    } else {
                        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------+");
                        System.out.println(green + "Continua la battaglia!" + reset);
                    }
                }
                gUtente[sceltaUtente].incrementaLivello(gUtente[sceltaUtente].getEsperienza());
                gNemico[sceltaNemico].incrementaLivello(gNemico[sceltaNemico].getEsperienza());
                System.out.println("Il Gladiatore \"" + gNemico[sceltaNemico].getNome() + "\" ha guadagnato " + gNemico[sceltaNemico].getEsperienza() + " XP! [Livello: " + gNemico[sceltaNemico].getLivello() + "]");
                System.out.println("Il tuo Gladiatore \"" + gUtente[sceltaUtente].getNome() + "\" ha guadagnato " + gUtente[sceltaUtente].getEsperienza() + " XP! [Livello: " + gUtente[sceltaUtente].getLivello() + "]");
                //Prossima battaglia con i gladiatori rimasti
                System.out.println(blue + "Vuoi iniziare il prossimo combattimento? (si/no)" + reset);
                inizio = input.nextLine(); inizio = inizio.toLowerCase();
                if(inizio.equals("no")){
                    System.out.println(red + bold + "Fine del gioco!" + reset);
                    risp2 = false;
                } else {
                    //controlla se ci sono gladiatori rimasti
                    int check = gUtente[0].checkDisponibilità(gUtente);
                    if(check == 0){
                        System.out.println(red + bold + "Non ci sono più gladiatori rimasti! Fine del gioco!" + reset);
                        risp2 = false;
                    }
                    int chekcNemico = gNemico[0].checkDisponibilità(gNemico);
                    if(chekcNemico == 0){
                        System.out.println(green + bold + "Hai sconfitto tutti i gladiatori nemici! Complimenti! Fine del gioco!" + reset);
                        risp2 = false;
                    }
                }
                
            }
            //Fine battaglia
            int vivoUtenti = gUtente[0].checkDisponibilità(gUtente); //Controlla quanti gladiatori sono rimasti
            int vivoNemici = gNemico[0].checkDisponibilità(gNemico);//Controlla quanti gladiatori nemici sono rimasti
            //Stampa risultato battaglia
            if(vivoUtenti > vivoNemici){
                System.out.println(green + bold + "Hai vinto la battaglia! Complimenti! [Gladiatori Rimasti: " + vivoUtenti + "]" + reset);
            } else if(vivoUtenti < vivoNemici){
                System.out.println(red + bold + "Hai perso la battaglia! Peccato! [Gladiatori Rimasti al nemico: " + vivoNemici + "]" + reset);
            } else {
                System.out.println(blue + bold + "Pareggio! Nessuno ha vinto!" + reset);
            }
            System.out.println("\nVuoi vedere la lista corta dei gladiatori? (si/no)");
            if(input.nextLine().equals("si")){ //Stampa lista corta gladiatori
                System.out.println("\nLa lista corta dei gladiatori fine battaglia: ");
                gUtente[0].listaGladiatoriCorto(gUtente);
                System.out.println("\nLa lista corta dei gladiatori nemici fine battaglia: ");
                gNemico[0].listaGladiatoriCorto(gNemico);
            }
    } else {
        System.out.println(red + bold + "Fine del gioco!" + reset);
    }
    input.close();
    System.out.println(blue + bold + "\n----------  FINE GIOCO ---------\n" + reset); //Fine gioco

    }
}
