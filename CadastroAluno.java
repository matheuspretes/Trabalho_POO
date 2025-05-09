import java.util.Random;
import java.util.Scanner;

public class CadastroAluno {
    
    public static void init(Aluno[] alunos , Disciplina[] disciplinas){
        Aluno a = new Aluno();
        a.nome = "Mateus";
        a.cod = 1;
        a.endereco = "Rua cabsugjbed, No. 17";
        a.DisMatriculado = "POO";
        a.NotasDis = 7;
        insercaoAluno(alunos, a);
        a = new Aluno();
        a.nome = "BJHCH";
        a.cod = 2;
        a.endereco = "Rua dos Bobos, No. 0";
        a.DisMatriculado = "POO";
        a.NotasDis = 0;
        insercaoAluno(alunos, a);
        a = new Aluno();
        a.nome = "AAAAAA";
        a.cod = 1;
        a.endereco = "Rua lettuce, No. 5";
        a.DisMatriculado = "POO";
        a.NotasDis = 5;
        insercaoAluno(alunos, a);

        Disciplina d = new Disciplina();
        d.cod = 0;
        d.nome = "POO";
        d.ano = 2025;
        d.nomeProf = "Luciano";
        insercaoDiscip(disciplinas, d);
    }
    menu(disciplinas, alunos);
}
public static boolean insercaoAluno(Aluno[] alunos, Aluno a){
    if (alunos != null && a != null){
        for (int i = 0; i < alunos.length; i++){
            if (alunos[i] == null){
                alunos[i] = a;
                return true;
            }
        }
    }
    return false;
}
public static boolean insercaoDiscip(Disciplina[] discips, Disciplina d){
    if (discips != null && d != null){
        for (int i = 0; i < discips.length; i++){
            if (discips[i] == null){
                discips[i] = d;
                return true;
            }
        }
    }
    return false;
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

public static boolean AlterarAluno(Aluno[] alunos, Disciplina[] disciplinas){
    boolean teste = false;
    for (int i = 0; i < alunos.length; i++){
        if (alunos[i] == null){
            int j = i;
            i = alunos.length;
        } else{
            int j = alunos.length;
        }
    }
    System.out.println("Qual informação você quer modificar?");
    System.out.println("Digite 1 para mudar: NOME");
    System.out.println("Digite 2 para mudar: ENDEREÇO");
    System.out.println("Digite 3 para mudar: DISCIPLINAS MATRICULADAS");
    System.out.println("Digite 4 para mudar: NOTAS");
    Scanner scn = new Scanner(System.in);
    int opcao = scn.nextInt();
}

    public static void menu(Disciplina[] disciplinas, Aluno[] alunos) {

        System.out.println("-------------- Menu -------------");
            System.out.println("1: Cadastrar Disciplina");
            System.out.println("2: Remover Disciplina");
            System.out.println("3: Listar Disciplinas");
            System.out.println("4: Cadastrar Aluno");
            System.out.println("5: Alterar dados - Aluno");
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
        if (opcao == 5) {
            AlterarAluno(alunos, disciplinas);
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
