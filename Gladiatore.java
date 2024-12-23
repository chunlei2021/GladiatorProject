/*Progetto di fine anno sui Gladiatori
[Realizzato da Camozzo e Petrini] 
*/
import java.util.Arrays;
import java.util.Random;

public class Gladiatore{
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
    public Gladiatore(String nome, String tipo, String armamenti[], String provenienza){
        this.nome=nome;
        this.tipo=tipo;
        this.esperienza=0;
        this.puntiSalute=random();
        this.attacco=random();
        this.difesa=random();
        this.velocità=random();
        this.attaccoSpeciale=random();
        this.armamenti=armamenti;
        this.provenienza=provenienza;
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
        return "Nome: "+nome+"\nTipo: "+tipo+"\nEsperienza: "+esperienza+" XP\nPunti Salute: "+puntiSalute+"HP \nAttacco: "+attacco+"\nDifesa: "+difesa+"\nVelocità: "+velocità+"\nAttacco Speciale: "+attaccoSpeciale+"\nArmamenti: "+Arrays.toString(armamenti)+"\nProvenienza: "+provenienza+"\nLivello: "+livello+"\nMedia: "+media()+"\nTotale: "+totale();
        
    }
    //Metodi getter
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
    
    //Metodo combattimento
    public void combattimento(Gladiatore nemico){
        Random random = new Random();
        int[] dato = new int[2];
        dato[0] = random.nextInt(1) + 20;
        dato[1] = random.nextInt(1) + 20;
        if(dato[0]>dato[1]){
            float danno = this.danno(nemico);
            float nuovaSalute = nemico.getPuntiSalute() - danno;
            nemico.setPuntiSalute(nuovaSalute);
            System.out.println("Il gladiatore "+this.getNome()+" ha inflitto un danno [" + danno + "] al gladiatore "+nemico.getNome());
            System.out.println("La salute del gladiatore nemico "+nemico.getNome()+" è: "+nemico.getPuntiSalute());
        } else {
            float danno = nemico.danno(this);
            float nuovaSalute = nemico.getPuntiSalute() - danno;
            this.setPuntiSalute(nuovaSalute);
            System.out.println("Il gladiatore nemico "+nemico.getNome()+" ha inflitto un danno [" + danno + "] al gladiatore "+this.getNome());
            System.out.println("La salute del gladiatore "+this.getNome()+" è: "+this.getPuntiSalute());
        }
    }
    //Metodo danno, per calcolare il danno inflitto dal gladiatore
    public float danno(Gladiatore nemico){
        Random random = new Random();
        float rand = 0.85f + random.nextFloat() * (1f - 0.85f);
        float potenza = 20; 
        float danno = ((((2*(float)this.livello)/5) + (2*potenza*((float)this.attacco/nemico.getDifesa())))/50) * rand; 
        System.out.println("[Danno inflitto: "+danno + "]");
        return danno;
    }
    
}