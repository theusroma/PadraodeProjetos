public abstract class EmissorDeApolice {
    
    //ESSE é o famoso Factory Method!
    //Eu não sei qual apólice vou criar, as classes filhas que se virem pra me devolver uma
    protected abstract Apolice criarApolice();

    // Método principal que a Seguradora vai chamar
    public final void processarContratacao() {
        
        //Chamo o método fábrica. Ele vai me devolver uma Apolice (Auto, Vida, etc)
        Apolice apolice = criarApolice();
        
        //Valido a cobertura sem nem saber de qual tipo de apólice estou falando!
        if (apolice.validarCobertura()) {
            System.out.println("CONTRATAÇÃO APROVADA");
            System.out.println(apolice.gerarResumo()); 
        } else {
            System.out.println("CONTRATAÇÃO REJEITADA");
            System.out.println("Apólice: " + apolice.numeroApolice);
            System.out.println("Motivo: Cobertura mínima não atendida.");
        }
    }
}