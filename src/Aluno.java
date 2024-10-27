import java.util.Set;

public class Aluno extends Pessoa implements Pagamento {

    private String FichaDeTreino;
    private boolean mensalidade;
    private PlanoDeTreino planoDeTreino;

    public void setFichaDeTreino(String fichadetreino) {
        this.FichaDeTreino = fichadetreino;
        ;
    }

    public String getFichaDeTreino() {
        return FichaDeTreino;
    }

    public void setMensalidade(boolean mensalidade) {
        this.mensalidade = mensalidade;
    }

    public boolean getMensalidade() {
        return mensalidade;
    }

    public void setPlanoDeTreino(PlanoDeTreino planoDeTreino) {
        this.planoDeTreino = planoDeTreino;
    }

    public PlanoDeTreino getPlanoDeTreino() {
        return planoDeTreino;
    }

    public Aluno(int cpf, String nome, int idade, String RG, String endereco) {
        super(cpf, nome, idade, RG, endereco);

    }

    @Override
    public void exibirInformacoes() {
        // TODO Auto-generated method stub
        System.out.println("Aluno: " + getNome() + ", Idade: " + getIdade() + ", CPF: " + getCpf());
    }

    @Override
    public void processarPagamento() {
        System.out.println("Pagamento processado para o aluno: " + getNome());
        setMensalidade(true);
    }

}
