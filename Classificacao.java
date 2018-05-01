
package projectopoo1617;

import java.io.Serializable;


public class Classificacao implements Serializable {
    private Aluno aluno;
    private double nota;
    private String ausente;
    
    public Classificacao(){
        
    }
    
    /**
     * Construtor utilizado para criar classificações de alunos que compareceram no exame em causa.
     * @param aluno
     * @param nota 
     */
    public Classificacao(Aluno aluno,double nota){
        this.aluno=aluno;
        this.nota=nota;
        this.ausente="";
    }
    
    /**
     * Construtor utilizado para criar classificações de alunos que não compareceram no exame em causa.
     * @param aluno 
     */
    public Classificacao(Aluno aluno){
        this.aluno=aluno;
        this.ausente="Faltou";
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getAusente() {
        return ausente;
    }

    public void setAusente(String ausente) {
        this.ausente = ausente;
    }
    
    @Override
    public String toString(){
        if(this.ausente.equals("")){
            return String.format("Aluno\n%s\nNota:%.2f\n",this.aluno,this.nota);
        }
        else{
            return String.format("Aluno\n%s\n%s\n",this.aluno,this.ausente);
        }
    }
    
}
