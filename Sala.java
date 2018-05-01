
package projectopoo1617;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable {
    private String nome;
    private int lotacao;
    
    public Sala(){
        
    }
    
    public Sala(String nome,int lotacao){
        this.nome=nome;
        this.lotacao=lotacao;
    }
   
    
    /**
     * Método utilizado para para confirmar a disponibilidade de uma sala para uma dada data. Utilizado para verificar a sobreposição de salas.
     * @param exames
     * @param data
     * @param duracao
     * @return 
     */
    //verifica se uma dada sala tem sobreposições para uma determinada data
    public boolean confirmaSala(ArrayList<Exame> exames,Data data,Data duracao){
        boolean conf=true;
        for (Exame exame : exames) {
            for (Sala sala : exame.salas) {
                if (this.nome.equals(sala.nome)) {
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
        return String.format("Nome:%s\nLotação:%d\n",this.nome,this.lotacao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }
    
    
}
