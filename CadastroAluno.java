import java.util.Random;
import java.util.Scanner;

public class CadastroAluno {

    public static void init(Aluno[] alunos, Disciplina[] disciplinas) {
        Random rnd = new Random();
        String[] nomesDisciplinas = { "MAT", "HIS", "POO" };
        String[] professores = { "Matheus", "Carla", "Gustavo" };
        String[] aluno = { "Carlos", "Lucas", "Pedro", "Luciano", "Mateus" };
        String[] enderecos = { "Rua 1", "Rua 2", "Rua 3" };
        String[] anos = { "2025", "2024", "2023" };

        int cont = 0;

        for (int i = 0; i < 3; i++) {

        }

        for (int i = 0; i < 5; i++) {
            alunos[i].cod = i + 1;
            alunos[i].nome = aluno[rnd.nextInt(aluno.length)];
            if (i != 0) {
                while (cont == 2) {
                    for (int j = 0; j < i; j++) {
                        if (alunos[i].nome == alunos[j].nome) {
                            cont++;
                        }
                    }
                    if (cont == 2) {
                        alunos[i].nome = aluno[rnd.nextInt(aluno.length)];
                        cont = 0;
                    }
                    Aluno a = new Aluno();
                    a.nome = "Mateus";
                    a.cod = 1;
                    a.endereco = "Rua cabsugjbed";
                    a.DisMatriculado = "POO";
                    a.NotasDis = 7;
                    insercaoAluno(alunos, a);
                    a = new Aluno();
                    a.nome = "BJHCH";
                    a.cod = 2;
                    a.endereco = "Rua dos Bobos";
                    a.DisMatriculado = "POO";
                    a.NotasDis = 0;
                    insercaoAluno(alunos, a);
                    a = new Aluno();
                    a.nome = "AAAAAA";
                    a.cod = 1;
                    a.endereco = "Rua lettuce";
                    a.DisMatriculado = "POO";
                    a.NotasDis = 5;
                    insercaoAluno(alunos, a);

                    Disciplina d = new Disciplina();
                    d.cod = 0;
                    d.nome = "POO";
                    d.ano = 2025;
                    d.NomeProf = "Luciano";
                    insercaoDiscip(disciplinas, d);
                }
                menu(disciplinas, alunos);
            }
        }

    }

    public static boolean insercaoAluno(Aluno[] alunos, Aluno a) {
        if (alunos != null && a != null) {
            for (int i = 0; i < alunos.length; i++) {
                if (alunos[i] == null) {
                    alunos[i] = a;
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean insercaoDiscip(Disciplina[] discips, Disciplina d) {
        if (discips != null && d != null) {
            for (int i = 0; i < discips.length; i++) {
                if (discips[i] == null) {
                    discips[i] = d;
                    return true;
                }
            }
        }

        return false;
    }

    public static void CadastrarDisciplina(Disciplina[] disciplina) {
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

        if (aux == 0) {
            Scanner scn = new Scanner(System.in);
            System.out.println("Cadastro de Nova Disciplina");
            System.out.print("Informe o Codigo ");
            disciplina[j].cod = scn.nextInt(); // não é pra ler o código, men, é autogerado... eu acho melhor só colocar
                                               // o mesmo número que o do vetor, é até mais fácil de ler ;)
            scn.nextLine(); // limpar buffer

            System.out.print("Nome: ");
            disciplina[j].nome = scn.nextLine();

            System.out.print("Ano: ");
            disciplina[j].ano = scn.nextInt();

            System.out.print("Nome do Professor: ");
            disciplina[j].NomeProf = scn.nextLine();

            System.out.println("Disciplina cadastrada com sucesso!");
            System.out.println("Se quiser continuar, digite 0. Se não, digite 1 para sair");
            aux = scn.nextInt();
            while ((aux < 0) || (aux > 1)) {
                System.out.println("Número inválido...");
                aux = scn.nextInt();
            }

        }

    }

    public static void RemoverDisciplina(Disciplina[] disciplina) {
        int aux = 0;
        if (aux == 0) {
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
                while ((aux < 0) || (aux > 1)) {
                    System.out.println("Número inválido...");
                    aux = scn.nextInt();
                }

            }
        }
    }

    public static void ListaDisciplina(Disciplina[] disciplina) {
        for (int i = 0; i < disciplina.length; i++) {
            if (disciplina[i].nome == null) {
                i = disciplina.length;
                break;
            } else {
                System.out.println("Cód.     Disciplina     Ano     Professor");
                System.out.println(disciplina[i].cod + "     " + disciplina[i].nome + "     " + disciplina[i].ano
                        + "     " + disciplina[i].NomeProf);
            }
        }
    }

    public static void CadastrarAluno(Aluno[] alunos, Disciplina[] disciplina) {
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

        if (aux == 0) {
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
            while ((aux < 0) || (aux > 1)) {
                System.out.println("Número inválido...");
                aux = scn.nextInt();
            }

        }
    }

    public static void AlterarAluno(Aluno[] alunos, Disciplina[] disciplina) {
        int j = 0;
        int aux = 0;
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i].cod == 0) {
                j = i;
                break;
            }
        }

        Scanner scn = new Scanner(System.in);
        System.out.println("Cadastro de Aluno");
        System.out.print("Informe o código do aluno desejado: ");
        aux = scn.nextInt();
        boolean teste = false;
        for (int i = 0; i < j; i++) {
            if (alunos[i].cod == aux) {
                j = i;
                teste = true;
                break;
            }
        }
        if (teste = true) {
            int opcaoAlterar = 0;
            System.out.println("Informe o que deseja alterar:");
            System.out.println("Digite 1 para alterar - NOME");
            System.out.println("Digite 2 para alterar - ENDEREÇO");
            System.out.println("Digite 3 para alterar - DISCIPLINAS MATRICULADAS");
            System.out.println("Digite 4 para alterar - NOTAS");
            System.out.println("Digite 0 para sair");
            opcaoAlterar = scn.nextInt();
            while ((opcaoAlterar < 0) || (opcaoAlterar > 1)) {
                System.out.println("Número inválido...");
                opcaoAlterar = scn.nextInt();
            }
            if (opcaoAlterar == 1) {
                System.out.println("Informe o nome do estudante: ");
                alunos[j].nome = scn.nextLine();
            }
            if (opcaoAlterar == 2) {
                System.out.println("Informe o endereço do estudante: ");
                alunos[j].endereco = scn.nextLine();
            }
            if (opcaoAlterar == 3) {
                System.out.println("Informe as disciplinas matriculadas do estudante: ");
                alunos[j].DisMatriculado = scn.nextLine();
            }
            if (opcaoAlterar == 4) {
                System.out.println("Informe as notas do estudante: ");
                alunos[j].NotasDis = scn.nextInt();
            }
        } else {
            System.out.println("Código inválido...");
        }
    }

    public static void MatricularAluno(Aluno[] alunos, Disciplina[] disciplina) {
        int j = 0;
        int aux = 0;
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i].cod == 0) {
                j = i;
                break;
            }
        }

        Scanner scn = new Scanner(System.in);
        System.out.println("Cadastro de Aluno");
        System.out.print("Informe o código do aluno desejado: ");
        aux = scn.nextInt();
        boolean teste = false;
        for (int i = 0; i < j; i++) {
            if (alunos[i].cod == aux) {
                j = i;
                teste = true;
                break;
            }
        }
        if (teste = true) {
            System.out.println("Matrícula nova - DISCIPLINA");
            System.out.println("Informe o código da disciplina");
            int codNovo = scn.nextInt();
            int jNovo = 0;
            for (int i = 0; i < alunos.length; i++) {
                if (disciplina[i].cod == codNovo) {
                    jNovo = i;
                    break;
                }
            }
        } else {
            System.out.println("Código inválido...");
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
        while ((opcao < 0) || (opcao > 5)) { // o 0 é preciso pra sair do menu
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
            CadastrarAluno(alunos, disciplinas);
        }
        if (opcao == 5) {
            AlterarAluno(alunos, disciplinas);
        }
        if (opcao == 8) {
            MatricularAluno(alunos, disciplinas);
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

        init(alunos, disciplinas);

    }
}

// Registro

// Anotações
// equals compara o conteudo