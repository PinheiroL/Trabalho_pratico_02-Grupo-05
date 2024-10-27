public class Equipamento {
    private String nome;
    private String grupoMuscular;
    private int quantidade;

    public Equipamento(String nome, String grupoMuscular, int quantidade) {
        setNome(nome);
        setGrupoMuscular(grupoMuscular);
        setQuantidade(quantidade);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("grupoMuscular: " + grupoMuscular);
        System.out.println("Quantidade: " + quantidade);
    }

}
