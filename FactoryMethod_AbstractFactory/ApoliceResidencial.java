public class ApoliceResidencial extends Apolice{


    private double valorImovel;
    private boolean tipoImovel;
    private boolean escritura;
    private boolean contratoLocacao;

    public ApoliceResidencial(String numero, double valorImovel, boolean tipoImovel, boolean escritura, boolean contratoLocacao){
        this.numeroApolice = "RES-" + numero;
        this.valorImovel = valorImovel;
        this.tipoImovel = tipoImovel;
        this.escritura = escritura;
        this.contratoLocacao = contratoLocacao;
    }

    @Override
    public double calcularPremio(){
        double premioMensal = (valorImovel * 0.015) / 12;

        if(tipoImovel == true){
            premioMensal = premioMensal + (premioMensal * 0.25);
        }
            return premioMensal;
    }


    @Override
    public boolean validarCobertura(){

        if(escritura == false && contratoLocacao == false){
            return false;
        } else {
            return true;
        }   

    }

    @Override
    public String listarDocumentos(){
        
        return "Escritura ou contrato de locação e comprovante de residência";

        

    }
}

//  A contratação exige a apresentação de escritura ou contrato de locação; sem esse documento, a contratação deve ser rejeitada





// o prêmio mensal corresponde a 1,5% do valor do imóvel ao ano,
// dividido por 12. Imóveis classificados como alto padrão recebem acréscimo de 25% sobre o
// prêmio anual. A contratação exige a apresentação de escritura ou contrato de locação; sem
// esse documento, a contratação deve ser rejeitada. Documentos exigidos: escritura ou contrato
// de locação e comprovante de residência