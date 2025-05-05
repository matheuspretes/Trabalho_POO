import java.util.Random;
import java.util.Scanner;

public class CadastroAluno {
    
    public static void init(Aluno[] alunos , Disciplina[] disciplinas){
        Random rnd = new Random();
        String[] nomesDisciplinas = {"MAT", "HIS", "POO"};
        String[] professores = {"Matheus", "Carla", "Gustavo"};
        String[] aluno = {"Carlos", "Lucas", "Pedro", "Luciano", "Mateus"};
        String[] enderecos = {"Rua 1", "Rua 2", "Rua 3"};
        String[] anos = {"2025", "2024", "2023"};

        int cont = 0;

        for (int i = 0; i < 3; i++){
            disciplinas[i].cod = i + 1;
            disciplinas[i].nome = nomesDisciplinas[rnd.nextInt(nomesDisciplinas.length)];
            disciplinas[i].ano = anos[rnd.nextInt(anos.length)];
            disciplinas[i].NomeProf = professores[rnd.nextInt(professores.length)];
            
        }


        for (int i = 0; i < 5; i++) {
            alunos[i].cod = i + 1;
            alunos[i].nome = aluno[rnd.nextInt(aluno.length)];
            if(i != 0){
            while(cont == 2){
                for(int j = 0; j < i; j++){
                    if (alunos[i].nome == alunos[j].nome) {
                        cont++;
                    }   
                }
                if(cont == 2){
                   alunos[i].nome = aluno[rnd.nextInt(aluno.length)];
                   cont = 0; 
                }  
            }
        }
            alunos[i].endereco = enderecos[rnd.nextInt(enderecos.length)];
            alunos[i].DisMatriculado = nomesDisciplinas[rnd.nextInt(nomesDisciplinas.length)];
            alunos[i].NotasDis = i + 1;
    }

        menu(disciplinas);

    }

   public static void  CadastrarDisciplina(Disciplina[] disciplina){
    int j = 0;
    int aux = 0;
    for (int i = 0; i < disciplina.length; i++) {
        if (disciplina[i].nome == null) {
            j = i;
            break;
        }
    }

    if (j == 0) {
        System.out.println("Limite de disciplinas atingido.");
        return;
    }

    if(aux == 0){
        Scanner scn = new Scanner(System.in);
        System.out.println("Cadastro de Nova Disciplina");
        System.out.print("Informe o Codigo ");
        disciplina[j].cod = scn.nextInt(); //não é pra ler o código, men, é autogerado... eu acho melhor só colocar o mesmo número que o do vetor, é até mais fácil de ler ;)
        scn.nextLine(); // limpar buffer

        System.out.print("Nome: ");
        disciplina[j].nome = scn.nextLine();

        System.out.print("Ano: ");
        disciplina[j].ano = scn.nextLine();

        System.out.print("Nome do Professor: ");
        disciplina[j].NomeProf = scn.nextLine();

        System.out.println("Disciplina cadastrada com sucesso!");
        System.out.println("Se quiser continuar, digite 0. Se não, digite 1 para sair");
        aux = scn.nextInt();
        while((aux < 0) ||(aux > 1) ){
            System.out.println("Número inválido...");
            aux = scn.nextInt();
        }
        
    }

    }

    public static void RemoverDisciplina(Disciplina[] disciplina) {
    int aux = 0;
    if(aux == 0){
        Scanner scn = new Scanner(System.in);
        System.out.print("Informe o código da disciplina a ser removida: ");
        int codigo = scn.nextInt();
    
        int encontrado = 0;
    
        for (int i = 0; i < disciplina.length; i++) {
            if (disciplina[i].nome != null && disciplina[i].cod == codigo) {
                // "Remove" limpando os dados
                disciplina[i] = new Disciplina(); // substitui por um novo objeto vazio
                encontrado = 1;
                System.out.println("Disciplina removida com sucesso!");
                break;
            }
        }
        if (encontrado == 0) {
            System.out.println("Disciplina não encontrada...");
            System.out.println("Se quiser continuar, digite 0. Se não, 1.");
             aux = scn.nextInt();
            while((aux < 0) ||(aux > 1) ){
                System.out.println("Número inválido...");
                aux = scn.nextInt();
            }

        }
    }    
}
public static void  ListaDisciplina(Disciplina[] disciplina){
    for (int i = 0; i < disciplina.length; i++) {
        if (disciplina[i].nome == null){
            i = disciplina.length;
            break;
        } else {
            System.out.println("Cód.     Disciplina     Ano     Professor");
            System.out.println(disciplina[i].cod + "     " + disciplina[i].nome + "     " + disciplina[i].ano + "     " + disciplina[i].NomeProf);
        }
    }
}
public static void  CadastrarAluno(Aluno[] alunos){
    int j = 0;
    int aux = 0;
    for (int i = 0; i < alunos.length; i++) {
        if (disciplina[i].nome == null) {
            j = i;
            break;
        }
    }

    if (j == 0) {
        System.out.println("Todas as vagas para alunos estão preenchidas...");
        return;
    }

    if(aux == 0){
        Scanner scn = new Scanner(System.in);

        alunos[j].cod = j;
        System.out.println("Cadastro de Aluno");
        System.out.print("Nome: ");
        alunos[j].nome = scn.nextLine();
        System.out.print("Endereço: ");
        alunos[j].endereco = scn.nextLine();
        System.out.println("Estudante cadastrado com sucesso!");
        System.out.println("Se quiser continuar, digite 0. Se não, digite 1 para sair");
        aux = scn.nextInt();
        while((aux < 0) ||(aux > 1) ){
            System.out.println("Número inválido...");
            aux = scn.nextInt();
        }
        
    }
}

    public static void menu(Disciplina[] disciplinas, Aluno[] alunos) {

        System.out.println("-------------- Menu -------------");
            System.out.println("1: Cadastrar Disciplina");
            System.out.println("2: Remover Disciplina");
            System.out.println("3: Listar Disciplinas");
            System.out.println("4: Cadastrar Aluno");
            System.out.println("5: Alterar dados - Aluno (em breve)");
            System.out.println("6: Listar os alunos - ordem de cadastro (em breve)");
            System.out.println("7: Listar os alunos - ordem de média  (em breve)");
            System.out.println("8: Matricular um Aluno (em breve)");
            System.out.println("9: Listar as matrículas (em breve)");
            System.out.println("0: Sair");
            System.out.print("Escolha uma opção: ");
        Scanner scn = new Scanner(System.in);
        int opcao = scn.nextInt();
        while ((opcao < 0) || (opcao > 5)) { //o 0 é preciso pra sair do menu
            System.out.print("Opcão inválida, digite novamente: ");
            opcao = scn.nextInt();
        }

        if (opcao == 1) {
            CadastrarDisciplina(disciplinas);
        }
        if (opcao == 2) {
            RemoverDisciplina(disciplinas);
        }
        if (opcao == 3) {
            ListaDisciplina(disciplinas);
        }
        if (opcao == 4) {
            CadastrarAluno(alunos);
        }

    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // inicialização do vetor Aluno com o registro
        Aluno[] alunos = new Aluno[30];
        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = new Aluno();
        }

        // inicialização do vetor de empresas com o registro
        Disciplina[] disciplinas = new Disciplina[10];
        for (int i = 0; i < disciplinas.length; i++) {
            disciplinas[i] = new Disciplina();
        }

        init( alunos, disciplinas);
        
}

//Registro
static class Aluno {
    int cod;
    String nome;
    String endereco;
    String DisMatriculado;
    double NotasDis;
}

static class Disciplina {
    int cod;
    String nome;
    String ano;
    String NomeProf;
}
}
