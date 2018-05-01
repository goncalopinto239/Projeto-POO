
package projectopoo1617;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class Funcionario extends Pessoa implements Serializable {
    protected int mecanografico;
    protected String categoria;
    
    
    public Funcionario(){
        
    }
    
    public Funcionario(String nome,String email,int mecanografico,String categoria){
        super(nome,email);
        this.mecanografico=mecanografico;
        this.categoria=categoria;
    }

    public int getMecanografico() {
        return mecanografico;
    }

    public void setMecanografico(int mecanografico) {
        this.mecanografico = mecanografico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getTipo(){
        return String.format("");
    }
    
    @Override
    public String toString(){
        return String.format("Nome:%s\nE-mail:%s\nNúmero Mecanográfico:%d\nCategoria:%s\n",this.nome,this.email,this.mecanografico,this.categoria);
    }
    
    /**
     * Método utilizado para listar os exames em que um funcionário se encontra associado.
     * @param exames 
     */
    public void listarEnvolvidos(ArrayList<Exame> exames){
        System.out.println("Exames em que se encontra envolvido");
        exames.stream().map((exame) -> {
            for (int j = 0; j < exame.getFuncionarios().size(); j++) {//percorre os não docentes de um exame
                if (exame.getFuncionarios().get(j).getMecanografico()==this.mecanografico) {//verifica se o não docente em causa se encontra nesse exame 
                    System.out.println(exame);//caso se encontre esse exame é impresso
                }
            }
            return exame;
        }).forEach((exame) -> {
            for (int k = 0; k < exame.getVigilantes().size(); k++) {//percorre os docentes de um exame
                if (exame.getVigilantes().get(k).getMecanografico()==this.mecanografico) {//verifica se o docente em causa se encontra nesse exame
                    System.out.println(exame);//caso se encontre esse exame é impresso
                }
            }
        });
    }
}
