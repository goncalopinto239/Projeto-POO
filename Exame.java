
package projectopoo1617;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import static projectopoo1617.ProjectoPoo1617.confirmaAluno;

public abstract class Exame implements Serializable {
    protected Disciplina disciplina;
    protected Data data;
    protected Data duracao;
    protected ArrayList<Sala> salas;
    protected Docente responsavel;
    protected ArrayList<Docente> vigilantes;
    protected ArrayList<NaoDocente> funcionarios;
    protected ArrayList<Aluno> inscritos;
    protected ArrayList<Classificacao> notas;  
    protected boolean notasLancadas = true;
    
    
    public Exame(){
        
    }
    
    public Exame(Disciplina disciplina,Data data,Data duracao,ArrayList<Sala> salas,Docente responsavel,ArrayList<Docente> vigilantes,ArrayList<NaoDocente> funcionarios,ArrayList<Aluno> inscritos,ArrayList<Classificacao> notas){
        this.disciplina=disciplina;
        this.data=data;
        this.duracao=duracao;
        this.salas=salas;
        this.responsavel=responsavel;
        this.vigilantes=vigilantes;
        this.funcionarios=funcionarios;
        this.inscritos=inscritos;
        this.notas=notas;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getDuracao() {
        return duracao;
    }

    public void setDuracao(Data duracao) {
        this.duracao = duracao;
    }

    public ArrayList<Sala> getSala() {
        return salas;
    }

    public void setSala(ArrayList<Sala> sala) {
        this.salas = sala;
    }

    public Docente getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Docente responsavel) {
        this.responsavel = responsavel;
    }

    public ArrayList<Docente> getVigilantes() {
        return vigilantes;
    }

    public void setVigilantes(ArrayList<Docente> vigilantes) {
        this.vigilantes = vigilantes;
    }

    public ArrayList<NaoDocente> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<NaoDocente> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Aluno> getInscritos() {
        return inscritos;
    }

    public void setInscritos(ArrayList<Aluno> inscritos) {
        this.inscritos = inscritos;
    }
    
    public ArrayList<Classificacao> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Classificacao> notas) {
        this.notas = notas;
    }

    public boolean isNotasLancadas() {
        return notasLancadas;
    }

    public void setNotasLancadas(boolean notasLancadas) {
        this.notasLancadas = notasLancadas;
    }
    
    //método para verificar se o aluno compareceu ou não no exame em causa
    private boolean presenca(){
        Scanner input = new Scanner(System.in);
        String verificacao="";
        boolean confirmacao=false;
        boolean aux=true;
        do{
          System.out.print("O aluno compareceu?:");  
          verificacao = input.nextLine();
          if(verificacao.equals("Sim") || verificacao.equals("Não")){//enquanto o input introduzido for diferente de "Sim" e "Não" volta a ser pedido o input ao utilizador
              aux=false;
          }
        }while(aux);
        switch (verificacao) {
            case "Sim":
                confirmacao=true;
                break;
            case "Não":
                confirmacao=false;
                break;
        }
        return confirmacao;  
    }
    
    private double confirmaDouble(Double nota){
        boolean aux = true;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Nota");
            aux=input.hasNextDouble(); //verifica se o input dado pelo utilizador é um double
            if(aux){
                nota=input.nextDouble(); //se for guarda o valor do input na variável nota para depois ser retornado
                input.nextLine();
                aux=false;
            }
            else{
                System.out.println("Nota Inválida"); //se não for volta a pedir de novo o input do utilizador até ser um inteiro
                input.nextLine();
                aux=true;
            }      
        }while(aux);
        return nota;
    }
    
    /**
     * Método utilizado para lançar as notas de um dado exame.
     */
    public void lancaNotas(){
        Calendar calendario = Calendar.getInstance();
        int anosis = calendario.get(Calendar.YEAR);
        int messis = calendario.get(Calendar.MONTH) + 1;
        int diasis = calendario.get(Calendar.DAY_OF_MONTH);
        int horassis = calendario.get(Calendar.HOUR_OF_DAY);
        int minutossis = calendario.get(Calendar.MINUTE);
        //verifica se a data do exame já ocorreu. Se ainda não tiver ocorrido então as notas não são lançadas
        if(anosis>this.data.getAno() || diasis<this.data.getDia() && messis<=this.data.getMes() && anosis>this.data.getAno() || diasis>this.data.getDia() && messis>=this.data.getMes() && anosis>=this.data.getAno() || messis>this.data.getMes() && anosis>=this.data.getAno() || diasis>=this.data.getDia() && messis>=this.data.getMes() && anosis>this.data.getAno() || this.data.getDia()==diasis && this.data.getMes()==messis && this.data.getAno()==anosis && horassis>Integer.parseInt(this.data.getHoras())+Integer.parseInt(this.duracao.getHoras()) || this.data.getDia()==diasis && this.data.getMes()==messis && this.data.getAno()==anosis && Integer.parseInt(this.data.getHoras())+Integer.parseInt(this.duracao.getHoras())==horassis && minutossis>Integer.parseInt(this.data.getMinutos())+Integer.parseInt(this.duracao.getMinutos())){    
            //verifica se as notas deste exame já forma lançadas.Caso já tenham sido lançadas então as notas não sao lançadas
            if(notasLancadas){
                this.inscritos.stream().map((inscrito) -> {
                    System.out.println(inscrito.getNome());
                    System.out.println(inscrito.getNumeroaluno());
                    return inscrito;
                }).forEach((inscrito) -> {
                    if (presenca()) {//utliza o método presenca para verificar se o aluno compareceu. Se tiver comparecido a sua nota é lançada
                        double nota = 0;
                        nota = confirmaDouble(nota);
                        Classificacao classificacao = new Classificacao(inscrito, nota);
                        notas.add(classificacao);
                    } else {//caso não tenha comparecido não tem nota mas sim um aviso a informar que faltou
                        Classificacao classificaco2 = new Classificacao(inscrito);
                        notas.add(classificaco2);
                    }
                });
                this.notasLancadas = false;
            }
            else{
                System.out.println("As notas deste exame já se encontram lançadas");
            }
        }
        else{
            System.out.println("As notas deste exame ainda não podem ser lançadas pois o exame ainda não ocorreu ou encontra-se a decorrer");
        }
    }
    
    /**
     * Método utilizado para alterar uma ou várias notas de um dado exame.
     * @param aluno
     * @param alunos
     * @param exames
     * @param fo 
     */
    public void alteraNotas(Aluno aluno,ArrayList<Aluno> alunos,ArrayList<Exame> exames,ficheirosObjectos fo){
       Scanner input = new Scanner(System.in);
        boolean aux = true;
        boolean aux2 = true;
        double novaNota = 0;
 
        if(!notasLancadas){
            do{
                System.out.println("Aluno");
                aluno = confirmaAluno(alunos,aluno,"Alterar Notas",this);
                for(int j=0;j<this.getNotas().size();j++){
                    //verifica se o aluno indicado realizou o exame
                    if(this.getNotas().get(j).getAluno().getNumeroaluno()==aluno.getNumeroaluno() && !this.getNotas().get(j).getAusente().equals("Faltou")){
                        //caso tenha realizado o exame é pedido ao utilizador a sua nova nota e esta substitui a nota do aluno em causa anteriormente lançada
                        confirmaDouble(novaNota);
                        this.getNotas().get(j).setNota(novaNota);
                    }
                    else{
                        System.out.println("O aluno inserido não realizou ou faltou ao exame");
                    }
                }
                aluno=null;
                do{//permite ao utilizador aterar a nota de um aluno em determinado exame mais que uma vez sem ser preciso retomar ao menu anterior
                    System.out.print("Deseja alterar a nota de mais algum aluno?:");
                    String opcao = input.nextLine();
                    switch (opcao) {
                        case "Sim":
                            aux2=false;
                            break;
                        case "Não":
                            aux=false;
                            aux2=false;
                            break;
                        default:
                            System.out.println("Escolha inválida");
                            break;
                    }
                }while(aux2);

            }while(aux);
            //depois de alterada a/as notas de um exame, o ficheiro "exames.bin" é então actualizado
            try{
                fo.abreEscrita("exames.bin");
                fo.escreveObjecto(exames);
                fo.fechaEscrita();
            }
            catch (Exception c) {
                System.out.println("Ocorreu um erro " + c);
            }
        }
        else{
            System.out.println("As notas deste exame ainda não foram lançadas");
        }
    }
    
    public String getEpoca(){
        return String.format("");
    }
    
    public boolean verificaEpoca(Aluno aluno){
         return true;
     }
    
    /**
     * Método utilizado para associar um funcionário pretendido a um dado exame.
     * @param funcionario
     * @param exames
     * @param data
     * @param duracao 
     */
    public void associaFuncionario(Funcionario funcionario,ArrayList<Exame> exames,Data data,Data duracao){
        Docente docente;
        Calendar calendario = Calendar.getInstance();
        int anosis = calendario.get(Calendar.YEAR);
        int messis = calendario.get(Calendar.MONTH) + 1;
        int diasis = calendario.get(Calendar.DAY_OF_MONTH);
        int horassis = calendario.get(Calendar.HOUR_OF_DAY);
        int minutossis = calendario.get(Calendar.MINUTE);
        //if(anosis<=this.getData().getAno() && messis<=this.getData().getMes() && diasis<=this.getData().getDia() && horassis<=Integer.parseInt(this.getData().getHoras()) && minutossis<Integer.parseInt(this.getData().getMinutos())){
        if(anosis<this.data.getAno() || diasis>this.data.getDia() && messis>=this.data.getMes() && anosis<this.data.getAno() || diasis<this.data.getDia() && messis<=this.data.getMes() && anosis<=this.data.getAno() || messis<this.data.getMes() && anosis<=this.data.getAno() || diasis<=this.data.getDia() && messis<=this.data.getMes() && anosis<this.data.getAno() || this.data.getDia()==diasis && this.data.getMes()==messis && this.data.getAno()==anosis && horassis<Integer.parseInt(this.data.getHoras()) || this.data.getDia()==diasis && this.data.getMes()==messis && this.data.getAno()==anosis && Integer.parseInt(this.data.getHoras())==horassis && minutossis<Integer.parseInt(this.data.getMinutos())){  
            if(funcionario.getTipo().equals("Docente")){//verifica se o funcionário em causa é um docente
                docente = (Docente) funcionario;
                if(docente.confirmaDocente(exames, data, duracao)){//verifica se o docente desejado se encontra disponível para este exame
                    this.vigilantes.add(docente);//caso esteja disponível adiciona o docente aos vigilantes do exame em causa
                }
                else{
                    System.out.println("O docente em causa já se encontra associado a um exame nesta data a esta hora");
                }
            }
            else{
                this.funcionarios.add((NaoDocente) funcionario);//caso seja um não docente basta adicionar o não docente ao exame desejado visto que os não docentes podem ter exames sobrepostos
            }
        }
        else{
            System.out.println("O exame em que pretende associar o docente em causa já ocorreu ou encontra-se a decorrer");
        }
    }
       
    
    /**
     * Método utilizado para associar um aluno pretendido a um dado exame.
     * @param aluno 
     */
    public void associaAluno(Aluno aluno){
        boolean aux = true;
        boolean aux2 = true;
        Calendar calendario = Calendar.getInstance();
        int anosis = calendario.get(Calendar.YEAR);
        int messis = calendario.get(Calendar.MONTH) + 1;
        int diasis = calendario.get(Calendar.DAY_OF_MONTH);
        int horassis = calendario.get(Calendar.HOUR_OF_DAY);
        int minutossis = calendario.get(Calendar.MINUTE);
        if(anosis<this.data.getAno() || diasis>this.data.getDia() && messis>=this.data.getMes() && anosis<this.data.getAno() || diasis<this.data.getDia() && messis<=this.data.getMes() && anosis<=this.data.getAno() || messis<this.data.getMes() && anosis<=this.data.getAno() || diasis<=this.data.getDia() && messis<=this.data.getMes() && anosis<this.data.getAno() || this.data.getDia()==diasis && this.data.getMes()==messis && this.data.getAno()==anosis && horassis<Integer.parseInt(this.data.getHoras()) || this.data.getDia()==diasis && this.data.getMes()==messis && this.data.getAno()==anosis && Integer.parseInt(this.data.getHoras())==horassis && minutossis<Integer.parseInt(this.data.getMinutos())){
            for(int i=0;i<this.inscritos.size();i++){
                if(this.inscritos.get(i).getNumeroaluno()==aluno.getNumeroaluno()){
                    aux2 = false;
                }
            }
            if(aux2){
                for(int j=0;j<this.disciplina.getInscritos().size();j++){
                    if(this.disciplina.getInscritos().get(j).getNumeroaluno()==aluno.getNumeroaluno()){//verifica se o aluno desejado se encontra inscrito na disciplina
                        aux = false;
                        if(this.verificaEpoca(aluno)){//verifica se o aluno tem estatuto para a época em causa
                            this.inscritos.add(aluno);
                        }
                        else{
                            System.out.println("O estatuto deste aluno não permite a inscrição em exames de Época Especial");
                        }
                    }
                }
                if(aux){
                    System.out.println("O aluno em causa não se encontra inscrito nesta disciplina");
                }
            }
            else{
                System.out.println("O aluno em causa já se encontra inscrito neste exame");
            }
        }
        else{
            System.out.println("O exame em que pretende associar o aluno em causa já ocorreu ou encontra-se a decorrer");
        }
    }
    
    /**
     * Método utilizado para listar os alunos que se encontram inscritos num dado exame.
     */
    public void listarAlunos(){
        System.out.println("Alunos Inscritos:");
        for(int i=0;i<this.inscritos.size();i++){
            if(!this.notas.isEmpty()){
                System.out.println(this.notas.get(i).getAluno());
                System.out.println(this.notas.get(i).getNota());
            }
            System.out.println(this.inscritos.get(i));
        }
    }
    
    /**
     * Método utilizado para listar os funcionários que se encontram associados a um dado exame.
     */
    public void listarFuncionarios(){
        System.out.println("Funcionários:");
        this.funcionarios.stream().forEach((funcionario) -> {
            System.out.println(funcionario);
        });
    }
    
    /**
     * Método utilizado para listar as notas que de um dado exame.
     */
    public void listarNotas(){
        this.notas.stream().forEach((nota) -> {
            if (nota.getAusente().equals("Faltou")) {
                System.out.println(nota.getAluno());
                System.out.println(nota.getAusente());
            } else {
                System.out.println(nota.getAluno());
                System.out.println(nota.getNota());
            }
        });
    }
    
    
    @Override
    public String toString(){
        String salasImprimir = "";
        salasImprimir = this.salas.stream().map((sala) -> sala + "\n").reduce(salasImprimir, String::concat);
        return String.format("Disciplina:%s\nÉpoca:%s\nData:%d/%d/%d\nHora:%s:%s\nDuração:%s:%s\nSalas\n%sNúmero de vigilantes:%d\nNúmero de alunos inscritos:%d\n",this.disciplina.getNome(),this.getEpoca(),this.data.getDia(),this.data.getMes(),this.data.getAno(),this.data.getHoras(),this.data.getMinutos(),this.duracao.getHoras(),this.duracao.getMinutos(),salasImprimir,this.vigilantes.size(),this.inscritos.size());
    }
}
