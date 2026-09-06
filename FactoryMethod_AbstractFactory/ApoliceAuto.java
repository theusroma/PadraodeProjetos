public class ApoliceAuto extends Apolice{

    private double valorFipe;
    private int idadeCondutor;
    private int tempoHabilitacao;
    private double coberturaTerceiros;


    public ApoliceAuto(double valorFipe, int idadeCondutor, int tempoHabilitacao, double coberturaTerceiros){
        this.numeroApolice = "AUTO-" + numero;
        this.valorFipe = valorFipe;
        this.idadeCondutor = idadeCondutor;
        this.tempoHabilitacao = tempoHabilitacao;
        this.coberturaTerceiros = coberturaTerceiros;
    }

    @Override
    public double calcularPremio(){
        double premio = (0.08 * valorFipe) / 12; 

        if (idadeCondutor < 25){
            premio = premio + (premio * 0.3);
        }

        if (tempoHabilitacao <= 2){
            premio = premio + (premio * 0.2);
        }
        return premio;
    }

    @Override 
    public boolean validarCobertura(){
        
        if (coberturaTerceiros <= 50000) {
            return false;
        } else {
        return true;
        }
    }

    @Override 
    public String listarDocumentos(){
        return "Documentos exigidos: CNH CRLV e comprovante de residência";
    }; 
}
