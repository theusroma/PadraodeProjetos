public abstract class Apolice {
    
    protected String numeroApolice;
    
    //TODA tem esses
    public abstract double calcularPremio();
    public abstract boolean validarCobertura();
    public abstract String listarDocumentos();
    
    //rnf03 resumo que junta as infos
    public String gerarResumo() {
    // String status;
    
    // if (validarCobertura()) {
    //     status = "Aprovada";
    // } else {
    //     status = "Rejeitada";
    // }

    return "Apolice: " + numeroApolice + "\n" +
            "Premio mensal: R$ " + String.format("%.2f", calcularPremio()) + "\n" +
            "Documentos exigidos: " + listarDocumentos() + "\n" +
            "Status da Cobertura: " + (validarCobertura() ? "Aprovada" : "Rejeitada"); //usando operador ternario
            // "Status Cobertura: " + (validarCobertura())+ "\n";
    }
}