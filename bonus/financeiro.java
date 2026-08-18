public class financeiro {
    private double total_bonus = 0.0;

    public void computa_bonus(gerente gerente){
        this.total_bonus += gerente.getBonificacao();
    }

    public void computa_bonus(operador operador){
        this.total_bonus += operador.getBonificacao();
    }

    public void computa_bonus(funcionario funcionario){
        this.total_bonus += funcionario.getBonificacao();
    }

    public double get_total_bonus(){
        return this.total_bonus;
    }
    
}
