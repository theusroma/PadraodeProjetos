public class EmissorAuto extends EmissorDeApolice {

    // Variáveis que a ApoliceAuto precisa
    private String numero;
    private double valorFipe;
    private int idadeCondutor;
    private int tempoHabilitacao;
    private double coberturaTerceiros;

    // Construtor
    public EmissorAuto(String numero, double valorFipe, int idadeCondutor, int tempoHabilitacao, double coberturaTerceiros) {
        this.numero = numero;
        this.valorFipe = valorFipe;
        this.idadeCondutor = idadeCondutor;
        this.tempoHabilitacao = tempoHabilitacao;
        this.coberturaTerceiros = coberturaTerceiros;
    }

    @Override
    protected Apolice criarApolice() {
        
        return new Apolice(numero, valorFipe, idadeCondutor, tempoHabilitacao, coberturaTerceiros); 
    }
}