public abstract class Pessoa {

    private int cpf;
    private String nome;
    private int idade;
    private String RG;
    private String endereço;

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setRG(String rG) {
        RG = rG;
    }

    public String getRG() {
        return RG;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getEndereço() {
        return endereço;
    }

    public Pessoa(int cpf, String nome, int idade, String RG, String endereco) {
        setNome(nome);
        setCpf(cpf);
        setIdade(idade);
        setRG(RG);
        setEndereço(endereco);
    }

    // Método abstrato a ser implementado nas subclasses
    public abstract void exibirInformacoes();

}
