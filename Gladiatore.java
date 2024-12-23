/*Progetto di fine anno sui Gladiatori
[Realizzato da Camozzo e Petrini] 
*/
import java.util.Arrays;
import java.util.Random;

public class Gladiatore{
    private String nome;
    private String tipo;
    private int esperienza;
    private int puntiSalute;
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
    public int totale(){
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
    public int getPuntiSalute(){
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
    public void setPuntiSalute(int puntiSalute){
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
    
    //Metodo attacco, per calcolare il danno inflitto dal gladiatore
    
    public void combattimento(Gladiatore nemico){
        Random random = new Random();
        
        int dato = random.nextInt(1)+20;
        int dato2 = random.nextInt(1)+20; 
        if(dato>dato2){
            
        }
    }
    public float danno(Gladiatore nemico){
        Random random = new Random();
        float rand = random.nextFloat(0.85)+1; 
        float potenza = 20; 
    }
    
    
}
