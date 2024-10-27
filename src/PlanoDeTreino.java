import java.util.ArrayList;
import java.util.List;

public class PlanoDeTreino {
    private Instrutor instrutor;
    private List<Treino> treinos;
    private int quantDias;

    public void setQuantDias(int quantDias) {
        if (quantDias > 0 && quantDias <= 7)
            this.quantDias = quantDias;

        else
            System.out.println(
                    "Informe a quantidade de treinos semanais, a quantidade informanada não é valida no perido de uma semana.");

    }

    public int getQuantDias() {
        return quantDias;
    }

    public PlanoDeTreino(Instrutor instrutor, int quantDias) {

        this.instrutor = instrutor;
        setQuantDias(quantDias);
        this.treinos = new ArrayList<>();
    }

    public void cadastrarTreino(String descricao, int duracaoMinutos) {
        if (treinos.size() < quantDias) {
            Treino treino = new Treino(descricao, duracaoMinutos);
            treinos.add(treino);
            System.out.println("Treino cadastrado: " + descricao + " - Duração: " + duracaoMinutos + " minutos.");
        } else {
            System.out.println("Número máximo de treinos para a semana já atingido.");
        }
    }

    public void exibirPlano() {
        System.out.println("Plano de treino feito pelo instrutor: " + instrutor.getNome());
        if (treinos.isEmpty()) {
            System.out.println("Nenhum treino cadastrado.");
        } else {
            int dia = 1;
            for (Treino treino : treinos) {
                System.out.println("Dia " + dia++ + ": " + treino.getDescricao() + " - Duração: "
                        + treino.getDuracaoMinutos() + " min");
            }
        }
    }
}