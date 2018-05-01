
package projectopoo1617;

import java.util.ArrayList;

public class Recurso extends Exame {
    
    public Recurso(){
        
    }
    
    public Recurso(Disciplina disciplina,Data data,Data duracao,ArrayList<Sala> sala,Docente responsavel,ArrayList<Docente> vigilantes,ArrayList<NaoDocente> funcionarios,ArrayList<Aluno> inscritos,ArrayList<Classificacao> notas){
        super(disciplina,data,duracao,sala,responsavel,vigilantes,funcionarios,inscritos,notas);
        
    }
    
    @Override
    public boolean verificaEpoca(Aluno aluno){
         return true;
     }
    
    @Override
    public String getEpoca(){
        return String.format("Recurso");
    }
    
    @Override
    public String toString(){
        String salasImprimir = "";
        salasImprimir = this.salas.stream().map((sala) -> sala + "\n").reduce(salasImprimir, String::concat);
        return String.format("Disciplina:%s\nÉpoca:%s\nData:%d/%d/%d\nHora:%s:%s\nDuração:%s:%s\nSalas\n%sNúmero de vigilantes:%d\nNúmero de alunos inscritos:%d\n",this.disciplina.getNome(),this.getEpoca(),this.data.getDia(),this.data.getMes(),this.data.getAno(),this.data.getHoras(),this.data.getMinutos(),this.duracao.getHoras(),this.duracao.getMinutos(),salasImprimir,this.vigilantes.size(),this.inscritos.size());
    }
    
}
