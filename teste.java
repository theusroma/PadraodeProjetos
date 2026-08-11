public class teste {

    public static void main(String[] args){
        financeiro fin = new financeiro();
        gerente coord = new gerente();
        operador porteiro = new operador();

       

        coord.nome = "Araci Almeida";
        coord.salario = 10000;
        coord.numeroDeFuncionariosGerenciados = 10;
        fin.computa_bonus(coord);

        gerente coord1 = new gerente();
        coord1.nome = "Pedro de Lara";
        coord1.salario = 8000;
        coord1.numeroDeFuncionariosGerenciados = 5; 
        fin.computa_bonus(coord1);

        porteiro.nome = "Escobar";
        porteiro.salario = 1500;
        fin.computa_bonus(porteiro);



        System.out.println(fin.get_total_bonus());
        
    }
}