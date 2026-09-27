    // 1. PRODUTO ABSTRATO
public abstract class Notificacao {
    private String mensagem;
    private String destinatario;

    public Notificacao(String mensagem, String destinatario) {
        this.mensagem = mensagem;
        this.destinatario = destinatario;
    }

    public String getMensagem() { return mensagem; }
    public String getDestinatario() { return destinatario; }

    // Métodos que CADA tipo de notificação terá que implementar do seu jeito
    public abstract boolean validar();
    public abstract void enviar();
}

// 2. PRODUTO CONCRETO 1 (E-mail)
public class NotificacaoEmail extends Notificacao {
    private String assunto;

    public NotificacaoEmail(String mensagem, String destinatario, String assunto) {
        super(mensagem, destinatario);
        this.assunto = assunto;
    }

    @Override
    public boolean validar() {
        // Regra do e-mail: precisa ter '@' no destinatário
        return getDestinatario() != null && getDestinatario().contains("@");
    }

    @Override
    public void enviar() {
        System.out.println("Enviando E-mail para " + getDestinatario() + " | Assunto: " + assunto);
    }
}

// 3. PRODUTO CONCRETO 2 (SMS)
public class NotificacaoSMS extends Notificacao {

    public NotificacaoSMS(String mensagem, String destinatario) {
        super(mensagem, destinatario);
    }

    @Override
    public boolean validar() {
        // Regra do SMS: destinatário (telefone) precisa ter pelo menos 10 dígitos
        return getDestinatario() != null && getDestinatario().length() >= 10;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando SMS para " + getDestinatario() + ": " + getMensagem());
    }
}



// 3. CRIADOR ABSTRATO
public abstract class GerenteNotificacoes {

    // ESTE É O FACTORY METHOD! (Método abstrato de criação)
    protected abstract Notificacao criarNotificacao();

    // ESTE É O FLUXO PADRÃO (O processo de negócio centralizado)
    public final void processarEnvio() {
        // Passo 1: Usa o Factory Method para obter a notificação
        Notificacao notificacao = criarNotificacao();

        // Passo 2 e 3: Validação genérica para qualquer notificação
        if (!notificacao.validar()) {
            System.out.println("❌ ERRO: Dados da notificação são inválidos. Envio cancelado.");
            return;
        }

        // Passo 4: Disparo do envio
        notificacao.enviar();

        // Passo 5: Log de sucesso
        System.out.println("✅ LOG: Processo concluído com sucesso.\n");
    }
}

// 4. CRIADORES CONCRETOS
public class GerenteEmail extends GerenteNotificacoes {
    private String mensagem;
    private String email;   
    private String assunto;

    public GerenteEmail(String mensagem, String email, String assunto) {
        this.mensagem = mensagem;
        this.email = email;
        this.assunto = assunto;
    }

    @Override
    protected Notificacao criarNotificacao() {
        // A única função do Criador Concreto é dar o 'new' no Produto Concreto correspondente!
        return new NotificacaoEmail(mensagem, email, assunto);
    }
}

public class GerenteSMS extends GerenteNotificacoes {
    private String mensagem;
    private String telefone;

    public GerenteSMS(String mensagem, String telefone) {
        this.mensagem = mensagem;
        this.telefone = telefone;
    }

    @Override
    protected Notificacao criarNotificacao() {
        return new NotificacaoSMS(mensagem, telefone);
    }
}