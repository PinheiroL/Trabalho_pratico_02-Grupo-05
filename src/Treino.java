public class Treino {
    private String descricao;
    private int duracaoMinutos;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public Treino(String descricao, int duracaoMinutos) {
        setDescricao(descricao);
        setDuracaoMinutos(duracaoMinutos);
    }

    public void iniciarTreino() {
        System.out.println("Iniciando treino: " + descricao);
    }
}
