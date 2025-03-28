/*Progetto di fine anno sui Gladiatori
[Realizzato da Camozzo e Petrini] 

Il gioco dei Gladiatori è un gioco di combattimento a turni in cui il giocatore deve scegliere il proprio gladiatore e combattere contro i gladiatori nemici.
Il gioco è composto da 12 gladiatori, 6 per il giocatore e 6 per il nemico. Ogni gladiatore ha delle caratteristiche come il nome, il livello, i punti salute, l'attacco, la difesa e l'attacco speciale.
Il giocatore può scegliere il proprio gladiatore e combattere contro i gladiatori nemici. Il gioco termina quando il giocatore o i nemici non hanno più gladiatori disponibili.
*/
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Gladiatore{
    private int id;
    private String status;
    private String nome;
    private String tipo;
    private int esperienza;
    private float puntiSalute;
    private int attacco;
    private int difesa;
    private int velocità;
    private int attaccoSpeciale;
    private static final int DIM = 10;
    private String armamenti[] = new String[DIM];
    private String provenienza;
    private int livello;
    //Costruttore Gladatore
    public Gladiatore(){
        this.id = 0;
        this.status = "Disponibile"; 
        this.nome="";
        this.tipo="";
        this.esperienza=0;
        this.puntiSalute=random();
        this.attacco=random();
        this.difesa=random();
        this.velocità=random();
        this.attaccoSpeciale=1;
        this.armamenti=new String[DIM];
        this.provenienza="";
        this.livello=1;
    }
    //Random numeri per le caratteristiche del gladiatore
    public int random(){
        Random random = new Random();
        return random.nextInt(31)+40;
    }
    //Metodo media, per calcolare la media dei valori degli attributi del gladiatore
    public float media(){
        return totale()/6;
    }
    //Metodo totale, per calcolare la somma dei valori degli attributi del gladiatore
    public float totale(){
        return esperienza+puntiSalute+attacco+difesa+velocità+attaccoSpeciale; 
    }
    //Metodo toString, per stampare tutti gli attributi del gladiatore
    public String toString(){
        String linea = "+----------------------+----------------------+----------------------+-------------------------------------+----------------------+----------------------+";
        String tabella = "| %-20s | %-20s | %-20s | %-32s XP | %-17s HP | %-20s |%n";
        String tabella2 = "| %-20s | %-20s | %-20s | %-35s | %-20s | %-20s |%n";
        String tabella3 = "| %-20s | %-20s   %-20s   %-35s   %-20s   %-20s |%n";
        System.out.println(linea);
        System.out.printf(tabella3, "ID:", id, "", "", "", "");
        System.out.println(linea);
        System.out.print(bold);
        System.out.printf(tabella, "Status", "Nome", "Tipo", "Esperienza", "Punti Salute", "Attacco");
        System.out.print(reset);
        System.out.printf(tabella, status, nome, tipo, esperienza, puntiSalute, attacco);
        System.out.println(linea);
        System.out.print(bold);
        System.out.printf(tabella2,  "Difesa", "Velocità", "Attacco Speciale", "Armamenti", "Provenienza ", "Livello");
        System.out.print(reset);
        System.out.printf(tabella2, difesa, velocità, attaccoSpeciale, Arrays.toString(armamenti), provenienza, livello);
        System.out.println(linea);
        return "";
        //return "Nome: "+nome+"\nTipo: "+tipo+"\nEsperienza: "+esperienza+" XP\nPunti Salute: "+puntiSalute+"HP \nAttacco: "+attacco+"\nDifesa: "+difesa+"\nVelocità: "+velocità+"\nAttacco Speciale: "+attaccoSpeciale+"\nArmamenti: "+Arrays.toString(armamenti)+"\nProvenienza: "+provenienza+"\nLivello: "+livello+"\nMedia: "+media()+"\nTotale: "+totale();
    }
    //Metodi getter
    public int getId(){
        return id;
    }
    public String getStatus(){
        return status;
    }
    public String getNome(){
        return nome;
    }
    public String getTipo(){
        return tipo;
    }
    public int getEsperienza(){
        return esperienza;
    }
    public float getPuntiSalute(){
        return puntiSalute;
    }
    public int getAttacco(){
        return attacco;
    }
    public int getDifesa(){
        return difesa;
    }
    public int getVelocità(){
        return velocità;
    }
    public int getAttaccoSpeciale(){
        return attaccoSpeciale;
    }
    public String getArmamenti(){
        return Arrays.toString(armamenti);
    }
    public String getProvenienza(){
        return provenienza;
    }
    public int getLivello(){
        return livello;
    }
    //Metodi setter
    public void setId(int id){
        this.id=id;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setEsperienza(int esperienza){
        this.esperienza=esperienza;
    }
    public void setPuntiSalute(float puntiSalute){
        this.puntiSalute=puntiSalute;
    }
    public void setAttacco(int attacco){
        this.attacco=attacco;
    }
    public void setDifesa(int difesa){
        this.difesa=difesa;
    }
    public void setVelocità(int velocità){
        this.velocità=velocità;
    }
    public void setAttaccoSpeciale(int attaccoSpeciale){
        this.attaccoSpeciale=attaccoSpeciale;
    }
    public void setArmamenti(String armamenti[]){
        this.armamenti=armamenti;
    }
    public void setProvenienza(String provenienza){
        this.provenienza=provenienza;
    }
    public void setLivello(int livello){
        this.livello=livello;
    }
    //Colori per la stampa
    static final String red = "\u001B[31m";
    static final String green = "\u001B[32m";
    static final String blue = "\u001B[34m";
    static final String reset = "\u001B[0m";
    static final String bold = "\u001B[1m";
    static final String underline = "\u001B[4m";
    //Creo oggetto scanner per leggere i dati in input
    Scanner scan = new Scanner(System.in);
    //Metodo per configurare il gladiatore utente
    public void configGladiatore(Gladiatore oggetto){
        System.out.println(bold + "Inserisci il nome del tuo Gladiatore: " + reset);
        oggetto.listaNome();
        String nome = this.configNome();
        oggetto.setNome(nome);
        System.out.println(bold + "Inserisci la provenienza: " + reset);
        String provenienza = scan.nextLine();
        oggetto.setProvenienza(provenienza);
        String tipo=oggetto.configTipo();
        oggetto.setTipo(tipo);
        String armamenti[] = oggetto.configArmamenti();
        oggetto.setArmamenti(armamenti);
    }
    //metodo per configurare gladiatore nemico
    public void configGladiatoreNemico(Gladiatore oggetto, Gladiatore g[]){
        String nome = oggetto.configNomeNemico(g);
        oggetto.setNome(nome);
        String tipo = oggetto.configAutoTipo();
        oggetto.setTipo(tipo);
        String armamenti[] = oggetto.configArmamenti();
        oggetto.setArmamenti(armamenti);
        oggetto.setProvenienza("Roma");
    }
    //Metodo configTipo, per configurare il tipo del gladiatore
    public String configTipo(){
        System.out.println(blue + "Inserisci il tipo del Gladiatore [Inserisci un numero da 1 a 5]: " + reset);
        System.out.println("1. Traex [scudo piccolo, pugnale, lanci]");
        System.out.println("2. Murmillo [scudo romano, pugnale]");
        System.out.println("3. Retiarius [una rete, un tridente, pugnale]");
        System.out.println("4. Secutor [scudo arotondato, pugnale]");
        System.out.println("5. Provocator [scudo rettangolare, pungale]");
        int num;
        String personaggio;
        boolean risp = true;
        do{
            while (!scan.hasNextInt()) { //controllo se l'input è un numero
                System.out.println("Input non valido. Inserisci un numero.");
                scan.next();
            }
            num = scan.nextInt();
            switch(num){
                case 1:
                    personaggio = "Traex";
                    return personaggio;
                case 2:
                    personaggio = "Murmillo";
                    return personaggio;
                case 3:
                    personaggio = "Retiarius";
                    return personaggio;
                case 4:
                    personaggio = "Secutor";
                    return personaggio;
                case 5:
                    personaggio = "Provocator";
                    return personaggio;
                default:
                    System.out.println("Personaggio non trovato, reinseriscilo");        
            }
            
        }while(risp);
        
        return "";
    }
    //Metodo configAutoTipo, per configurare il tipo del gladiatore in modo automatico
    public String configAutoTipo(){
        Random random = new Random();
        int num = random.nextInt(5);
        String type = "";
        switch(num){
            case 0:
                type = "Traex";
                break;
            case 1:
                type = "Murmillo";
                break;
            case 2:
                type = "Retiarius";
                break;
            case 3:
                type = "Secutor";
                break;
            case 4:
                type = "Provocator";
                break;
            default:
                System.out.println("Tipo non trovato");
        }
        return type;
    }
    //Metodo configArmamenti, per configurare gli armamenti del gladiatore
    public String[] configArmamenti(){
        String [] armamenti = new String[DIM];
        String tipo = this.getTipo();
        switch(tipo){
            case "Traex":
                armamenti = new String[]{"scudo piccolo", "pugnale", "lanci"};
                break;
            case "Murmillo":
                armamenti = new String[]{"scudo romano", "pugnale"};
                break;
            case "Retiarius":
                armamenti = new String[]{"una rete", "un tridente", "pugnale"};
                break;
            case "Secutor":
                armamenti = new String[]{"scudo arotondato", "pugnale"};
                break;
            case "Provocator":
                armamenti = new String[]{"scudo rettangolare", "pungale"};
                break;
            default:
                System.out.println("Tipo non trovato");            
        }
        return armamenti;

    } 
    public void listaNome(){
        System.out.println("Lista dei nomi possibili: ");
        String linea = "+----------------------+-------------------------------------+";
        String tabella = "| %-20s | %-35s |%n";
        System.out.println(linea);
        System.out.printf(tabella, "1. Cicerone", "8. Narcisso");
        System.out.printf(tabella, "2. Seneca", "9. Priscio");
        System.out.printf(tabella, "3. Marziale", "10. Vero");
        System.out.printf(tabella, "4. Valerio Massimo", "11. Carpoforo");
        System.out.printf(tabella, "5. Spartaco", "12. Hilarius");
        System.out.printf(tabella, "6. Flamma", "13. Amazon");
        System.out.printf(tabella, "7. Marco Attilius", "14. Oppure inserire un altro nome");
        System.out.println(linea);
    }
    //Metodo per configurare il nome del gladiatore
    public String configNome(){
        String nome = "";
        boolean name = false;
        do{
            name = false;
            System.out.println("Inserisci il numero del nome del tuo Gladiatore: ");
            while (!scan.hasNextInt()) { //Controlla se l'input è un numero
            System.out.println("Input non valido. Inserisci un numero.");
            scan.next();
            }
            int numero = scan.nextInt();
            scan.nextLine();
            switch(numero){
                case 1:
                    nome = "Cicerone";
                    break;
                case 2:
                    nome = "Seneca";
                    break;
                case 3:
                    nome = "Marziale";
                    break;
                case 4:
                    nome = "Valerio Massimo";
                    break;
                case 5:
                    nome = "Spartaco";
                    break;
                case 6:
                    nome = "Flamma";
                    break;
                case 7:
                    nome = "Marco Attilius";
                    break;
                case 8:
                    nome = "Narcisso";
                    break;
                case 9:
                    nome = "Priscio";
                    break;
                case 10:
                    nome = "Vero";
                    break;
                case 11:
                    nome = "Carpoforo";
                    break;
                case 12:
                    nome = "Hilarius";
                    break;
                case 13:
                    nome = "Amazon";
                    break;
                case 14:
                    System.out.println("Inserisci un altro nome: ");
                    nome = scan.nextLine();
                    break;
                default:
                    System.out.println("Numero non valido, reinseriscilo");
                    name = true;
            }
        }while(name);
    return nome;
    }
    //Metodo configurare il nome del gladiatore Nemico
    public String configNomeNemico(Gladiatore g[]){
        String nome;
        Random random = new Random();
        boolean name;
        do{
            name = false;
            int num = random.nextInt(13);
            switch(num) {
                case 0: 
                    nome = "Cicerone";
                    break;
                case 1:
                    nome = "Seneca";
                    break;
                case 2:
                    nome = "Marziale";
                    break;
                case 3:
                    nome = "Valerio Massimo";
                    break;
                case 4:
                    nome = "Spartaco";
                    break;
                case 5:
                    nome = "Flamma";
                    break;
                case 6:
                    nome = "Marco Attilius";
                    break;
                case 7:
                    nome = "Narcisso";
                    break;
                case 8:
                    nome = "Priscio";
                    break;
                case 9:
                    nome = "Vero";
                    break;
                case 10:
                    nome = "Carpoforo";
                    break;
                case 11:
                    nome = "Hilarius";
                    break;
                case 12:
                    nome = "Amazon";
                    break;
                default:
                    nome = "Nessun nome";
            }
            for(int i = 0; i<g.length; i++){
                if(nome.equals(g[i].getNome())){
                    name = true;
                }
            }

        }while(name);

        return nome;
    }
    //Il metodo per output dei gladiatori 
    public void listaGladiatori(Gladiatore g[]){
        for(int i = 0; i<g.length; i++){
            System.out.print(g[i]);
            System.out.println();
        }
    }
    //Metodo per stampre la lista del gladiatori più corta
    public void listaGladiatoriCorto(Gladiatore g[]){
        for(int i = 0; i<g.length; i++){
            if(g[i].getPuntiSalute() > 0){
                String linea = "+----------------------+----------------------+----------------------+----------------------+----------------------+----------------------+";
                String tabella = "| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n";
                System.out.println(linea);
                System.out.print(bold);
                System.out.printf(tabella, "ID", "Nome", "Status", "Punti Salute", "Esperienza", "Livello");
                System.out.print(reset);
                System.out.println(linea);
                System.out.printf(tabella, g[i].getId(), g[i].getNome(), g[i].getStatus(), g[i].getPuntiSalute(), g[i].getEsperienza(), g[i].getLivello());
                System.out.println(linea);
            } else {
                System.out.print(red);
                String linea = "+----------------------+----------------------+----------------------+----------------------+----------------------+----------------------+";
                String tabella = "| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n";
                System.out.println(linea);
                System.out.printf(tabella, "ID", "Nome", "Status", "Punti Salute", "Esperienza", "Livello");
                System.out.println(linea);
                System.out.printf(tabella, g[i].getId(), g[i].getNome(), g[i].getStatus(), g[i].getPuntiSalute(), g[i].getEsperienza(), g[i].getLivello());
                System.out.println(linea);
                System.out.print(reset);
            }
        }
    }
    //Metodo per scegliere quale gladiatore far combatere
    public int scegliGladiatore(Gladiatore gUtente[]){
        System.out.println("Scegli il gladiatore con cui vuoi combattere [Inserisci un numero id da 0 a 5]: ");
        gUtente[0].listaGladiatoriCorto(gUtente);
        int num;
        do{
            while(!scan.hasNextInt()){
                System.out.println("Inserisci un numero valido");
                scan.next();
            }
            num = scan.nextInt();
            if (num >= 0 && num <= 5) {
                if (gUtente[num].getStatus().equals("Disponibile")) {
                    return num;
                } else {
                    System.out.println("Il gladiatore non è disponibile, scegline un altro");
                }
            } else {
                System.out.println("Numero non valido, reinseriscilo");
            }
        }while(true);
    }
    
    //Metodo per far scegliere al nemico quale gladiatore far combattere
    public int scegliGladiatoreNemico(Gladiatore gNemico[]){
        Random random = new Random();
        do{
            int num = random.nextInt(6);
            if(gNemico[num].getStatus().equals("Disponibile") && gNemico[num].getPuntiSalute() > 0){
                System.out.println("Il gladiatore nemico ha scelto il gladiatore con ID: "+ num);
                return num;
            }
        } while(true);
        
    }
    //Metodo per incrementare l'esperienza del gladiatore
    public int calcolaEsperienza(float danno) {
    return danno < 9 ? 10 : 15;
}
    //Metodo combattimento
    public void combattimento(Gladiatore nemico){
        Random random = new Random();
        int[] dato = new int[2];
        do{
            dato[0] = random.nextInt(20) + 1;
            dato[1] = random.nextInt(20) + 1;
        } while( dato[0] == dato[1]);
        
        float danno;
        System.out.println("[ Risultato del lancio del dado ] Al tuo gladiatore \""+this.getNome()+"\": "+dato[0]+". Al gladiatore \""+nemico.getNome()+"\": "+dato[1]);
        //float nuovaSalute;
        if(dato[0]>dato[1]){
            danno = this.danno(nemico);
            danno = this.calcolaAttacoSpeciale(danno);
            nemico.setPuntiSalute(nemico.getPuntiSalute() - danno);
            int xp = this.calcolaEsperienza(danno);
            this.setEsperienza(this.getEsperienza() + xp);
            System.out.println("Il tuo gladiatore \""+this.getNome()+"\" ha inflitto un danno [" + danno + "] al gladiatore \""+nemico.getNome()+ "\"");
            System.out.println(underline + "La salute del gladiatore nemico "+nemico.getNome()+" è: "+nemico.getPuntiSalute() + "HP" + reset); 
            System.out.println();   
        } else {
            danno = nemico.danno(this);
            danno = nemico.calcolaAttacoSpecialeNemico(danno);
            this.setPuntiSalute(this.getPuntiSalute() - danno);
            int xp1 = nemico.calcolaEsperienza(danno);
            nemico.setEsperienza(nemico.getEsperienza() + xp1);
            System.out.println("Il gladiatore nemico \""+nemico.getNome()+"\" ha inflitto un danno [" + danno + "] al tuo gladiatore \""+this.getNome() + "\"");
            System.out.println(underline + "La salute del tuo gladiatore \""+this.getNome()+"\" è: "+this.getPuntiSalute() + "HP" + reset);
            System.out.println();
        }
    }
    //Metodo danno, per calcolare il danno inflitto dal gladiatore
    public float danno(Gladiatore nemico){
        Random random = new Random();
        float rand = random.nextFloat() * 0.15f + 0.85f;
        float potenza = 20; 
        float danno = (2*livello/5) + (2*potenza*this.getAttacco()/nemico.getDifesa())+2;
        danno /= 5;
        danno *= rand;
        return danno;
    }
    //Metodo per l'attaco speciale
    public float calcolaAttacoSpeciale(float danno){
        if(this.attaccoSpeciale > 0){
            System.out.println("Vuoi usare l'attacco speciale? (si/no) [Al primo attacco non si può utilizzarlo]");
            String risposta = scan.nextLine(); risposta = risposta.toLowerCase();
            if(risposta.equals("si")){
                float dannoSpeciale;
                if(this.attaccoSpeciale > 0){
                    dannoSpeciale = danno * 2f;
                    System.out.println("Attacco Speciale attivato!!");
                    this.setAttaccoSpeciale(this.attaccoSpeciale - 1);
                    return dannoSpeciale;
                } else {
                    System.out.println("Hai terminato gli attacchi speciali");
                    return danno;
                }
            }
        }
        return danno;
    }
    //Un metodo che modifica la condizione
    public int modificaCondizione(int condizione){
        int cond = condizione;
        if(this.esperienza >= cond){
            cond += 50;
        }
        return cond;
    }
    //Metodo per rigenerare l'attacco speciale
    public void rigeneraAttaccoSpeciale(int condizione){
        if(this.esperienza >= condizione){
            this.setAttaccoSpeciale(this.attaccoSpeciale + 1);
        }
    }
    //Metodo per far scegliere al galdiatore nemico se usare l'attacco speciale
    public float calcolaAttacoSpecialeNemico(float danno){
        Random random = new Random();
        int num = random.nextInt(5);
        if(num == 1){
            float dannoSpeciale;
            if(this.attaccoSpeciale > 0){
                dannoSpeciale = danno * 2f;
                System.out.println("Attaco Speciale del nemico attivato!!");
                this.setAttaccoSpeciale(this.attaccoSpeciale - 1);
                return dannoSpeciale;
            } else {
                return danno;
            }
        }
        return danno;
    }
    //Implemntare altri metodi, continuare a migliorare i metodi già implementati
    public int incrementaLivello(int xp){
        int level = this.esperienza/20;
        this.setLivello(this.livello + level);
        return level;
    }
    //Metodo per controllare lo status in base alla vita
    public void checkStatus(Gladiatore g[]){
        for(int i=0; i<g.length; i++){
            if(g[i].getPuntiSalute() <= 0){
                g[i].setStatus("Non Disponibile");
            }
        }       
    }
    //Metodo per controllare se ci sono gladiatori disponibili
    public int checkDisponibilità(Gladiatore g[]){
        int check = 0;
        for(int i = 0; i < g.length; i++){
            if(g[i].getPuntiSalute() > 0){
                check++;
            }
        }
        return check;
    }
}
