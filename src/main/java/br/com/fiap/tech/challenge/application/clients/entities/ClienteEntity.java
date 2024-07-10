package br.com.fiap.tech.challenge.application.clients.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class ClienteEntity {

    @Id
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 caracteres sem pontos ou hifens")
    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;
}
