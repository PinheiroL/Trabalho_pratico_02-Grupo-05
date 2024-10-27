public class Instrutor extends Pessoa implements AvaliacaoFisica {

    private String especialidade;

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public Instrutor(int cpf, String nome, int idade, String RG, String endereco, String especialidade) {
        super(cpf, nome, idade, RG, endereco);
        setEspecialidade(especialidade);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Aluno: " + getNome() + ", Idade: " + getIdade() + ", Especialidade: " + especialidade);
    }

    @Override
    public void realizarAvaliacao() {

        System.out.println("Instrutor " + getNome() + " está realizando uma avaliação.");
    }

}
