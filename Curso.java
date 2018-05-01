
package projectopoo1617;

import java.io.Serializable;
import java.util.ArrayList;


public class Curso implements Serializable {
    private String nome;
    private int duracao;
    private String grau;
    private ArrayList<Disciplina> disciplinas;
    
    public Curso(){
        
    }
    
    public Curso(String nome,int duracao,String grau,ArrayList<Disciplina> disciplinas){
        this.nome=nome;
        this.duracao=duracao;
        this.grau=grau;
        this.disciplinas=disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    @Override
    public String toString(){
        String disciplinasImprimir = "";
        disciplinasImprimir = this.disciplinas.stream().map((disciplina) -> disciplina + "\n").reduce(disciplinasImprimir, String::concat);
        return String.format("Nome:%s\nDuração:%d\nGrau:%s\nDisciplinas\n%s\n\n",this.nome,this.duracao,this.grau,disciplinasImprimir);
    }
}
