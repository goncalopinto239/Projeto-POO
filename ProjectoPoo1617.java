
package projectopoo1617;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

// javadoc fazer /**
public class ProjectoPoo1617 implements Serializable {
    
    /**
     * Método utilizado para confirmar a recepção do input de um inteiro.Utilizado nos diferentes menus do projecto.
     * @param escolha
     * @param menu
     * @return 
     */
    
    public static int confirmaEscolha(int escolha, String menu){//proteção para a escolha ao longo dos menus
        boolean aux = true;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print(menu);
            aux=input.hasNextInt(); //verifica se o input dado pelo utilizador é um inteiro
            if(aux){
                escolha=input.nextInt(); //se for guarda o valor do input na variável escolha para depois ser retornado
                input.nextLine();
                System.out.println("\n");
                aux=false;
            }
            else{
                System.out.println("Escolha Inválida"); //se não for volta a pedir de novo o input do utilizador até ser um inteiro
                input.nextLine();
                aux=true;
            }      
        }while(aux);
        return escolha;
    }
    
    /**
     * Método utilizado para confirmar a receção de uma String na forma desejada.Utilizado para confirmar nome de funcionários, nome de alunos, nome de disciplinas e nome de cursos.
     * @param nome
     * @param texto
     * @return 
     */
    public static String confirmaString(String nome,String texto){
        boolean aux = true;
        Scanner input = new Scanner(System.in);
        boolean confirma = true;
        boolean space = false;
        do{
            System.out.print(texto);
            String nomes = input.nextLine();
            for(int i=0;i<nomes.length();i++){ //recebe o input do utilizador
                char caracter = nomes.charAt(i);
                if(i==0){
                    if(caracter==32){//se o primeiro caracter for um espaço não é aceite
                        confirma=false;
                    }
                    if(!Character.isUpperCase(caracter)){//verifica se o primeiro caracter se encontra em letra maiúscula, se não se encontrar não é aceite
                        confirma=false;
                    }
                }
                else{
                    if(caracter!=32 && !space && !Character.isLowerCase(caracter)){//se nao tiver ocorrido um espaço no caracter anterior nem o caracter actual for um espaço então o caracter actual tem de estar em letra minúscula,caso contrário não é aceite
                        confirma=false;
                    }
                    if(space){
                        if(!Character.isUpperCase(caracter)){ //se o caracter anterior tiver sido um espaço e o caracter actual não estiver com letra maiúscula não é aceite
                            confirma=false;
                        }
                        space=false;
                    }
                    if(caracter==32){ //se o caracter for um espaço mete a variável boolean space a true
                        space=true;
                    }  
                }
                if(caracter <48 && caracter!=32 || (caracter > 57 && caracter < 65) || (caracter > 90 && caracter < 97) || caracter > 122 && caracter!=225 && caracter !=227 && caracter !=231 && caracter !=243 && caracter !=205 && caracter !=194 && caracter !=193 && caracter !=233 && caracter !=192 && caracter !=237 && caracter !=245 && caracter !=234){
                    confirma=false; //verifica os caracteres especiais, se ocorrerem não é aceite
                }
                if(Character.isDigit(caracter)){ //verifica se o caracter actual é um número, caso seja não é aceite
                    confirma=false;
                }
            }
            if(confirma){ //se não tiver verificado nenhuma das excepções em cima referidas o input introduzido é então aceite e copiado para nome para ser no fim retornado
                nome=nomes;
                aux=false;
            }
            else{ //volta a pedir o input ao utilizador e a verificar tudo de novo até que o input dado seja aceite
                System.out.println("Nome inválido");
                confirma=true;
                aux=true;
            }      
        }while(aux);
        return nome;
    }
    
    /**
     * Método utilizado para confirmar a receção de um inteiro de tamanho 10 e se este já existe atribuído a outro funcionário. Utilizado na criação de funcionários.
     * @param numeroMecanografico
     * @param funcionarios
     * @return 
     */
    
    public static int confirmaNumero(int numeroMecanografico,ArrayList<Funcionario> funcionarios){
        Scanner input = new Scanner(System.in);
        boolean aux = true;
        boolean confirma = true;
        do{
            System.out.print("Número Mecanográfico:");
            String numero = input.nextLine();
            if(numero.length()==10){//estipulado pelo grupo que o número mecanográfico tem 10 caracteres
                for(int i=0;i<numero.length();i++){
                    char caracter = numero.charAt(i);
                    if(!Character.isDigit(caracter)){//verifica se algum caracter do número mecanográfico não é um dígito.Se não for não é aceite
                        confirma=false;
                    }
                }
                if(confirma){
                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario.getMecanografico() == Integer.parseInt(numero)) {//caso todos os caracteres sejam dígitos verifica depois se o número mecanográfico introduzido já é existente,caso seja não é aceite
                            confirma=false;
                        }
                    }
                    if(confirma){//se o número mecanográfico dado não existir então este é copiado para a variável numeromecanografico e convertido a inteiro para depois ser retornado
                        numeroMecanografico= Integer.parseInt(numero);
                        aux=false;
                    }
                    else{//se o número mecanográfico já existir não é aceite e volta a pedir o input ao utilizador até ser aceite
                        System.out.println("Número inválido:número já existente.");
                        confirma=true;
                        aux=true;
                    }
                }
                else{//se o número mecanográfico tiver caracteres não numéricos não é aceite e volta a pedir o input ao utilizador até ser aceite
                    System.out.println("Número inválido:caracteres não numéricos.");
                    confirma=true;
                    aux=true;
                }
            }
            else{//se o número mecanográfico não tiver 10 caracteres não é aceite e volta a pedir o input ao utilizador até ser aceite
                System.out.println("Número inválido:número não tem 10 caracteres.");
                confirma=true;
                aux=true;
            }
        }while(aux);
        return numeroMecanografico;
    }
    
    /**
     * Método utilizado para confirmar a receção de um inteiro de tamanho 10 e se este já existe atribuído a outro aluno. Utilizado na criação de alunos.
     * @param numeroAluno
     * @param alunos
     * @return 
     */
    public static int confirmaNumeroAluno(int numeroAluno,ArrayList<Aluno> alunos){
        Scanner input = new Scanner(System.in);
        boolean aux = true;
        boolean confirma = true;
        do{
            System.out.print("Número:");
            String numero = input.nextLine();
            if(numero.length()==10){//estipulado pelo grupo que o número mecanográfico tem 10 caracteres
                for(int i=0;i<numero.length();i++){
                    char caracter = numero.charAt(i);
                    if(!Character.isDigit(caracter)){//verifica se algum caracter do número de aluno não é um dígito.Se não for não é aceite
                        confirma=false;
                    }
                }
                if(confirma){
                    for (Aluno aluno : alunos) {
                        if (aluno.getNumeroaluno() == Integer.parseInt(numero)) {//caso todos os caracteres sejam dígitos verifica depois se o número de aluno introduzido já é existente,caso seja não é aceite
                            confirma=false;
                        }
                    }
                    if(confirma){//se o número de aluno dado não existir então este é copiado para a variável numeromecanografico e convertido a inteiro para depois ser retornado
                        numeroAluno= Integer.parseInt(numero);
                        aux=false;
                    }
                    else{//se o número de aluno já existir não é aceite e volta a pedir o input ao utilizador até ser aceite
                        System.out.println("Número inválido:número já existente.");
                        confirma=true;
                        aux=true;
                    }
                }
                else{//se o número de aluno tiver caracteres não numéricos não é aceite e volta a pedir o input ao utilizador até ser aceite
                    System.out.println("Número inválido:caracteres não numéricos.");
                    confirma=true;
                    aux=true;
                }
            }
            else{//se o número de aluno não tiver 10 caracteres não é aceite e volta a pedir o input ao utilizador até ser aceite
                System.out.println("Número inválido:número não tem 10 caracteres.");
                confirma=true;
                aux=true;
            }
        }while(aux);
        return numeroAluno;
    }
    
    /**
     * Método utilizado para confirmar a receção de uma String data no formato estipulado. Utilizado na criação de exames.
     * @param data
     * @return 
     */
    public static String confirmaData(String data){
        boolean aux = true;
        boolean confirm = true;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Data(dd/mm/aaaa):");
            String nomes = input.nextLine();
            if(nomes.length()==10){//tamanho da data no formato pedido
                for(int i=0;i<nomes.length();i++){
                    char caracter = nomes.charAt(i);
                    if(i!=2 && i!=5){
                        if(!Character.isDigit(caracter)){//verifica se os caracteres referentes ao dia,mês e ano são dígitos, caso não sejam não é aceite
                            confirm = false;
                        }
                    }
                    else{
                        if(caracter!='/'){//verifica se a sepração do dia para o mês e do mês para o ano é o caracter '/', se não for não é aceite
                            confirm = false;
                        }
                    }
                }
                if(confirm){//caso a data esteja de acordo com os critérios em cima é copiada para a variável data para depois ser retornada
                    data=nomes;
                    aux=false;
                }
                else{//caso não esteja de acordo com os critérios em cima volta a pedir o input ao utilizador até ser aceite
                    System.out.println("Data inválida:por favor introduza uma data no formato dd/mm/aaaa.");
                    confirm = true;
                    aux=true;
                } 
                
            }
            else{//como não tem 10 caracteres não é aceite e volta a pedir o input ao utilizador até ser aceite
                System.out.println("Data inválida:por favor introduza uma data no formato dd/mm/aaaa.");
                confirm = true;
                aux=true;        
            }      
        }while(aux);
        return data;
    }
    
    /**
     * Método utilizado para confirmar a receção de uma String hora no formato estipulado. Utilizado na criação de exames.
     * @param hora
     * @param opcao
     * @param erro
     * @return 
     */
    public static String confirmaHora(String hora,String opcao,String erro){//proteção utilizada para a hora de um exame e sua duração daí ter os parâmetros String opcao e String erro para fazer referência da escolha e em caso de erro do erro ao utilizador
        boolean aux = true;
        boolean confirm = true;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print(opcao);
            String horainput = input.nextLine();
            if(horainput.length()==5){//devido a ser do tipo hh:mm
                for(int i=0;i<horainput.length();i++){
                    char caracter = horainput.charAt(i);
                    if(i!=2 && i!=5){
                        if(!Character.isDigit(caracter)){//verifica se os caracteres referentes às horas e minutos são dígitos, caso não sejam não é aceite
                            confirm = false;
                        }
                    }
                    else{
                        if(caracter!=':'){//verifica se o caracter de separação das horas e minutos é ':', caso não seja não é aceite
                            confirm = false;
                        }
                    }
                }
                if(confirm){//se tiver verificado todos os casos em cima,se estiver no formato pedido, é então aceite e copiada para a variável hora para depois ser retornada
                    hora=horainput;
                    aux=false;
                }
                else{//caso a data não se encontre no formato pedido não é aceite e volta a pedir o input ao utilizador até ser aceite
                    System.out.println(erro);
                    confirm = true;
                    aux=true;
                } 
                
            }
            else{//caso a data não tenha 5 caracteres não é aceite e volta a pedir o input ao utilizador até ser aceite
                System.out.println(erro);
                confirm = true;
                aux=true;        
            }      
        }while(aux);
        return hora;
    }
    
    /**
     * Método utilizado para confirmar que a data e hora introduzidas são válidas, estão de acordo com o calendário e relógio. Utilizado na criação e confirmação de exames.
     * @return 
     */
    public static Data confirmaDataActual(){//proteção para verificar se a data e hora dadas são válidas
        Data dataFinal = null;
        String data="",hora="";
        String[] data2;
        String[] hora2;
        Data data3;
        boolean confirma = true;
        do{
            data = confirmaData(data);
            data2 = data.split("/");
           
            hora = confirmaHora(hora,"Hora(hh:mm):","Hora inválida:por favor introduza uma data no formato hh:mm.");
            hora2 = hora.split(":");
            
            if(Integer.parseInt(hora2[0])>=0 && Integer.parseInt(hora2[0])<=23){//confirma se as horas estão entre as 00 horas e as 23 horas
                if(Integer.parseInt(hora2[1])>=0 && Integer.parseInt(hora2[1])<=59){//confirma se os minutos estão entre os 00 minutos e os 59 minutos
                    confirma=true;
                }
                else{
                    System.out.println("Minutos só vão de 00 a 59");
                    confirma=false;
                }
            }
            else{
                System.out.println("Horas só vão de 00 a 23");
            }
            data3 = new Data(Integer.parseInt(data2[0]),Integer.parseInt(data2[1]),Integer.parseInt(data2[2]),hora2[0],hora2[1]);
            if(!data3.confirmaData()){//verifica se a data introduzida é uma data válida(definição de válida explicada na classe Data na função confirmaData())
                confirma=false;
            }
        }while(!confirma);//enquanto a hora introduzida não tiver as horas entre as 00 e as 23 e os minutos entre os 00 e os 59 não é aceite e volta a ser pedido o input ao utilizador
        dataFinal = data3; //após ser aceite a data e a hora, estas são utilizadas para criar uma só data com esta mesma data e hora incluidas
             
        return dataFinal;
    }
    
    /**
     * Método utilizado para confirmar a existência de uma disciplina com base no nome. Utilizado para criar exames, associar disciplinas a cursos e associar docentes e alunos a disciplinas.
     * @param disciplinas
     * @param disciplina
     * @return 
     */
    public static Disciplina confirmaDisciplina(ArrayList<Disciplina> disciplinas,Disciplina disciplina){
        Scanner input = new Scanner(System.in);
        boolean aux = false;
        while(disciplina==null){
            System.out.println("Disciplinas Existentes");
            for(int i=0;i<disciplinas.size();i++){
                System.out.println(disciplinas.get(i).getNome());
            }
            System.out.println();
            System.out.print("Disciplina:");
            String disc=input.nextLine();
            for (Disciplina disciplina1 : disciplinas) {//percorre o ArrayList<Disciplina> disciplinas 
                if (disciplina1.getNome().equals(disc)) {//se numa dada posição o nome da Disciplina for igual ao nome introduzido pelo utilizador o objecto Disciplina contido nessa posição é copiado para o objecto Disciplina disciplina para depois ser retornado
                    disciplina = disciplina1;
                    aux=true;
                    break;
                }
            }
            if(!aux){//caso não exista uma disciplina no ArrayList<Disciplina> com o nome introduzido volta a pedir o input ao utilizador até ser introduzido o nome de uma disciplina existente
                System.out.println("Disciplina inexistente\n");
            }
        }
        return disciplina;
    }
    
    /**
     * Método utilizado para confirmar o número de salas e a disponibilidade de cada para uma dada data. Utilizado na criação de exames.
     * @param salas
     * @param salasExame
     * @param exames
     * @param data
     * @param duracao
     * @return 
     */
    public static ArrayList<Sala> confirmaSalas(ArrayList<Sala> salas,ArrayList<Sala> salasExame,ArrayList<Exame> exames,Data data,Data duracao){
        int numSalas = 0;
        String nomeSala = "";
        while(numSalas<1){
            numSalas=confirmaInt(numSalas,"Número de salas(uma ou mais):"); //pede ao utilizador o número de salas para um dado exame
        }
        boolean aux=false;
        for(int k=0;k<numSalas;k++){//executa tantas vezes quanto o número de salas introduzido
            Sala sala = null;
            while(sala==null){
                Sala salaAux = null;
                System.out.println("Salas disponíveis para este exame");
                for(int i=0;i<salas.size();i++){
                    salaAux = salas.get(i);
                    if(salaAux.confirmaSala(exames, data, duracao)){
                        if(!salasExame.isEmpty()){
                            for(int j=0;j<salasExame.size();j++){
                                if(!salasExame.get(j).getNome().equals(salaAux.getNome())){
                                    System.out.println(salaAux);
                                }
                            }
                        }
                        else{
                           System.out.println(salaAux); 
                        }
                    }     
                }
                nomeSala = confirmaNomeSala(nomeSala,salas,"Verificar");
                for (Sala sala1 : salas) {//percorrre o ArrayList<Sala> salas
                    if (sala1.getNome().equals(nomeSala)) {//verifica se o nome da sala dado pelo utilizador corresponde ao nome de alguma sala existente no ArrayList<Sala> salas 
                        if (sala1.confirmaSala(exames, data, duracao)) {//verifica se a sala desejada se encontra disponível
                            sala = sala1; 
                            salasExame.add(sala);//se se encontrar disponível adiciona a sala desejada ao ArrayList<Sala> salasexame, ou seja às salas do exame
                            aux=true;
                            break;
                        } else {//caso já se enconte ocupada volta a pedir o input ao utilizador para o nome da sala
                            System.out.println("Esta sala já se encontra ocupada");
                            aux=true;
                            break;
                        }
                    }
                }
                if(!aux){//caso nenhuma sala do ArrayList<Sala> salas é de novo pedido ao utilizador o input para o nome da sala
                    System.out.println("Sala inexistente\n");
                }
            }
            aux=false;
        }
        return salasExame;
    }
    
    /**
     * Método utilizado para confirmar a existência de um funcionário com base no seu número mecanográfico. Utilizado para listar os exames de um funcionário.
     * @param funcionarios
     * @param funcionario
     * @return 
     */
    
    public static Funcionario confirmaFuncionarios(ArrayList<Funcionario> funcionarios,Funcionario funcionario){
        boolean aux = false;
        int num = 0;
        while(funcionario==null){
            System.out.println("Funcionarios Existentes");
            for(int i=0;i<funcionarios.size();i++){
                System.out.println(funcionarios.get(i));
            }
            num = confirmaInt(num,"Número Mecnográfico:");
            for (Funcionario funcionario1 : funcionarios) {//percorre o ArrayList<Funcionario>
                if (funcionario1.getMecanografico()==num) {//verifica se no ArrayList<Funcionario> existe algum funcionário com o número mecanográfico introduzido
                    funcionario = funcionario1;//caso exista um funcionário com o número mecanográfico introduzido este é guardado no objecto Funcionario funcionario para depois ser retornado
                    aux=true;
                    break;
                }
            }
            if(!aux){//caso não seja encontrado nenhum funcionário com o número mecanográfico introduzido volta a pedir ao utilizador o input para o número mecanográfico
                System.out.println("Funcionario inexistente\n");
            }
        }
        return funcionario;
    }
    
    /**
     * Método utilizado para verificar a existência de um docente com base no seu número mecanográfico e, em caso de se tratar de um exame, confirmar a sua disponibilidade para o mesmo. Utilizado para a criação de exames e disciplinas e para a alteração do docente responsável de uma disciplina.
     * @param funcionarios
     * @param docentesExame
     * @param docente
     * @param texto
     * @param exames
     * @param data
     * @param duracao
     * @param tipo
     * @return 
     */
    public static Docente confirmaRegente(ArrayList<Funcionario> funcionarios,ArrayList<Docente> docentesExame,Docente docente,String texto,ArrayList<Exame>exames,Data data,Data duracao,String tipo){
        //função utilizada para definir o responsável de um exame e o responsável de uma disciplina daí o parâmetro String texto
        boolean aux = false;
        int num = 0;
        while(docente==null){
            if(tipo.equals("Exame")){
                Docente docenteAux = null;
                System.out.println("Docentes disponíveis para este exame");
                for(int i=0;i<funcionarios.size();i++){
                    if(funcionarios.get(i).getTipo().equals("Docente")){
                        docenteAux = (Docente) funcionarios.get(i);
                            if(docenteAux.confirmaDocente(exames, data, duracao)){
                                System.out.println(docenteAux);
                            }
                    }
                }
            }
            num = confirmaInt(num,texto);
            for (Funcionario funcionario : funcionarios) {//percorre o ArrayList<Funcionario>
                if (funcionario.getMecanografico()==num) {//verifica se o número mecanográfico introduzido corresponde a algum funcionário presente no ArrayList<Funcionario>
                    if (funcionario.getTipo().equals("Docente")){//verifica se o funcionário desejado é do tipo docente
                        docente = (Docente) funcionario;
                        if(tipo.equals("Exame")){//verifica se irá ser o responsável de um exame ou de uma disciplina
                            if(docente.confirmaDocente(exames, data, duracao)){//verifica se o docente em causa se encontra livre na hora do exame em causa
                                docentesExame.add(docente);//caso esteja então o docente é inserido no ArrayList<Docente> docentesexame
                                aux = true;
                            }
                            else{//caso não o docente não se encontre disponível para o exame em causa é de novo pedido ao utilizador o input para o número mecanográfico
                                System.out.println("Este Docente já se encontra num exame nesta data a esta hora");
                                aux = true;
                                docente = null;
                            }
                        }
                        else{//caso seja para o docente ser responsável da disciplina não é necessário verificar a sua disponibilidade, sendo apenas necessário retornar o docente em causa
                            aux = true;
                            break;
                        }
                        
                    } else {//caso o número mecanográfico introduzido corresponda ao número mecanográfico de um Não Docente volta a ser pedido ao utilizador o input do número mecanográfico
                        System.out.println("O número mecanográfico introduzido não corresponde a um docente.Por favor introduza o número mecanográfico de um docente");
                    }
                }
            }
            if(!aux){//caso o número mecanográfico não corresponda ao número mecanográfico de nenhum funcionário volta a ser pedido ao utilizador o input para o número mecanográfico
                System.out.println("Docente não existente");
            }
        }
        return docente;
           
    }
    /**
     * Método utilizado para a confirmar a existência de um número de docentes com base no seu número mecanográfico, e no caso de se tratar de um exame confirmar a disponibilidade dos diferentes docentes para o mesmo. Utilizado para a criação de exames e disciplinas. 
     * @param funcionarios
     * @param docentesExame
     * @param exames
     * @param data
     * @param duracao
     * @param tipo
     * @return 
     */
    public static ArrayList<Docente> confirmaDocentes(ArrayList<Funcionario> funcionarios,ArrayList<Docente> docentesExame,ArrayList<Exame> exames,Data data,Data duracao,String tipo){
        int numDoc = 0;
        int numMecano = 0;
        numDoc = confirmaInt(numDoc,"Número de docentes:");
        boolean aux = false;
        boolean aux2 = true;
        for(int j=0;j<numDoc;j++){
            Docente docente = null;
            while(docente==null){
                if(tipo.equals("Exame")){
                    Docente docenteAux = null;
                    System.out.println("Docentes disponíveis para este exame");
                    for(int i=0;i<funcionarios.size();i++){
                        if(funcionarios.get(i).getTipo().equals("Docente")){
                            docenteAux = (Docente) funcionarios.get(i);
                                if(docenteAux.confirmaDocente(exames, data, duracao)){
                                    if(!docentesExame.isEmpty()){
                                        for(int k=0;k<docentesExame.size();k++){
                                            if(docentesExame.get(k).getMecanografico()!=docenteAux.getMecanografico()){
                                                System.out.println(docenteAux);
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println(docenteAux);
                                    }
                                }
                        }
                    }
                }
                numMecano = confirmaInt(numMecano,"Número Mecnográfico:");
                for (Funcionario funcionario : funcionarios) {//percorre o ArrayList<Funcionario>
                    if (funcionario.getMecanografico()==numMecano) {//verifica se o número mecanográfico introduzido é corresponde ao número mecanográfico de algum funcionário existente
                        if (funcionario.getTipo().equals("Docente")) {//verifica se o funcionário em causa é um docente
                            docente = (Docente) funcionario;
                            if(tipo.equals("Exame")){//verifica se irá ser o responsável de um exame ou de uma disciplina
                                for(int i=0;i<docentesExame.size();i++){
                                    if(docentesExame.get(i).getMecanografico()==numMecano){//verifica se o docente introduzido já se encontra associado ao exame em causa
                                        aux2=false;
                                        aux=true;
                                        System.out.println("O docente inserido já se encontra associado a este exame");
                                    }
                                }
                                if(aux2){
                                    if(docente.confirmaDocente(exames, data, duracao)){//verifica se o docente em causa se encontra livre na hora do exame em causa
                                        docentesExame.add(docente);//caso esteja então o docente é inserido no ArrayList<Docente> docentesexame
                                        aux = true;
                                    }
                                    else{//caso não o docente não se encontre disponível para o exame em causa é de novo pedido ao utilizador o input para o número mecanográfico
                                        System.out.println("Este Docente já se encontra num exame nesta data a esta hora");
                                        aux = true;
                                        docente = null;
                                    }
                                }
                            }
                            else{//caso seja para o docente ser responsável da disciplina não é necessário verificar a sua disponibilidade, sendo apenas necessário retornar o docente em causa
                                aux = true;
                                break;
                            }
                        } else {//caso o número mecanográfico introduzido corresponda ao número mecanográfico de um Não Docente volta a ser pedido ao utilizador o input do número mecanográfico
                            System.out.println("O número mecanográfico introduzido não corresponde a um docente.Por favor introduza o número mecanográfico de um docente"); 
                        }
                    }
                }
                if(!aux){//caso o número mecanográfico não corresponda ao número mecanográfico de nenhum funcionário volta a ser pedido ao utilizador o input para o número mecanográfico
                    System.out.println("Docente não existente");
                }
                aux=false;
            }
            //aux=true;
        }
        return docentesExame;
    }
    
    /**
     * Método utilizado para a confirmar a existência de um número de não docentes com base no seu número mecanográfico. Utilizado para a criação de exames.
     * @param funcionarios
     * @param naoDocentesExame
     * @return 
     */
    public static ArrayList<NaoDocente> confirmaNaoDocentes(ArrayList<Funcionario> funcionarios,ArrayList<NaoDocente> naoDocentesExame){
        int num = 0;
        int numNaoDoc = 0;
        num = confirmaInt(num,"Número de não docentes:");
        boolean aux = false;
        boolean aux2 = true;
        for(int j=0;j<num;j++){
            NaoDocente naodocente = null;
            while(naodocente==null){
                NaoDocente naoDocenteAux = null;
                System.out.println(" Não Docentes disponíveis para este exame");
                for(int i=0;i<funcionarios.size();i++){
                    if(funcionarios.get(i).getTipo().equals("Não Docente")){
                        naoDocenteAux = (NaoDocente) funcionarios.get(i);
                        System.out.println(naoDocenteAux);
                    }
                }
                numNaoDoc = confirmaInt(numNaoDoc,"Número Mecnográfico:");
                for (Funcionario funcionario : funcionarios) {//percorre o ArrayList<Funcionario>
                    if (funcionario.getMecanografico()==numNaoDoc) {//verifica se o número mecanográfico introduzido é corresponde ao número mecanográfico de algum funcionário existente
                        if (funcionario.getTipo().equals("Não Docente")) {//verifica se o funcionário em causa é do tipo Não Docente
                            for(int i=0;i<naoDocentesExame.size();i++){
                                if(naoDocentesExame.get(i).getMecanografico()==numNaoDoc){//verifica se o não docente introduzido já se encontra associado ao exame em causa
                                    aux2=false;
                                    aux=true;
                                    System.out.println("O não docente inserido já se encontra associado a este exame");
                                }
                            }
                            if(aux2){
                                naodocente = (NaoDocente) funcionario;
                                naoDocentesExame.add(naodocente);//adiciona o Não Docente em questão nos docentes do exame em causa
                                aux=true;
                                break;
                            }
                        } else {//caso o número mecanográfico introduzido corresponda ao número mecanográfico de um Docente volta a ser pedido ao utilizador o input do número mecanográfico
                            System.out.println("O número mecanográfico introduzido não corresponde a um não docente.Por favor introduza o número mecanográfico de um não docente"); 
                        }
                    }
                }
                if(!aux){//caso o número mecanográfico não corresponda ao número mecanográfico de nenhum funcionário volta a ser pedido ao utilizador o input para o número mecanográfico
                    System.out.println("Não docente não existente");
                }
                aux=false;
            }
            //aux=true;
        }
        return naoDocentesExame;
    }
    
    /**
     * Método utilizado para confirmar a existência de um curso com base no nome do curso. Utilizado para a criação de alunos e associar/remover disciplinas a cursos.
     * @param curso
     * @param cursos
     * @return 
     */
    public static Curso confirmaCurso(Curso curso,ArrayList<Curso> cursos){
        String nomeCurso = "";
        boolean aux = false;
        while(curso==null){
            System.out.println("Cursos Existentes");
            for(int i=0;i<cursos.size();i++){
                System.out.println(cursos.get(i).getNome());
            }
            System.out.println();
            nomeCurso = confirmaString(nomeCurso,"Curso:");
            for (Curso curso1 : cursos) {//percorre o ArrayList<Curso> cursos
                if (curso1.getNome().equals(nomeCurso)) {//verifica se o nome introduzido corresponde ao nome de algum curso existente no ArrayList<Curso> cursos
                    curso = curso1;//caso exista copia o elemento do ArrayList<Curso> cursos cujo nome é igual ao introduzido para o objecto Curso curso para depois ser retornado
                    aux=true;
                    break;
                }
            }
            if(!aux){//caso o nome introduzido não corresponda a nenhum elemento do ArrayList<Curso> cursos volta a ser pedido o input do nome do curso
                System.out.println("Curso inexistente\n");
            }
        }
        return curso;
    }
    
    /**
     * Método utilizado para confirmar a existência de uma disciplina com base no nome da disciplina. Utilizado para a criação de exames, associar/remover disciplinas a cursos, inscrever alunos em disciplinas e alterar docente responsável e outros docentes de uma disciplina.
     * @param disciplina
     * @param disciplinas
     * @return 
     */
    public static Disciplina confirmaDisciplina(Disciplina disciplina,ArrayList<Disciplina> disciplinas){
        String nomeDisciplina = "";
        boolean aux = false;
        while(disciplina==null){
            nomeDisciplina = confirmaString(nomeDisciplina,"Disciplina:");
            for (Disciplina disciplina1 : disciplinas) {//percorre o ArrayList<Disciplina> disciplinas
                if (disciplina1.getNome().equals(nomeDisciplina)) {//verifica se o nome introduzido corresponde ao nome de disciplina de alguma disciplina presente em ArrayList<Disciplina> disciplinas
                    disciplina = disciplina1;//caso exista esse elemento do ArrayList<Disciplina> disciplinas é copiado para o objecto Disciplina disciplina para depois ser retornado
                    aux=true;
                    break;
                }
            }
            if(!aux){//caso o nome introduzido não corresponda a nenhum elemento do ArrayList<Disciplina> disciplinas volta a ser pedido o input do nome da disciplina
                System.out.println("Disciplina inexistente");
            }
        }
        return disciplina;
    }
    
    /**
     * Método utilizado para confirmar a existência de um aluno com base no seu número de aluno. Utilizado para inscrever aluno em exames e disciplinas como também para listar os exames em que um aluno se encontra inscrito.
     * @param alunos
     * @param aluno
     * @param tipo
     * @param exame
     * @return 
     */
    public static Aluno confirmaAluno(ArrayList<Aluno> alunos,Aluno aluno,String tipo,Exame exame){
        int num = 0;
        boolean aux = false;
        while(aluno==null){
            if(tipo.equals("Alterar Notas")){
                System.out.println("Alunos inscritos no exame");
                for(int i=0;i<exame.getInscritos().size();i++){
                    System.out.println(exame.getInscritos().get(i));
                }
            }
            else{
                System.out.println("Alunos Existentes");
                for(int i=0;i<alunos.size();i++){
                    System.out.println(alunos.get(i));
                }
            }
            num = confirmaInt(num,"Número de Aluno:");
            for (Aluno aluno1 : alunos) {//percorre o ArrayList<Aluno> alunos
                if (aluno1.getNumeroaluno()==num) {//verifica se o número introduzido corresponde ao número de aluno de algum aluno presnte no ArrayList<Aluno> alunos
                    aluno = aluno1;//caso corresponda então esse elemento do ArrayList<Aluno> alunos é copiado para o objecto Aluno aluno para depois ser retornado
                    aux=true;
                    break;
                }
            }
            if(!aux){//caso o número introduzido não corresponda a nenhum elemento do ArrayList<Aluno> alunos volta a ser pedido o input do número de aluno ao utilizador
                System.out.println("Aluno inexistente\n");
            }
        }
        return aluno;
    }
    /**
     * Método utilizado para confirmar a receção de um dos estatutos de aluno aceites. Utilizado na criação de alunos.
     * @param estatuto
     * @return 
     */
    public static String confirmaEstatutoAluno(String estatuto){
        Scanner input = new Scanner(System.in);
        boolean aux = false;
        while(!estatuto.equals("Normal") || !estatuto.equals("Trabalhador-estudante") || !estatuto.equals("Atleta") || !estatuto.equals("Dirigente associativo") || !estatuto.equals("Erasmus")){
            System.out.print("Estatuto(Normal,Trabalhador-estudante,Atleta,Dirigente associativo,Erasmus):");
            String estatutoin = input.nextLine();
            if(estatutoin.equals("Normal") || estatutoin.equals("Trabalhador-estudante") || estatutoin.equals("Atleta") || estatutoin.equals("Dirigente associativo") || estatutoin.equals("Erasmus")){
                estatuto=estatutoin;//quando o input intoduzido para o estatuto do aluno é aceite este é copiao para a variável String estatuto para depois ser retornado
                aux=true;
                break;
            }
            if(!aux){
                System.out.println("Estatuto inválido.");
            }//enquanto o input introduzido pelo utilizador para o estatuto do aluno for difrente dos estatudos permitidos este não é aceite e é pedido um novo input para o estatuto do aluno ao utilizador
        }
        return estatuto;
    }
    
    /**
     * Método utilizado para confirmar a existência de um exame com base na disciplina data e hora do mesmo. Utilizado para inscrever alunos em exames, associar docentes/não docentes a exames e listar/alterar as notas de um exame.
     * @param tipo
     * @param exame
     * @param disciplina
     * @param data
     * @param hora
     * @param disciplinas
     * @param exames
     * @return 
     */
    public static Exame confirmaExame(String tipo,Exame exame,Disciplina disciplina,String data,String hora,ArrayList<Disciplina> disciplinas,ArrayList<Exame> exames){
        //método que permite encontrar um exame com base na sua disciplina, data e hora
        boolean aux = false;
        Data dataExame;
        while(exame==null){
            disciplina=confirmaDisciplina(disciplinas,disciplina);//através do método confirmaDisciplina confirma a disciplina do exame
            System.out.println();
            System.out.println("Exames da disciplina pretendida");
            for(int i=0;i<exames.size();i++){
                if(exames.get(i).getDisciplina().getNome().equals(disciplina.getNome())){
                    System.out.println(exames.get(i));
                }
            }
            System.out.println();
            if(tipo.equals("Lançar Notas")){
                data = confirmaData(data);
                String data2[] = data.split("/");
                hora = confirmaHora(hora,"Hora(hh:mm):","Hora inválida:por favor introduza uma data no formato hh:mm.");
                String hora2[] = hora.split(":");
                dataExame = new Data(Integer.parseInt(data2[0]),Integer.parseInt(data2[1]),Integer.parseInt(data2[2]),hora2[0],hora2[1]);
            }
            else{
                dataExame = confirmaDataActual();//através do método confirmaDataActual confirma a data e hora do exame
            }
            for (Exame exame1 : exames) {
                if (exame1.getDisciplina().getNome().equals(disciplina.getNome()) && exame1.getData().getDia() == dataExame.getDia() && exame1.getData().getMes() == dataExame.getMes() && exame1.getData().getAno() == dataExame.getAno() && exame1.getData().getHoras().equals(dataExame.getHoras()) && exame1.getData().getMinutos().equals(dataExame.getMinutos())) {
                    exame = exame1;
                    aux=true;
                    break;
                }//percorre o ArrayList<Exame> exames de modo a ver se algum elemento do ArrayList<Exame> exames possui a disciplina,data e hora iguais às introduzidas pelo utilizador.Se possuir então esse objecto do ArrayList<Exame> exames é copiado para o objecto Exame exame para depois ser retornado 
            }
            if(!aux){//caso não exista no ArrayList<Exame> exames nenhum elemento com a disciplina,data e hora iguais às introduzidas pelo utilizador voltam a ser pedidos os mesmos até haver um exame que possua essa disciplina, data e hora
                System.out.println("Exame inexistente\n");
            }
        }
        return exame;
    }
    
    /**
     * Método utilizado para a criação de exames de uma das três épocas existentes. Utilizado para a criação de exames.
     * @param disciplina
     * @param data
     * @param hora
     * @param docente
     * @param duracao
     * @param salas
     * @param funcionarios
     * @param disciplinas
     * @param exames
     * @param epoca
     * @param fo
     */
    public static void criaExame(Disciplina disciplina,String data,String hora,Docente docente,String duracao,ArrayList<Sala> salas,
        ArrayList<Funcionario> funcionarios,ArrayList<Disciplina> disciplinas,ArrayList<Exame> exames,String epoca,ficheirosObjectos fo){
        //método para criar os 3 tipos de exame consoante o valor do parâmetro String epoca
        ArrayList<Aluno> alunosexame = new ArrayList<>();
        ArrayList<Classificacao> notasexame = new ArrayList<>();
        ArrayList<Sala> salasexame = new ArrayList<>();
        ArrayList<Docente> docentesExame = new ArrayList<>();
        ArrayList<NaoDocente> naoDocentesExame = new ArrayList<>();
        disciplina=null;//posta a null para no momento de escolher a disciplina esta não ter a possibilidade de já conter um objecto do tipo Disciplina
        docente=null;//posto a null para no momento de escolher o docente este não ter a possibilidade de já conter um objecto do tipo Docente
        disciplina=confirmaDisciplina(disciplinas,disciplina);//através do método confirmaDisciplina confirma a disciplina do exame
        Data dataExame = confirmaDataActual();//através do método confirmaDataActual confirma a data e hora do exame
        duracao=confirmaHora(duracao,"Duração(hh:mm):","Duração inválida:por favor introduza uma doração no formato hh:mm.");//através do método confirmaHora confirma a duração do exame
        String duracao2[]=duracao.split(":");
        Data duracaoExame = new Data(duracao2[0],duracao2[1]);
        salasexame=confirmaSalas(salas,salasexame,exames,dataExame,duracaoExame);//atravécs do método confirmaSalas confirma as salas introduzidas pelo utilizador, e se se encontram disponíveis
        docente=confirmaRegente(funcionarios,docentesExame,docente,"Número Mecanográfico do Docente Responsável:",exames,dataExame,duracaoExame,"Exame");//através do método confirmaRegente confirma o número mecanográfico do docente introduzido pelo utilizador, e se se encontra disponível
        docentesExame=confirmaDocentes(funcionarios,docentesExame,exames,dataExame,duracaoExame,"Exame");//através do método confirmaDocentes confirma os números mecanográficos dos docentes introduzidos pelo utilizador, e se se encontram disponíveis
        naoDocentesExame=confirmaNaoDocentes(funcionarios,naoDocentesExame);//através do método confirmaNaoDocentes confirma os números mecanográficos dos não docentes introduzidos pelo utilizador
        //consoante a epoca é então criado o exame associado a esta, Normal,Recurso ou Especial
        switch (epoca) {
            case "Normal":
                {
                    Normal exameadicionar = new Normal(disciplina,dataExame,duracaoExame,salasexame,docente,docentesExame,naoDocentesExame,alunosexame,notasexame);
                    exames.add(exameadicionar);
                    break;
                }
            case "Recurso":
                {
                    Recurso exameadicionar = new Recurso(disciplina,dataExame,duracaoExame,salasexame,docente,docentesExame,naoDocentesExame,alunosexame,notasexame);
                    exames.add(exameadicionar);
                    break;
                }
            case "Especial":
                {
                    Especial exameadicionar = new Especial(disciplina,dataExame,duracaoExame,salasexame,docente,docentesExame,naoDocentesExame,alunosexame,notasexame);
                    exames.add(exameadicionar);
                    break;
                }
        }
        //depois de criado o objecto do tipo Exame exame o ficheiro "exames.bin" é então actualizado 
        try{
            fo.abreEscrita("exames.bin");
            fo.escreveObjecto(exames);
            fo.fechaEscrita();
        }
        catch (Exception c) {
            System.out.println("Ocorreu um erro " + c);
                    
        }   
    }
    
    /**
     * Método utilizado para confirmar a receção de um inteiro. Utilizado por exemplo para confirmar o número de salas, número de docentes/não docentes.
     * @param inteiro
     * @param opcao
     * @return 
     */
    public static int confirmaInt(int inteiro,String opcao){
        //método para proteger variáveis do tipo int
        Scanner input = new Scanner(System.in);
        boolean aux = true;
        boolean confirma = true;
        do{
            System.out.print(opcao);
            String numero = input.nextLine();
            for(int i=0;i<numero.length();i++){
                char caracter = numero.charAt(i);
                if(!Character.isDigit(caracter)){//verifica se algum caracter não é um digito
                    confirma=false;//se não for o input não é aceite
                }
            }
            if(confirma){//se for aceite é convertido para inteiro e guardado na variável inteiro para depois ser retornado
               inteiro=Integer.parseInt(numero);
               aux=false;
            }
            else{//caso não seja, volta a ser pedido o input ao utilizador até ser um input aceite
                System.out.println("Escolha inválida:por favor introduza um número"); 
                aux=true;
                confirma=true;
            }
        }while(aux);
        return inteiro;
    }
    
    /**
     * Método utilizado para confirmar a receção de um endereço de e-mail no formato estipulado. Utilizado na criação de alunos e funcionários.
     * @param email
     * @return 
     */
    public static String confirmaMail(String email){
        Scanner input = new Scanner(System.in);
        boolean aux = true;
        boolean confirma = true;
        boolean arroba = true;
        String[] extensao;
        do{
            System.out.print("Endereço de e-mail(@gmail.com,@hotmail.com):");//estipulado pelo grupo que só eram aceites estas duas extensões de e-mail
            String mail = input.nextLine();
            for(int i=0;i<mail.length();i++){
                char caracter = mail.charAt(i);
                if(caracter==32){//verifica se algum caracter é um espaço.Caso seja, o input não é aceite
                   confirma=false; 
                }
                if(caracter==64){//verifica a ocorrência do caracter '@'
                    arroba = false;
                }
            }
            if(arroba){//se o caracter '@' não estiver presente no input este não é aceite
                confirma = false;
            }
            else{
                extensao = mail.split("@");
                if(extensao[0].length()==0){//verifica se existem caracteres antes do caracter '@'
                    confirma = false;//caso não existam o input não é aceite
                }
                if(!extensao[1].equals("gmail.com") && !extensao[1].equals("hotmail.com")){//verifica se a extensão de e-mail é uma das duas aceites
                    confirma = false;//caso não seja, não é aceite o input
                } 
            }
            if(confirma){//caso o input seja aceite,este é copiado para a variável String email para depois ser retornado
                email=mail;
                aux=false;
            }
            else{//caso não seja, volta a ser pedido ao utilizador o input para o endereço de e-mail até este ser aceite
                System.out.println("Endereço de e-mail inválido");
                aux=true;
                confirma=true;
            }  
        }while(aux);
        return email;
    }
    /**
     * Método utilizado para confirmar a receção do nome da sala no formato estipulado. Utilizado para a criação de salas.
     * @param nomeSala
     * @param salas
     * @param tipo
     * @return 
     */
    public static String confirmaNomeSala(String nomeSala,ArrayList<Sala> salas,String tipo){
        Scanner input = new Scanner(System.in);
        boolean aux = true;
        boolean confirma = true;
        boolean espaco = false;
        String[] extensao;
        do{
            System.out.print("Nome da Sala:");
            String nome = input.nextLine();
            for(int i=0;i<nome.length();i++){
                char caracter = nome.charAt(i);
                if(caracter==32){//verifica a ocorrência do caracter espaço
                   espaco = true;
                }
            }
            if(!espaco){//se não houver o caracter espaço no input este não é aceite
                confirma = false;
            }
            else{
                extensao = nome.split(" ");
                if(!extensao[0].equals("Sala") && !extensao[0].equals("Anfiteatro")){//por convenção do grupo
                    confirma = false;//caso não seja o input não é aceite
                }
                else{
                    if(extensao[1].length()==4 && extensao[0].equals("Sala")|| extensao[1].length()==5 && extensao[0].equals("Sala")){
                        //sala do tipo Sala G4.2 (como as salas do DEI)
                        for(int i=0;i<extensao[1].length();i++){
                            char caracter = extensao[1].charAt(i);
                            if(i==0){
                                if(!Character.isUpperCase(caracter)){//verifica se o primeiro caracter se encontra em maiúscula 
                                    confirma = false;//caso não se encontre o input não é aceite
                                }
                            }
                            else if(i==1){
                                if(!Character.isDigit(caracter)){//verifica se o segundo caracter é um digito 
                                    confirma = false;//caso não seja, o input não é aceite
                                }
                            }
                            else if(i==2){
                                if(caracter!=46){//verifica se o terceiro caracter é '.'
                                    confirma = false;//caso não seja o input não é aceite
                                }
                            }
                            else{
                                if(!Character.isDigit(caracter)){//verifica se os caracteres restantes são digitos
                                    confirma = false;//caso não sejam o input não é aceite
                                }
                            }
                        }
                    }
                }
                if(!extensao[0].equals("Anfiteatro") && !extensao[0].equals("Sala")){
                    confirma = false;
                }
                else{
                    if(extensao[1].length()==1 && extensao[0].equals("Anfiteatro")){
                        // sala do tipo Anfiteatro A
                        for(int i=0;i<extensao[1].length();i++){
                            char caracter = extensao[1].charAt(i);
                            if(i==0){
                                if(!Character.isUpperCase(caracter)){//verifica se o caracter da posição 0 se encontra em letra maiúscula
                                    confirma = false;//caso não se encontre o input não é aceite
                                }
                                if(caracter<65 && caracter>71){//verifica se o caracter da posição 0 é A,B,C,D ou E
                                    confirma = false;//caso não seja o input não é aceite
                                }
                               
                            }
                        }
                    }
                }
                if(confirma){//caso o input seja aceite verifica depois se já existe alguma sala no ArrayList<Sala> salas com esse nome
                    if(tipo.equals("Criar")){
                        for (Sala sala : salas) {
                            if (sala.getNome().equals(nome)) {//caso exista então o nome dado não é aceite
                                confirma = false;
                            }
                        }
                        if(confirma){//se o nome para a sala for válido e ainda não existir, então este é copiado para a variável nomeSala para depois ser retornado
                            nomeSala=nome;
                            aux=false;
                        }
                        else{//caso o nome introduzido já exista este não é aceite e volta a ser pedido o input para o nome da sala ao utilizador até este ser aceite
                            System.out.println("Sala já existente");
                            aux=true;
                            confirma=true;
                        }
                    }
                    else{
                        nomeSala=nome;
                        aux=false;
                    }
                }
                else{//caso o nome introduzido não esteja de acordo com o previsto este naão é aceite e volta a ser pedido o input para o nome da sala
                    System.out.println("Nome inválido");
                    aux=true;
                    confirma=true;
                }     
            }
            
        }while(aux);
        return nomeSala;
    }
    
    /**
     * Método utilizado para a criação de funcionários. Utilizado para a criação de funcionários.
     * @param escolha
     * @param nome
     * @param mecanografico
     * @param funcionarios
     * @param mail
     * @param categoria
     * @param areaCargo
     * @param fo 
     */
    public static void criaFuncionario(int escolha,String nome,int mecanografico,ArrayList<Funcionario> funcionarios,String mail,String categoria,String areaCargo,ficheirosObjectos fo){
        nome = confirmaString(nome,"Nome:");
        mail = confirmaMail(mail);
        mecanografico = confirmaNumero(mecanografico,funcionarios);//confirma o número mecanográfico introduzido com recurso ao método confirmaNumero
        if(escolha==0){//para criar um docente
            categoria = confirmaCategoria("Docente",categoria);//confirma a categoria introduzida com recurso ao método confirmaCategoria
            areaCargo = confirmaAreaECargo("Docente",areaCargo);//confirma a área de investigação introduzida com recurso ao método confirmaAreaECargo
            Docente novodocente = new Docente(nome,mail,mecanografico,categoria,areaCargo);
            funcionarios.add(novodocente);
        }
        else if(escolha==1){//para criar um não docente
            categoria = confirmaCategoria("Não Docente",categoria);//confirma a categoria introduzida com recurso ao método confirmaCategoria
            areaCargo = confirmaAreaECargo("Não Docente",areaCargo);//confirma o cargo introduzido com recurso ao método confirmaAreaECargo
            NaoDocente novonaodocente = new NaoDocente(nome,mail,mecanografico,categoria,areaCargo);
            funcionarios.add(novonaodocente);
        }
        //depois de criar um funcionário o ficheiro "funcionarios.bin" é actualizado
        try{
            fo.abreEscrita("funcionarios.bin");
            fo.escreveObjecto(funcionarios);
            fo.fechaEscrita();
        }
        catch (Exception c) {
            System.out.println("Ocorreu um erro " + c);             
        } 
    }
    
    /**
     * Método utilizado para confirmar que o grau recebido para um curso se encontra dentro dos aceites. Utilizado na criação de cursos.
     * @param grau
     * @return 
     */
    public static String confirmaGrau(String grau){
        Scanner input = new Scanner(System.in);
        boolean aux = true;
        boolean confirma = true;
        do{
            System.out.print("Grau(Licenciatura,Mestrado,Douturamento):");
            String grauInput = input.nextLine();
            if(!grauInput.equals("Licenciatura") && !grauInput.equals("Mestrado") && !grauInput.equals("Doutoramento")){//verifica se o grau introduzido corresponde a algum dos aceites
                confirma = false;
            }
            if(confirma){//caso corresponda o input é aceite e copiado para a variável String grau para depois ser retornado 
                grau = grauInput;
                aux = false;
            }
            else{//caso não corresponda o input não é aceite e volta a ser pedido ao utilizador o input para o grau até este ser aceite
                confirma = true;
                System.out.println("Grau Inválido");
            }
        }while(aux);
        return grau;
    }
    /**
     * Método utilizado para confirmar que a categoria recebida para um funcionário se encontra dentro das aceites. Utilizado na criação de funcionários.
     * @param tipo
     * @param categoria
     * @return 
     */
    public static String confirmaCategoria(String tipo,String categoria){
        //método que confirma a categoria de um funcionário
        Scanner input = new Scanner(System.in);
        boolean aux = true;
        boolean confirma = true;
        String categoriaInput = "";
        do{
            switch (tipo) {
                case "Docente":
                    System.out.print("Categoria(Assistente,Auxiliar,Associado,Catedrático):");
                    categoriaInput = input.nextLine();
                    //verifica se o input introduzido corresponde a alguma categoria aceite para Docente
                    if(!categoriaInput.equals("Assistente") && !categoriaInput.equals("Auxiliar") && !categoriaInput.equals("Associado") && !categoriaInput.equals("Catedrático")){
                        confirma = false;
                    }   break;
                case "Não Docente":
                    System.out.print("Categoria(Assistente Operacional,Assistente Técnico,Técnico Superior,Técnico de Informática,Especialista de Informática):");
                    categoriaInput = input.nextLine();
                    //verifica se o input introduzido corresponde a alguma categoria aceite para Não Docente
                    if(!categoriaInput.equals("Assistente Operacional") && !categoriaInput.equals("Assistente Técnico") && !categoriaInput.equals("Técnico Superior") && !categoriaInput.equals("Técnico de Informática") && !categoriaInput.equals("Especialista de Informática")){
                        confirma = false;
                    }   break;
            }
            if(confirma){//caso corresponda o input é aceite e copiado então para a variável String categoria para depois ser retornado
                categoria = categoriaInput;
                aux = false;
            }
            else{//caso não corresponda o input não é aceite e volta a ser pedido ao utilizador o input para a categoria até este ser aceite
                System.out.println("Categoria Inválida");
                confirma = true;
            }
        }while(aux);
        return categoria;
    }
    
    /**
     * Método utilizado para confirmar que a/o área de investigação/cargo recebido para um docente/não docente se encontra dentro dos aceites. Utilizado na criação de funcionários.
     * @param tipo
     * @param areaCargo
     * @return 
     */
    public static String confirmaAreaECargo(String tipo,String areaCargo){
        //método para confirmar a área de investigação de um docente ou o cargo de um não docente
        Scanner input = new Scanner(System.in);
        boolean aux = true;
        boolean confirma = true;
        String escolha = "";
        do{
            switch (tipo) {
                case "Docente":
                    System.out.print("Área de Investigação(Sistemas de Informação,Comunicação e Telemática,Engenharia de Software,Inteligência Artificial):");
                    escolha=input.nextLine();
                    //verifica se a área de investigação introduzida corresponde a alguma das aceites
                    if(!escolha.equals("Sistemas de Informação") && !escolha.equals("Comunicação e Telemática") && !escolha.equals("Engenharia de Software") && !escolha.equals("Inteligência Artificial")){
                        confirma = false;
                    }    break;
                case "Não Docente":
                    System.out.print("Cargo(Secretaria,Financeiro,Apoio Técnico):");
                    escolha = input.nextLine();
                    //verifica se o cargo introduzido corresponde a algum dos aceites
                    if(!escolha.equals("Secretaria") && !escolha.equals("Financeiro") && !escolha.equals("Apoio Técnico")){
                        confirma = false;
                    }    break;
            }
           if(confirma){//caso o input para a/o área de investigação/cargo seja aceite então este é copiado para a variável areaCargo para depois ser retornado
              areaCargo = escolha;
              aux = false;
           }
           else{//caso o input não seja aceite volta a ser pedido ao utilizador o input para a/o área de investigação/cargo até este ser aceite
                switch (tipo) {
                    case "Docente":
                        System.out.print("Área de Investigação inválida");
                        confirma = true;
                        break;
                    case "Não Docente":
                        System.out.print("Cargo inválido");
                        confirma = true;
                        break;
                }
           }
        }while(aux);
        return areaCargo;
    }
    
    
    public static void main(String[] args) throws IOException {
        ArrayList<Exame> exames = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Sala> salas = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        ArrayList<Docente> docentesExame = new ArrayList<>();
        int i,escolha=0,mecanografico = 0,numeroAluno = 0,anoMatricula=0,lotacao=0,duracaoCurso = 0,numDisc = 0;
        String nome = "",data = "",hora = "",duracao = "",estatuto = "",mail = "",categoria = "",grau = "",areaCargo = "";
        Disciplina disciplina = null;
        Docente docente = null;
        Curso curso = null;
        Aluno aluno = null;
        Funcionario funcionario = null;
        Exame exame = null;
        ficheirosObjectos fo = new ficheirosObjectos();
        //leitura dos ficheiros de objectos e escrita do seu conteúdo nos respectivos ArrayList
        try{
            if (fo.abreLeitura("funcionarios.bin")) {
                funcionarios = (ArrayList<Funcionario>) fo.leObjecto();
                fo.fechaLeitura();
            }
        }
        catch (IOException | ClassNotFoundException q) {
            System.out.println("Ocorreu um erro " + q);
        }
        
        try{
            if (fo.abreLeitura("alunos.bin")) {
                alunos = (ArrayList<Aluno>) fo.leObjecto();
                fo.fechaLeitura();
            }
        }
        catch (IOException | ClassNotFoundException q) {
            System.out.println("Ocorreu um erro " + q);
        }
        
        try{
            if (fo.abreLeitura("disciplinas.bin")) {
                disciplinas = (ArrayList<Disciplina>) fo.leObjecto();
                fo.fechaLeitura();
            }
        }
        catch (IOException | ClassNotFoundException q) {
            System.out.println("Ocorreu um erro " + q);
        }
        
        try{
            if (fo.abreLeitura("cursos.bin")) {
                cursos = (ArrayList<Curso>) fo.leObjecto();
                fo.fechaLeitura();
            }
        }
        catch (IOException | ClassNotFoundException q) {
            System.out.println("Ocorreu um erro " + q);
        }
        
        try{
            if (fo.abreLeitura("exames.bin")) {
                exames = (ArrayList<Exame>) fo.leObjecto();
                fo.fechaLeitura();
            }
        }
        catch (IOException | ClassNotFoundException q) {
            System.out.println("Ocorreu um erro " + q);
        }
        
        //leitura do ficheiro .txt salas e escrita do seu conteúdo no ArrayList<Sala> salas
        
        FileReader frd = new FileReader(new File("salas.txt"));
        BufferedReader salasFicheiro = new BufferedReader(frd);
        String  linhaActual;
        String [] salasDoFicheiro;
        try{
            while (( linhaActual =  salasFicheiro.readLine()) != null) {
                salasDoFicheiro = linhaActual.split("-");
                Sala salaArray = new Sala(salasDoFicheiro[0],Integer.parseInt(salasDoFicheiro[1]));
                salas.add(salaArray);
             } 
        }
        catch(IOException | NumberFormatException e){
            System.out.println("Ocorreu um erro " + e);
        }
        while(true){
            escolha=confirmaEscolha(escolha,"1-Exames\n2-Alunos\n3-Funcionarios\n4-Salas\n5-Cursos\n6-Disciplinas\n7-Sair\nEscolha:");
            if(escolha==1){
                while(true){
                    escolha=confirmaEscolha(escolha,"1-Criar\n2-Listar\n3-Lançar notas de um exame\n4-Lista notas de um exame\n5-Alterar notas de um exame\n6-Voltar\nEscolha:");
                    if(escolha==1){
                        while(true){
                            escolha=confirmaEscolha(escolha,"1-Exame Normal\n2-Exame Recurso\n3-Exame Especial\n4-Voltar\nEscolha:"); 
                            if(escolha==1){
                                criaExame(disciplina,data,hora,docente,duracao,salas,funcionarios,disciplinas,exames,"Normal",fo);
                            }
                            
                            else if(escolha==2){
                                criaExame(disciplina,data,hora,docente,duracao,salas,funcionarios,disciplinas,exames,"Recurso",fo);
                            }
                            
                            else if(escolha==3){
                                criaExame(disciplina,data,hora,docente,duracao,salas,funcionarios,disciplinas,exames,"Especial",fo);
                            }
                            
                            else if(escolha==4){
                                break;
                            }
                        }
                    }

                    else if(escolha==2){
                        //listagem dos exames existentes
                        for (Exame exame1 : exames) {
                            System.out.println(exame1.toString());
                        }

                    }
                    else if(escolha==3){
                        exame=confirmaExame("Lançar Notas",exame,disciplina,data,hora,disciplinas,exames);//confirmação do exame que vão ser lançadas as notas
                        exame.lancaNotas();//lançamento das notas através do método lança notas da Classe Exame
                        exame=null;//para não ficar guardado nenhum objecto do tipo Exame e estar sempre pronto a utilizar
                        //depois de lançadas as notas, o ficheiro "exames.bin" é actualizado
                        try{
                            fo.abreEscrita("exames.bin");
                            fo.escreveObjecto(exames);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                        }
                    }
                    else if(escolha==4){
                        exame=confirmaExame("Lançar Notas",exame,disciplina,data,hora,disciplinas,exames);//confirma o exame em que as notas vão ser lançadas
                        System.out.println("Pauta do exame escolhido");
                        if(!exame.isNotasLancadas()){
                            for(int j=0;j<exame.getNotas().size();j++){
                                System.out.println(exame.getNotas().get(j));//lista cada aluno e nota do mesmo exame
                            }
                        }
                        else{
                            System.out.println("O exame que pretende listar as notas ainda não tem as notas lançadas");
                        }
                        exame=null;
                    }
                    else if(escolha==5){
                        System.out.println("Exame");
                        exame = confirmaExame("Criar",exame,disciplina,data,hora,disciplinas,exames);//confirma o exame que se pretende alterar as notas
                        exame.alteraNotas(aluno,alunos,exames,fo);
                        exame=null;
                        aluno=null;
                        try{
                            fo.abreEscrita("exames.bin");
                            fo.escreveObjecto(exames);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                        }
                    }

                    else if(escolha==6){
                        break;
                    }
                }
            }
            
            else if(escolha==2){
                while(true){
                    escolha=confirmaEscolha(escolha,"1-Criar\n2-Listar exames de um aluno\n3-Inscrever aluno em exame\n4-Inscrever aluno numa disciplina\n5-Cancelar inscrição de um aluno numa disciplina\n6-Listar Alunos\n7-Voltar\nEscolha:");
                    if(escolha==1){
                        nome = confirmaString(nome,"Nome");
                        mail=confirmaMail(mail);
                        numeroAluno=confirmaNumeroAluno(numeroAluno,alunos);
                        curso=confirmaCurso(curso,cursos);
                        anoMatricula=confirmaInt(anoMatricula,"Ano de matrícula:");
                        estatuto=confirmaEstatutoAluno(estatuto);
                        Aluno alunoAdicionar = new Aluno(nome,mail,numeroAluno,curso,anoMatricula,estatuto);
                        alunos.add(alunoAdicionar);
                        //adiciona o aluno nos alunos inscritos das disciplinas do curso que escolheu
                        for(int j=0;j<curso.getDisciplinas().size();j++){
                            curso.getDisciplinas().get(j).getInscritos().add(alunoAdicionar);
                            for(int k=0;k<disciplinas.size();k++){
                                if(curso.getDisciplinas().get(j).getNome().equals(disciplinas.get(k).getNome())){
                                    disciplinas.get(k).getInscritos().add(alunoAdicionar);
                                }
                            }
                        }
                        curso=null;
                        //depois de criado um novo aluno o ficheiro "alunos.bin" é actualizado
                        try{
                            fo.abreEscrita("alunos.bin");
                            fo.escreveObjecto(alunos);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        } 
                        //depois de inscrito nas disciplinas do respectivo curso o ficheiro "disciplinas.bin" é actualizado
                        try{
                            fo.abreEscrita("disciplinas.bin");
                            fo.escreveObjecto(disciplinas);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        }
                        try{
                            fo.abreEscrita("cursos.bin");
                            fo.escreveObjecto(cursos);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        } 
                    }
                    else if(escolha==2){
                        aluno=confirmaAluno(alunos,aluno,"Confirmar",exame);//confirma o aluno para o qual vão ser listados os seus exames
                        aluno.listarInscrito(exames);//lista os exames em que se ecnontra inscrito com recurso ao método listarInscrito da Classe Aluno
                        aluno=null;
                    }
                    else if(escolha==3){
                        aluno=confirmaAluno(alunos,aluno,"Confirmar",exame);//confirma o aluno que vai ser inscrito
                        exame=confirmaExame("Criar",exame,disciplina,data,hora,disciplinas,exames);//confirma o exame
                        exame.associaAluno(aluno);//inscreve o aluno desejado no exame desejado
                        aluno=null;//posto a null para não ficar com nenhum objecto do tipo Aluno guardado e estar sempre pronto a utilizar
                        exame=null;//posto a null para não ficar com nenhum objecto do tipo Exame guardado e estar sempre pronto a utilizar
                        //depois de o aluno ser inscrito no exame, o ficheiro "exames.bin" é actualizado
                        try{
                            fo.abreEscrita("exames.bin");
                            fo.escreveObjecto(exames);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        } 
                    }
                    else if(escolha==4){
                        aluno=confirmaAluno(alunos,aluno,"Confirmar",exame);//confirma o aluno 
                        disciplina=confirmaDisciplina(disciplina,disciplinas);//confirma a disciplina
                        disciplina.getInscritos().add(aluno);//inscreve o aluno desejado na disciplina desejada
                        aluno=null;//posto a null para não ficar com nenhum objecto do tipo Aluno guardado e estar sempre pronto a utilizar
                        disciplina=null;//posto a null para não ficar com nenhum objecto do tipo Disciplina guardado e estar sempre pronto a utilizar
                        //depois de inscrever o aluno na disciplina o ficheiro "disciplinas.bin" é actualizado
                        try{
                            fo.abreEscrita("disciplinas.bin");
                            fo.escreveObjecto(disciplinas);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        } 
                        
                        try{
                            fo.abreEscrita("exames.bin");
                            fo.escreveObjecto(exames);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        } 
                    }
                    
                    else if(escolha==5){
                        aluno=confirmaAluno(alunos,aluno,"Confirmar",exame);//confirma aluno
                        disciplina=confirmaDisciplina(disciplina,disciplinas);//confirma disciplina
                        disciplina.getInscritos().remove(aluno);//remove aluno dos alunos inscritos da disciplina
                        aluno=null;//posto a null para não ficar com nenhum objecto do tipo Aluno guardado e estar sempre pronto a utilizar
                        disciplina=null;//posto a null para não ficar com nenhum objecto do tipo Disciplina guardado e estar sempre pronto a utilizar
                        //depois de remover o aluno dos alunos inscritos da disciplina o ficheiro "disciplinas.bin" é actualizado
                        try{
                            fo.abreEscrita("disciplinas.bin");
                            fo.escreveObjecto(disciplinas);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        } 
                        
                        try{
                            fo.abreEscrita("exames.bin");
                            fo.escreveObjecto(exames);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        } 
                    }
                    else if(escolha==6){
                        //lista os alunos existentes
                        System.out.println("Alunos:");
                        for(i=0;i<alunos.size();i++){
                            System.out.println(alunos.get(i));
                        }
                    }
                    else if(escolha==7){
                        break;
                    }
                }
            }
            else if(escolha==3){
                while(true){
                    escolha=confirmaEscolha(escolha,"1-Criar\n2-Listar exames de um funcionário\n3-Associar funcionário a um exame\n4-Listar Funcionários\n5-Voltar\nEscolha:");
                    if(escolha==1){
                        while(true){
                            escolha=confirmaEscolha(escolha,"1-Docente\n2-Não Docente\n3-Voltar\nEscolha:");
                            if(escolha==1){
                                criaFuncionario(0,nome,mecanografico,funcionarios,mail,categoria,areaCargo,fo); 
                            }
                            else if(escolha==2){
                                criaFuncionario(1,nome,mecanografico,funcionarios,mail,categoria,areaCargo,fo);
                            }
                            
                            else if(escolha==3){
                                break;
                            }
                        }
                    }
                    
                    else if(escolha==2){
                        funcionario=confirmaFuncionarios(funcionarios,funcionario);//confirma o fucionário para o qual vão ser listados os seus exames
                        funcionario.listarEnvolvidos(exames);//lista os exames do funcionário desejado com recurso ao método listarEnvolvidos da Classe Funcionário
                        funcionario=null;//posto a null para não ficar com nenhum objecto do tipo Funcionario guardado e estar sempre pronto a utilizar
                    }
                    
                    else if(escolha==3){
                        funcionario=confirmaFuncionarios(funcionarios,funcionario);//confirma funcionário
                        exame=confirmaExame("Criar",exame,disciplina,data,hora,disciplinas,exames);//confirma exame
                        exame.associaFuncionario(funcionario, exames,exame.getData(),exame.getDuracao());//associa o funcionário desejado ao exame desejado
                        funcionario=null;//posto a null para não ficar com nenhum objecto do tipo Funcionário guardado e estar sempre pronto a utilizar
                        exame=null;//posto a null para não ficar com nenhum objecto do tipo Exame guardado e estar sempre pronto a utilizar
                        //depois de asscoiar o funcionário desejado ao exame desejado o ficheiro "exames.bin" é actualizado
                        try{
                            fo.abreEscrita("exames.bin");
                            fo.escreveObjecto(exames);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        }
                    }
                    
                    else if(escolha==4){
                        //lista os funcionários existentes
                        for (Funcionario funcionario1 : funcionarios) {
                            System.out.println(funcionario1);
                        }
                    }
                    
                    else if(escolha==5){
                        break;
                    }
                }
            }
            
            else if(escolha==4){
                while(true){
                    escolha=confirmaEscolha(escolha,"1-Criar\n2-Listar Salas\n3-Associar sala a exame\n4-Voltar\nEscolha:");
                    if(escolha==1){
                        nome = confirmaNomeSala(nome,salas,"Criar");//confirma o nome da sala com recurso ao método confirmaNomeSala
                        lotacao=confirmaInt(lotacao,"Lotação:");//confirma a lotação da sala com recurso ao método confirmaInt 
                        Sala sala = new Sala(nome,lotacao);
                        salas.add(sala);
                        //depois de criada a salas o ficheiro salas.txt é actualizado
                        FileWriter fw = new FileWriter("salas.txt");
                        try (BufferedWriter fwt = new BufferedWriter(fw)) {
                            for (Sala sala1 : salas) {
                                fwt.write(String.format("%s-%s\n", sala1.getNome(), sala1.getLotacao()));
                                fwt.flush();
                            }
                        }
                    }
                    else if(escolha==2){
                        //listagem das salas existentes
                        System.out.println("Salas");
                        for (Sala sala : salas) {
                            System.out.println(sala.toString());
                        }
                    }
                    else if(escolha==3){
                        //associar uma sala a um dado exame
                        ArrayList<Sala> salasAssociar = new ArrayList<>();
                        System.out.println("Exame");
                        exame=confirmaExame("Criar",exame,disciplina,data,hora,disciplinas,exames);
                        System.out.println("Salas");
                        salasAssociar = confirmaSalas(salas,salasAssociar,exames,exame.getData(),exame.getDuracao());
                        for(int k=0;k<salasAssociar.size();k++){
                            exame.getSala().add(salasAssociar.get(k));
                        }
                        exame=null;
                        try{
                            fo.abreEscrita("exames.bin");
                            fo.escreveObjecto(cursos);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        }
                    }
                    else if(escolha==4){
                        break;
                    }
                } 
            }
            
            else if(escolha==5){
                while(true){
                    escolha=confirmaEscolha(escolha,"1-Criar\n2-Adicionar disciplina a curso\n3-Remover disciplina a curso\n4-Listar Cursos\n5-Voltar\nEscolha:");
                    if(escolha==1){
                        ArrayList<Disciplina> disciplinasDoCurso = new ArrayList<>();
                        nome = confirmaString(nome,"Curso:");
                        duracaoCurso = confirmaInt(duracaoCurso,"Duração:");//confirma a duração do curso com recurso ao método confirmaInt
                        grau = confirmaGrau(grau);//confirma o grau do curso com recurso ao método confirmaGrau
                        numDisc=confirmaInt(numDisc,"Número de Disciplinas:");
                        for(int j=0;j<numDisc;j++){
                            disciplina = confirmaDisciplina(disciplinas,disciplina);//confirma tantas vezes quanto o número de disciplinas do curso
                            disciplinasDoCurso.add(disciplina);
                            disciplina=null;//posto a null para não ficar com nenhum objecto do tipo Disciplina guardado e estar sempre pronto a utilizar
                        }
                        
                        Curso cursoadicionar = new Curso(nome,duracaoCurso,grau,disciplinasDoCurso);
                        cursos.add(cursoadicionar);
                        //depois de criado o curso o ficheiro "cursos.bin" é actualizado
                        try{
                            fo.abreEscrita("cursos.bin");
                            fo.escreveObjecto(cursos);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        }
                    }
                    if(escolha==2){
                        curso=confirmaCurso(curso,cursos);//confirma o curso
                        disciplina=confirmaDisciplina(disciplina,disciplinas);//confirma a disciplina que vai ser adicionada ao curso desejado
                        curso.getDisciplinas().add(disciplina);//adiciona a disciplina às disciplinas do curso desejado
                        for (Aluno aluno1 : alunos) {
                            if (aluno1.getCurso().getNome().equals(curso.getNome())) {//inscreve os alunos que se encontram inscritos no curso na nova disciplina
                                disciplina.getInscritos().add(aluno1);
                            }
                        }
                        curso=null;//posto a null para não ficar com nenhum objecto do tipo Curso guardado e estar sempre pronto a utilizar
                        disciplina=null;//posto a null para não ficar com nenhum objecto do tipo Disciplina guardado e estar sempre pronto a utilizar
                        //depois de adicionada a disciplina desejada ao curso desejada o ficheiro "cursos.bin" é actualizado
                        try{
                            fo.abreEscrita("cursos.bin");
                            fo.escreveObjecto(cursos);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        }
                    }
                    
                    else if(escolha==3){
                        curso=confirmaCurso(curso,cursos);//confirma o curso
                        disciplina=confirmaDisciplina(disciplina,disciplinas);//confirma a disciplina que vai ser removida do curso desejado
                        curso.getDisciplinas().remove(disciplina);//remove a disciplina das disciplinas do curso desejado
                        for (Aluno aluno1 : alunos) {
                            if (aluno1.getCurso().getNome().equals(curso.getNome())) {//remove os alunos que se encontram inscritos no curso da disciplina que foi removida
                                disciplina.getInscritos().remove(aluno1);
                            }
                        }
                        curso=null;//posto a null para não ficar com nenhum objecto do tipo Curso guardado e estar sempre pronto a utilizar
                        disciplina=null;//posto a null para não ficar com nenhum objecto do tipo Disciplina guardado e estar sempre pronto a utilizar
                        //depois de removida a disciplina desejada do curso desejado o ficheiro "cursos.bin" é actualizado
                        try{
                            fo.abreEscrita("cursos.bin");
                            fo.escreveObjecto(cursos);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        }
                    }
                    else if(escolha==4){
                        //lista todos os cursos existentes
                        System.out.println("Cursos");
                        for (Curso curso1 : cursos) {
                            System.out.println(curso1);
                        }
                    }
                    else if(escolha==5){
                        break;
                    }
                }
                
            }
            
            else if(escolha==6){
                while(true){
                    escolha=confirmaEscolha(escolha,"1-Criar\n2-Listar Disciplinas\n3-Alterar docente responsável\n4-Alterar docentes\n5-Voltar\nEscolha:");
                    if(escolha==1){
                        Data data2 = null;//utilizado apenas por parâmetro do método confirmaRegente
                        Data data3 =null;//utilizado apenas por parâmetro do método confirmaRegente
                        ArrayList<Aluno> inscritosNaDisciplina = new ArrayList<>();
                        nome = confirmaString(nome,"Disciplina:");
                        docente=confirmaRegente(funcionarios,docentesExame,docente,"Número Mecanográfico do Docente Responsável:",exames,data2,data3,"Disciplina");
                        docentesExame=confirmaDocentes(funcionarios,docentesExame,exames,data2,data3,"");
                        Disciplina disciplinaAdicionar = new Disciplina(nome,docente,docentesExame,inscritosNaDisciplina);
                        disciplinas.add(disciplinaAdicionar);
                        docente=null;//posto a null para nao ficar com nenhum objecto do tipo Docente guardado e estar sempre pronto a utilizar
                        //depois de criada a disciplina o ficheiro "disciplinas.bin" é actualizado
                        try{
                            fo.abreEscrita("disciplinas.bin");
                            fo.escreveObjecto(disciplinas);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        }
                    }
                    
                    else if(escolha==2){
                        //lista as disciplinas existentes
                        System.out.println("Disciplinas");
                        for (Disciplina disciplina1 : disciplinas) {
                            System.out.println(disciplina1);
                        }
                    }
                    
                    else if(escolha==3){
                        Data data2 = null;//utilizado apenas por parâmetro do método confirmaRegente
                        Data data3 =null;//utilizado apenas por parâmetro do método confirmaRegente
                        disciplina=confirmaDisciplina(disciplina,disciplinas);//confirma a disciplina em que vai ser alterado o docente responsável
                        docente=confirmaRegente(funcionarios,docentesExame,docente,"Número Mecanográfico do Novo Docente Responsável:",exames,data2,data3,"Disciplina");//confrima o novo docente responsável
                        disciplina.setResponsavel(docente);//altera o docente responsável da disciplina desejada para o novo docente responsável introduzido
                        disciplina=null;//posto a null para nao ficar com nenhum objecto do tipo Disciplina guardado e estar sempre pronto a utilizar
                        docente=null;//posto a null para nao ficar com nenhum objecto do tipo Docente guardado e estar sempre pronto a utilizar
                        //depois de alterado o docente responsável da disciplina desejada o ficheiro "disciplinas.bin" é actualizado
                        try{
                            fo.abreEscrita("disciplinas.bin");
                            fo.escreveObjecto(disciplinas);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        }
                        try{
                            fo.abreEscrita("exames.bin");
                            fo.escreveObjecto(exames);
                            fo.fechaEscrita();
                        }
                        catch (Exception c) {
                            System.out.println("Ocorreu um erro " + c);
                    
                        }
                        
                    }
                    
                    else if(escolha==4){
                        while(true){
                            escolha=confirmaEscolha(escolha,"1-Adiconar docente\n2-Remover docente\n3-VoltarEscolha:");
                            if(escolha==1){
                                Data data2 = null;//utilizado apenas por parâmetro do método confirmaRegente
                                Data data3 =null;//utilizado apenas por parâmetro do método confirmaRegente
                                disciplina=confirmaDisciplina(disciplina,disciplinas);//confirma a disciplina em que vai ser adicionado um docente
                                docente=confirmaRegente(funcionarios,docentesExame,docente,"Número Mecanográfico do Docente:",exames,data2,data3,"Disciplina");//confirma o docente a adicionar à disciplina
                                disciplina.getDocentes().add(docente);//adiciona o docente aos docentes da disciplina desejada
                                disciplina=null;//posto a null para nao ficar com nenhum objecto do tipo Disciplina guardado e estar sempre pronto a utilizar
                                docente=null;//posto a null para nao ficar com nenhum objecto do tipo Docente guardado e estar sempre pronto a utilizar
                                //depois de adicionado o docente pretendido à disciplina desejada o ficheiro "disciplinas.bin" é actualizado
                                try{
                                    fo.abreEscrita("disciplinas.bin");
                                    fo.escreveObjecto(disciplinas);
                                    fo.fechaEscrita();
                                }
                                catch (Exception c) {
                                    System.out.println("Ocorreu um erro " + c);

                                }
                                try{
                                    fo.abreEscrita("exames.bin");
                                    fo.escreveObjecto(exames);
                                    fo.fechaEscrita();
                                }
                                catch (Exception c) {
                                    System.out.println("Ocorreu um erro " + c);

                                }
                            }
                            
                            else if(escolha==2){
                                Data data2 = null;//utilizado apenas por parâmetro do método confirmaRegente
                                Data data3 =null;//utilizado apenas por parâmetro do método confirmaRegente
                                disciplina=confirmaDisciplina(disciplina,disciplinas);//confirma a disciplina em que vai ser removido um docente
                                docente=confirmaRegente(funcionarios,docentesExame,docente,"Nome do Docente:",exames,data2,data3,"Disciplina");
                                disciplina.getDocentes().remove(docente);//remove o docente dos docentes da disciplina desejada
                                disciplina=null;//posto a null para nao ficar com nenhum objecto do tipo Disciplina guardado e estar sempre pronto a utilizar
                                docente=null;//posto a null para nao ficar com nenhum objecto do tipo Docente guardado e estar sempre pronto a utilizar
                                //depois de removido o docente pretendido da disciplina desejada o ficheiro "disciplinas.bin" é actualizado
                                try{
                                    fo.abreEscrita("disciplinas.bin");
                                    fo.escreveObjecto(disciplinas);
                                    fo.fechaEscrita();
                                }
                                catch (Exception c) {
                                    System.out.println("Ocorreu um erro " + c);

                                }
                                try{
                                    fo.abreEscrita("exames.bin");
                                    fo.escreveObjecto(exames);
                                    fo.fechaEscrita();
                                }
                                catch (Exception c) {
                                    System.out.println("Ocorreu um erro " + c);

                                }
                            }
                            
                            else if(escolha==3){
                                break;
                            }
                        }
                    }
                    
                    else if(escolha==5){
                        break;
                    }
                }
            }
            
            else if(escolha==7){
                break;
            }
            
        }
    }
    
}
