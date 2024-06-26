package br.com.fiap.tech.challenge.domain.value_objects.models;

import br.com.fiap.tech.challenge.infrastucture.exceptions.CustomErrorTypeException;
import lombok.Data;

@Data
public class CPF {
    private final String valor;

    public CPF(String valor) throws CustomErrorTypeException {
        this.valor = valor;
        if (!this.validaCPF()) {
            throw new CustomErrorTypeException("CPF inválido");
        }
    }

    public String getValor() {
        return valor;
    }

    private boolean validaCPF() {
        if (valor == null || valor.length() != 11) return false;

        int soma = 0;
        int resto;

        try {
            for (int i = 1; i <= 9; i++) {
                soma += Integer.parseInt(valor.substring(i - 1, i)) * (11 - i);
            }

            resto = (soma * 10) % 11;
            if (resto == 10 || resto == 11) resto = 0;
            if (resto != Integer.parseInt(valor.substring(9, 10))) return false;

            soma = 0;
            for (int i = 1; i <= 10; i++) {
                soma += Integer.parseInt(valor.substring(i - 1, i)) * (12 - i);
            }

            resto = (soma * 10) % 11;
            if (resto == 10 || resto == 11) resto = 0;
            if (resto != Integer.parseInt(valor.substring(10, 11))) return false;

        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
