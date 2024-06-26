package br.com.fiap.tech.challenge.domain.value_objects.enums;

public enum EStatus {
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado");

    private final String descricao;

    EStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}