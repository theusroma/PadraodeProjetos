public class EmissorResidencial extends EmissorDeApolice{

    private String numero;
    private double valorImovel;
    private boolean tipoImovel;
    private boolean escritura;
    private boolean contratoLocacao;

    public EmissorResidencial(String numero, double valorImovel, boolean tipoImovel, boolean escritura, boolean contratoLocacao){
        this.numero = numero;
        this.valorImovel = valorImovel;
        this.tipoImovel = tipoImovel;
        this.escritura = escritura;
        this.contratoLocacao = contratoLocacao;

    }


    @Override
        protected Apolice criarApolice(){
         return new ApoliceResidencial(numero, valorImovel, tipoImovel, escritura,  contratoLocacao);

    }
}