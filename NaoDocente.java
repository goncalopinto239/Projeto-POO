
package projectopoo1617;

public class NaoDocente extends Funcionario {
    private String cargo;
    
    
    public NaoDocente(){
        
    }
    
    public NaoDocente(String nome,String email,int mecanografico,String categoria,String cargo){
        super(nome,email,mecanografico,categoria);
        this.cargo=cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public String getTipo(){
        return String.format("Não Docente");
    }
    
    @Override
    public String toString(){
        return String.format("Nome:%s\nE-mail:%s\nNúmero Mecanográfico:%d\nCategoria:%s\nCargo:%s\n\n",this.nome,this.email,this.mecanografico,this.categoria,this.cargo);
    }
}
