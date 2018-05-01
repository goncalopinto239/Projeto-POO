
package projectopoo1617;

import java.io.Serializable;
import java.util.ArrayList;


public class Disciplina implements Serializable {
    private String nome;
    private Docente responsavel;
    private ArrayList<Docente> docentes;
    private ArrayList<Aluno> inscritos;

    public Disciplina(){
        
    }
    
    public Disciplina(String nome,Docente responsavel,ArrayList<Docente> docentes,ArrayList<Aluno> inscritos){
        this.nome=nome;
        this.responsavel=responsavel;
        this.docentes=docentes;
        this.inscritos=inscritos;
    }
    
    public Disciplina(String nome){
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Docente getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Docente responsavel) {
        this.responsavel = responsavel;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    public ArrayList<Aluno> getInscritos() {
        return inscritos;
    }

    public void setInscritos(ArrayList<Aluno> inscritos) {
        this.inscritos = inscritos;
    }
    
    @Override
    public String toString(){
        String docentesImprimir = "";
        String inscritosImprimir = "";
        docentesImprimir = this.docentes.stream().map((docente) -> docente + "\n").reduce(docentesImprimir, String::concat);
        inscritosImprimir = this.inscritos.stream().map((inscrito) -> inscrito + "\n").reduce(inscritosImprimir, String::concat);
        return String.format("Nome:%s\n\nDocente responsável\n%s\nDocentes\n%s\nAlunos inscritos\n%s\n",this.nome,this.responsavel,docentesImprimir,inscritosImprimir);
    }
    
    
}
