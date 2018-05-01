
package projectopoo1617;

import java.util.ArrayList;


public class Docente extends Funcionario {
    private String areainvestigacao;
    
    
    public Docente(){
        
    }
    
    public Docente(String nome,String email,int mecanografico,String categoria,String areainvestigacao){
        super(nome,email,mecanografico,categoria);
        this.areainvestigacao=areainvestigacao;
    }

    @Override
    public int getMecanografico() {
        return mecanografico;
    }

    @Override
    public void setMecanografico(int mecanografico) {
        this.mecanografico = mecanografico;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAreainvestigacao() {
        return areainvestigacao;
    }

    public void setAreainvestigacao(String areainvestigacao) {
        this.areainvestigacao = areainvestigacao;
    }
    
    @Override
    public String getTipo(){
        return String.format("Docente");
    }
    
    /**
     * Método utilizado para confirmar a disponibilidade de um docente para uma dada data. Utilizado para verificar a sobreposição de docentes.
     * @param exames
     * @param data
     * @param duracao
     * @return 
     */
    //verifica se um dado docente tem sobreposições para uma determinada data
    public boolean confirmaDocente(ArrayList<Exame> exames,Data data,Data duracao){
        boolean conf=true;
        for (Exame exame : exames) {
            for (int i = 0; i < exame.getVigilantes().size(); i++) {
                if (this.getMecanografico() == exame.getVigilantes().get(i).getMecanografico()) {
                    if (data.getDia() == exame.getData().getDia() && data.getMes() == exame.getData().getMes() && data.getAno() == exame.getData().getAno()) {
                        if (data.getHoras().equals(exame.getData().getHoras()) && data.getMinutos().equals(exame.getData().getMinutos()) || !data.confirmaDuracao(exame, duracao)) {
                            conf=false;
                            return conf;
                        } else {
                            conf=true;
                        }
                    } else {
                        conf=true;
                    }
                } else {
                    conf=true;
                }
            }
        }
        return conf;
    }
    
    @Override
    public String toString(){
        return String.format("Nome:%s\nE-mail:%s\nNúmero Mecanográfico:%d\nCategoria:%s\nÁrea de investigação:%s\n",this.nome,this.email,this.mecanografico,this.categoria,this.areainvestigacao);
    }
    
}
