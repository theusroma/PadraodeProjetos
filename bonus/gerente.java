public class gerente extends funcionario {
    
    //regra de bonifica??o dos gerentes ? 15% do salario +2
    public int numeroDeFuncionariosGerenciados; 
    
    @Override
    public double getBonificacao(){
        double bonus_base = super.getBonificacao();
        double bonus_adicional = 0.2 * this.numeroDeFuncionariosGerenciados;
        return bonus_base + bonus_adicional;
    }
}
