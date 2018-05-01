
package projectopoo1617;

import java.util.ArrayList;
import java.util.Calendar;

public class Especial extends Exame {
    
    public Especial(){
        
    }
    
    public Especial(Disciplina disciplina,Data data,Data duracao,ArrayList<Sala> sala,Docente responsavel,ArrayList<Docente> vigilantes,ArrayList<NaoDocente> funcionarios,ArrayList<Aluno> inscritos,ArrayList<Classificacao> notas){
        super(disciplina,data,duracao,sala,responsavel,vigilantes,funcionarios,inscritos,notas);
        
    }
    
    /**
     * Método utilizado para confirmar se um dado aluno possui estatuto para realizar exames de época especial. Utilizado para inscrever alunos em época especial.
     * @param aluno
     * @return 
     */
    //verifica se um dado aluno tem estatuto para realizar exames de época especial
    @Override
    public boolean verificaEpoca(Aluno aluno){
        Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        return aluno.getRegime().equals("Trabalhador-estudante") || aluno.getRegime().equals("Atleta") || aluno.getRegime().equals("Dirigente associativo") || aluno.getAnomatricula()+aluno.getCurso().getDuracao()==ano;
    }
    
    @Override
    public String getEpoca(){
        return String.format("Especial");
    }
    
    @Override
    public String toString(){
        String salasImprimir = "";
        salasImprimir = this.salas.stream().map((sala) -> sala + "\n").reduce(salasImprimir, String::concat);
        return String.format("Disciplina:%s\nÉpoca:%s\nData:%d/%d/%d\nHora:%s:%s\nDuração:%s:%s\nSalas\n%sNúmero de vigilantes:%d\nNúmero de alunos inscritos:%d\n",this.disciplina.getNome(),this.getEpoca(),this.data.getDia(),this.data.getMes(),this.data.getAno(),this.data.getHoras(),this.data.getMinutos(),this.duracao.getHoras(),this.duracao.getMinutos(),salasImprimir,this.vigilantes.size(),this.inscritos.size());
    }
    
}
