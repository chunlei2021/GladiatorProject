/*Progetto di fine anno sui Gladiatori
[Realizzato da Camozzo e Petrini] 
*/
import java.util.Arrays;
public class Gladiatore{
    private String nome;
    private String tipo;
    private int esperienza;
    private int puntiSalute;
    private int attacco;
    private int difesa;
    private int velocità;
    private int attaccoSpeciale;
    private String armamenti[] = new String[DIM];
    private static DIM = 10;
    private String provenienza;
    private int livello;
    
    public Gladiatore(String nome, String tipo, int epserienza, int puntiSalute, int attacco, int difesa, int velocità, int attaccoSpeciale, String armamenti[], String provenienza, int livello){
        this.nome=nome;
        this.tipo=tipo;
        this.esperienza=esperienza;
        this.puntiSalute=puntiSalute;
        this.attacco=attacco;
        this.difesa=difesa;
        this.velocità=velocità;
        this.attaccoSpeciale=attaccoSpeciale;
        this.armamenti=armamenti;
        this.provenienza=provenienza;
        this.livello=livello;
    }
    public String getNome(){
        return nome;
    }
    public String getTipo(){
        return tipo;
    }
    public int getEsperienza(){
        return epserienza;
    }
    public int getPuntiSalute(){
        return puntiSalute;
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
    
}