// 1. PRODUTO ABSTRATO
public abstract class Pagamento {
    private double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public double getValor() { return valor; }

    // Métodos de contrato que você definiu
    public abstract boolean validar();
    public abstract void simular();
}

// 2. PRODUTOS CONCRETOS
public class PagamentoPix extends Pagamento {
    private String chavePix;

    public PagamentoPix(double valor, String chavePix) {
        super(valor);
        this.chavePix = chavePix;
    }

    @Override
    public boolean validar() {
        return chavePix != null && !chavePix.isBlank();
    }

    @Override
    public void simular() {
        double valorComDesconto = getValor() * 0.90; // 10% de desconto
        System.out.printf("Pix gerado [Chave: %s] | Valor original: R$ %.2f | Com desconto: R$ %.2f%n",
                chavePix, getValor(), valorComDesconto);
    }
}

public class PagamentoCartao extends Pagamento {
    private String numeroCartao;

    public PagamentoCartao(double valor, String numeroCartao) {
        super(valor);
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean validar() {
        return numeroCartao != null && numeroCartao.length() == 16;
    }

    @Override
    public void simular() {
        System.out.printf("Transação de R$ %.2f aprovada no cartão final %s.%n",
                getValor(), numeroCartao.substring(12));
    }
}

public class PagamentoBoleto extends Pagamento {

    public PagamentoBoleto(double valor) {
        super(valor);
    }

    @Override
    public boolean validar() {
        return getValor() >= 10.0; // Valor mínimo R$ 10,00
    }

    @Override
    public void simular() {
        System.out.printf("Boleto emitido no valor de R$ %.2f com vencimento para 3 dias úteis.%n", getValor());
    }
}



public class PagamentoCripto extends Pagamento {
    private String login;
    private String senha;

    public PagamentoCripto(double valor, String login, String senha) {
        super(valor);
        this.login = login;
        this.senha = senha;

    }

    @Override
    public boolean validar() {
        return login != null && senha rtao.length() <   = 4 ;
    }

    @Override
    public void simular() {
        System.out.printf("Valor disponível: R$ %.2f", getValor());
    }
}               

// 3. CRIADOR ABSTRATO
public abstract class GerentePagamentos {

    // ESTE É O FACTORY METHOD (Método Fábrica Abstrato)
    protected abstract Pagamento criarPagamento();

    // FLUXO PADRÃO DE PROCESSAMENTO (Algoritmo central da superclasse)
    public final void processarPagamento() {
        // Passo 1: Obtém o pagamento via Factory Method
        Pagamento pagamento = criarPagamento();

        // Passo 2: Executa a validação
        if (!pagamento.validar()) {
            System.out.println("❌ Processamento cancelado: Dados do pagamento inválidos.\n");
            return;
        }

        // Passo 3: Executa a simulação/processamento
        pagamento.simular();

        // Passo 4: Registro de log e comprovante padronizados
        System.out.println("LOG AUDITORIA: Transação registrada com sucesso.");
        System.out.println("COMPROVANTE: Enviado para o e-mail do cliente.\n");
    }
}

// 4. CRIADORES CONCRETOS
public class GerentePix extends GerentePagamentos {
    private double valor;
    private String chavePix;

    public GerentePix(double valor, String chavePix) {
        this.valor = valor;
        this.chavePix = chavePix;
    }

    @Override
    protected Pagamento criarPagamento() {
        return new PagamentoPix(valor, chavePix);
    }
}

public class GerenteCartao extends GerentePagamentos {
    private double valor;
    private String numeroCartao;

    public GerenteCartao(double valor, String numeroCartao) {
        this.valor = valor;
        this.numeroCartao = numeroCartao;
    }

    @Override
    protected Pagamento criarPagamento() {
        return new PagamentoCartao(valor, numeroCartao);
    }
}

public class GerenteBoleto extends GerentePagamentos {
    private double valor;

    public GerenteBoleto(double valor) {
        this.valor = valor;
    }

    @Override
    protected Pagamento criarPagamento() {
        return new PagamentoBoleto(valor);
    }
}

public class GerenteCripto extends GerentePagamentos {
    private double valor;
    private String login;
    private String senha;

    public GerenteCripto(double valor, String login, String senha){
        this.valor = valor;
        this.login = login;
        this.senha = senha;
    }

    @Override
    protected Pagamento criarPagamento(){
        return new PagamentoCripto(valor, login, senha);;
    }

}



    public class Main {
        public static void main(String[] args) {
            //pagamento cartao
            GerentePagamentos gerente1 = new PagamentoCartao(500, "323232");
            gerente1.processarPagamento(); // Executa todo o fluxo padrão!

            // pagamento cripto
            GerentePagamentos gerente2 = new PagamentoCripto(777, "theusroma", "password");
            gerente2.processarPagamento();
        }
    }