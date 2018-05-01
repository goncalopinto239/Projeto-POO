
package projectopoo1617;

import java.io.Serializable;
import java.util.Calendar;

public class Data implements Serializable {
    private int dia;
    private int mes;
    private int ano;
    private String horas;
    private String minutos;
    
    public Data(){
        
    }
    
    public Data(String horas,String minutos){
        this.dia=0;
        this.mes=0;
        this.ano=0;
        this.horas=horas;
        this.minutos=minutos;
    }
    
    public Data(int dia,int mes,int ano,String horas,String minutos){
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
        this.horas=horas;
        this.minutos=minutos;
    }
    
    public Data(int dia,int mes,int ano){
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }
    
    /**
     * Método utilizado para confirmar que uma data é valida, se se encontra de acordo com o calendário.
     * @return 
     */
    //verifica se a data introduzida é uma data válida
    public boolean confirmaData(){
        Calendar calendario = Calendar.getInstance();
        int anosis = calendario.get(Calendar.YEAR);
        int messis = calendario.get(Calendar.MONTH) + 1;
        int diasis = calendario.get(Calendar.DAY_OF_MONTH);
        int horassis = calendario.get(Calendar.HOUR_OF_DAY);
        int minutossis = calendario.get(Calendar.MINUTE);
        if(this.mes<=messis && this.ano>anosis || this.dia>diasis && this.mes>=messis && this.ano>=anosis || this.dia<diasis && this.mes>=messis && this.ano>=anosis || this.mes>messis && this.ano>=anosis || this.dia<=diasis && this.mes<=messis && this.ano>anosis || this.dia==diasis && this.mes==messis && this.ano==anosis && Integer.parseInt(this.horas)>horassis || this.dia==diasis && this.mes==messis && this.ano==anosis && Integer.parseInt(this.horas)==horassis && Integer.parseInt(this.minutos)>minutossis){
            if(this.mes==1 || this.mes==3 || this.mes==5 || this.mes==7 || this.mes==8 || this.mes==10 || this.mes==12){
                if(this.dia>=1 && this.dia<=31){
                    return true;
                }
                else{
                    System.out.println("O mês inserido tem apenas 31 dias, por favor introduza um dia de 01 a 31");
                    return false;
                }
            }
            else if(this.mes==2 ){
                if((this.ano % 400 == 0) || ((this.ano % 4 == 0) && (this.ano % 100 != 0))){
                    if(this.dia>=1 && this.dia<=29){
                        return true;
                    }
                    else{
                        System.out.println("No ano inserido este mês tem apenas 29 dias, por favor introduza um dia de 01 a 29");
                        return false;
                    }
                }
                else{
                    if(this.dia>=1 && this.dia<=28){
                       return true; 
                    }
                    else{
                        System.out.println("No ano inserido este mês tem apenas 28 dias, por favor introduza um dia de 01 a 28");
                        return false; 
                    }
                }
            }
            else if(this.mes==4 || this.mes==6 || this.mes==9 || this.mes==11){
                if(this.dia>=1 && this.dia<=30){
                    return true;
                }
                else{
                   System.out.println("O mês inserido tem apenas 31 dias, por favor introduza um dia de 01 a 30");
                   return false;
                }
            }
            else{
                System.out.println("Mês inexistente, por favor introduza um mês de 01 a 12");
                return false;
            }
        }
        else{
            System.out.println("Data passada,por favor introduza uma data futura");
            return false;   
        }  
    }
    
    /**
     * Método utilizado para verificar se a data de um exame mais a sua duração coincide com o decorrer de outro exame. Utilizado para verificar as sobreposições de docentes e salas.
     * @param exame
     * @param duracao
     * @return 
     */
    //verifica se a data de um exame mais a sua duração coincide com o decorrer de outro exame
    public boolean confirmaDuracao(Exame exame,Data duracao){
        return !(Integer.parseInt(exame.getData().getHoras())<=Integer.parseInt(this.horas) && Integer.parseInt(exame.getData().getHoras())+Integer.parseInt(exame.getDuracao().getHoras())>Integer.parseInt(this.getHoras()) || Integer.parseInt(this.horas)<=Integer.parseInt(exame.getData().getHoras()) && Integer.parseInt(this.horas)+Integer.parseInt(duracao.getHoras())>Integer.parseInt(exame.getData().getHoras()) || Integer.parseInt(this.horas)<Integer.parseInt(exame.getData().getHoras()) && Integer.parseInt(this.horas)+Integer.parseInt(duracao.getHoras())==Integer.parseInt(exame.getData().getHoras()) && Integer.parseInt(this.minutos)+Integer.parseInt(duracao.getMinutos())>Integer.parseInt(exame.getData().getMinutos()) || Integer.parseInt(exame.getData().getHoras())<Integer.parseInt(this.horas) && Integer.parseInt(exame.getData().getHoras())+Integer.parseInt(exame.getDuracao().getHoras())==Integer.parseInt(this.horas) && Integer.parseInt(exame.getData().getMinutos())+Integer.parseInt(exame.getDuracao().getMinutos())>Integer.parseInt(this.minutos));
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }
    
    @Override
    public String toString(){
       return String.format("Data:%d/%d/%d - Hora:%s:%s",this.dia,this.mes,this.ano,this.horas,this.minutos); 
    }
}
