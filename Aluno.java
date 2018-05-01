
package projectopoo1617;


import java.io.Serializable;
import java.util.ArrayList;


public class Aluno extends Pessoa implements Serializable {
    private int numeroaluno;
    private Curso curso;
    private int anomatricula;
    private String regime;
    
    
    public Aluno(){
        
    }
    
    public Aluno(String nome,String email,int numeroaluno,Curso curso,int anomatricula,String regime){
        super(nome,email);
        this.numeroaluno=numeroaluno;
        this.curso=curso;
        this.anomatricula=anomatricula;
        this.regime=regime;
    }

    public int getNumeroaluno() {
        return numeroaluno;
    }

    public void setNumeroaluno(int numeroaluno) {
        this.numeroaluno = numeroaluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getAnomatricula() {
        return anomatricula;
    }

    public void setAnomatricula(int anomatricula) {
        this.anomatricula = anomatricula;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }
    
    /**
     * Método utilizado para listar os exames em que um aluno se encontra inscrito.
     * @param exames 
     */
    public void listarInscrito(ArrayList<Exame> exames){
        for (Exame exame : exames) {//percorre o ArrayList<Exame> exames
            for (int j = 0; j < exame.getInscritos().size(); j++) {//percorre os alunos inscritos no exame em causa
                if (exame.getInscritos().get(j).getNumeroaluno()==this.numeroaluno) {//verifica se o aluno em causa se encontra nos alunos inscritos do exame
                    if (!exame.notas.isEmpty()) {//caso se encontre e já tiverem sido lançadas as notas imprime o exame e a nota obtida pelo aluno
                        System.out.println(exame.toString());
                        System.out.println(exame.notas.get(j));
                    } else {//caso se encontre mas as notas ainda não tiverem sido lançadas imprime apenas o exame
                        System.out.println(exame.toString()); 
                    }
                }
            }
        }
    }
    
    @Override
    public String toString(){
        return String.format("Nome:%s\nE-mail:%s\nNúmero de Aluno:%d\nEstatuto:%s\nCurso:%s\nAno de Matrícula:%d\n",this.nome,this.email,this.numeroaluno,this.regime,this.curso.getNome(),this.anomatricula);
    }
    
}
