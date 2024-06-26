package br.com.fiap.tech.challenge.domain.value_objects.enums;

public enum EStatusPagamento {
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    PAGO("Pago"),
    REJEITADO("Rejeitado");

    private final String descricao;

    EStatusPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
