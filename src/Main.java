import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Aluno> alunos = new ArrayList<>(); // Inicializa a lista de alunos
    private static List<Instrutor> instrutores = new ArrayList<>(); // Inicializa a lista de instrutores
    private static List<Equipamento> equipamentos = new ArrayList<>(); // Inicializa a lista de equipamentos

    public static void main(String[] args) {
        boolean menu = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo!");

        Aluno aluno = null;
        Instrutor instrutor = null;
        PlanoDeTreino planoDeTreino = null;

        while (menu) {
            System.out.println("\n=================================\n");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Instrutor");
            System.out.println("3. Exibir informações do Aluno");
            System.out.println("4. Cadastrar Treino");
            System.out.println("5. Exibir plano de treino do Aluno");
            System.out.println("6. Registrar pagamento");
            System.out.println("7. Cadastrar equipamento");
            System.out.println("8. Remover equipamento");
            System.out.println("9. Exibir lista de equipamentos");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Cadastrar Aluno
                    System.out.println("Digite o nome do aluno:");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("Digite o CPF do aluno:");
                    int cpfAluno = scanner.nextInt();
                    System.out.println("Digite a idade do aluno:");
                    int idadeAluno = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o RG do aluno:");
                    String rgAluno = scanner.nextLine();
                    System.out.println("Digite o endereço do aluno:");
                    String enderecoAluno = scanner.nextLine();

                    aluno = new Aluno(cpfAluno, nomeAluno, idadeAluno, rgAluno, enderecoAluno);
                    alunos.add(aluno); // Adiciona o aluno à lista
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    // Cadastrar Instrutor
                    System.out.println("Digite o nome do instrutor:");
                    String nomeInstrutor = scanner.nextLine();
                    System.out.println("Digite o CPF do instrutor:");
                    int cpfInstrutor = scanner.nextInt();
                    System.out.println("Digite a idade do instrutor:");
                    int idadeInstrutor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o RG do instrutor:");
                    String rgInstrutor = scanner.nextLine();
                    System.out.println("Digite o endereço do instrutor:");
                    String enderecoInstrutor = scanner.nextLine();
                    System.out.println("Digite a especialidade do instrutor:");
                    String especialidade = scanner.nextLine();

                    instrutor = new Instrutor(cpfInstrutor, nomeInstrutor, idadeInstrutor, rgInstrutor,
                            enderecoInstrutor, especialidade);
                    instrutores.add(instrutor); // Adiciona o instrutor à lista
                    System.out.println("Instrutor cadastrado com sucesso!");
                    break;

                case 3:
                    // Exibir informações do aluno pelo CPF
                    System.out.println("Digite o CPF do aluno:");
                    int cpfBusca = scanner.nextInt();
                    scanner.nextLine();

                    boolean alunoEncontrado = false; // Variável para verificar se o aluno foi encontrado

                    for (Aluno alunoa : alunos) {
                        if (alunoa.getCpf() == cpfBusca) {
                            alunoa.exibirInformacoes();
                            alunoEncontrado = true; // Aluno encontrado
                            break; // Sai do loop após encontrar o aluno
                        }
                    }

                    if (!alunoEncontrado) {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 4:
                    // Cadastrar treino
                    System.out.println("Digite o CPF do aluno:");
                    int cpf = scanner.nextInt();
                    scanner.nextLine();

                    aluno = null; // Variável para armazenar o aluno encontrado

                    // Buscar o aluno pelo CPF na lista de alunos
                    for (Aluno alunoa : alunos) {
                        if (alunoa.getCpf() == cpf) {
                            aluno = alunoa;
                            break; // Sai do loop ao encontrar o aluno
                        }
                    }

                    if (aluno != null && instrutor != null) {
                        System.out.println("Digite o nome do plano de treino:");
                        String nomePlano = scanner.nextLine();
                        System.out.println("Digite a quantidade de dias de treino na semana:");
                        int quantDias = scanner.nextInt();
                        scanner.nextLine();

                        // Cria o plano de treino e associa ao aluno encontrado
                        planoDeTreino = new PlanoDeTreino(instrutor, quantDias);
                        aluno.setPlanoDeTreino(planoDeTreino); // Associa o plano ao aluno encontrado

                        // Cadastra os treinos
                        for (int i = 1; i <= quantDias; i++) {
                            System.out.println("Digite as informações sobre o treino: ");
                            String descricao = scanner.nextLine();
                            System.out.println("Duração em minutos:");
                            int duracao = scanner.nextInt();
                            scanner.nextLine();

                            planoDeTreino.cadastrarTreino(descricao, duracao);
                        }

                        System.out.println("Treinos cadastrados com sucesso para o aluno: " + aluno.getNome());
                    } else {
                        if (aluno == null) {
                            System.out.println("Aluno não encontrado.");
                        } else {
                            System.out.println("Cadastre um instrutor primeiro.");
                        }
                    }
                    break;

                case 5:

                    // Exibir plano de treino
                    System.out.println("Digite o CPF do aluno:");
                    cpf = scanner.nextInt();
                    scanner.nextLine();

                    aluno = null; // Variável para armazenar o aluno encontrado

                    // Buscar o aluno pelo CPF na lista de alunos
                    for (Aluno alunoa : alunos) {
                        if (alunoa.getCpf() == cpf) {
                            aluno = alunoa; // Armazena o aluno encontrado
                            break; // Sai do loop ao encontrar o aluno
                        }
                    }

                    if (aluno != null) {
                        // Verifica se o aluno tem um plano de treino
                        PlanoDeTreino planoDeTreinoAluno = aluno.getPlanoDeTreino();
                        if (planoDeTreinoAluno != null) {
                            planoDeTreinoAluno.exibirPlano(); // Exibe o plano de treino do aluno
                        } else {
                            System.out
                                    .println("Nenhum plano de treino cadastrado para o aluno " + aluno.getNome() + ".");
                        }
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 6:
                    // Registrar pagamento

                    System.out.println("Digite o CPF do aluno:");
                    cpf = scanner.nextInt();
                    scanner.nextLine();

                    aluno = null; // Variável para armazenar o aluno encontrado

                    // Buscar o aluno pelo CPF na lista de alunos
                    for (Aluno alunoa : alunos) {
                        if (alunoa.getCpf() == cpf) {
                            aluno = alunoa; // Armazena o aluno encontrado
                            break; // Sai do loop ao encontrar o aluno
                        }
                    }

                    if (aluno != null) {
                        // Processar o pagamento do aluno encontrado
                        aluno.processarPagamento();
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 7:
                    // Cadastrar equipamento
                    System.out.println("Digite o nome do equipamento:");
                    String nomeEquipamento = scanner.nextLine();
                    System.out.println("Digite o tipo do equipamento:");
                    String tipoEquipamento = scanner.nextLine();
                    System.out.println("Digite a quantidade do equipamento:");
                    int quantidadeEquipamento = scanner.nextInt();
                    scanner.nextLine();

                    boolean existeEquipamento = false;
                    for (Equipamento eq : equipamentos) {
                        if (eq.getNome().equalsIgnoreCase(nomeEquipamento)) {
                            // Equipamento já existe, aumenta a quantidade
                            eq.setQuantidade(eq.getQuantidade() + quantidadeEquipamento);
                            existeEquipamento = true;
                            System.out.println("Quantidade atualizada para o equipamento existente.");
                            break;
                        }
                    }

                    if (!existeEquipamento) {
                        // Se não existe, cria um novo equipamento
                        Equipamento equipamento = new Equipamento(nomeEquipamento, tipoEquipamento,
                                quantidadeEquipamento);
                        equipamentos.add(equipamento);
                        System.out.println("Equipamento cadastrado com sucesso!");
                    }
                    break;

                case 8:
                    // Remover equipamento
                    System.out.println("Digite o nome do equipamento a ser removido:");
                    String nomeRemover = scanner.nextLine();
                    boolean encontrado = false;

                    for (Equipamento eq : equipamentos) {
                        if (eq.getNome().equalsIgnoreCase(nomeRemover)) {
                            System.out.println("Quantidade atual do equipamento: " + eq.getQuantidade());
                            System.out.println("Digite a quantidade a ser removida:");
                            int quantidadeRemover = scanner.nextInt();
                            scanner.nextLine();

                            if (quantidadeRemover >= eq.getQuantidade()) {
                                // Remove o equipamento se a quantidade é igual ou maior que o total
                                equipamentos.remove(eq);
                                System.out.println("Equipamento totalmente removido.");
                            } else {
                                // Apenas reduz a quantidade
                                eq.setQuantidade(eq.getQuantidade() - quantidadeRemover);
                                System.out.println("Quantidade do equipamento atualizada.");
                            }
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Equipamento não encontrado.");
                    }
                    break;

                case 9:
                    // Exibir lista de equipamentos
                    System.out.println("Lista de Equipamentos:");
                    for (Equipamento eq : equipamentos) {
                        eq.exibirInformacoes();
                        System.out.println("---------------------");
                    }
                    break;

                case 10:
                    // Encerrar progama
                    menu = false;
                    System.out.println("Encerrando o sistema.");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}
