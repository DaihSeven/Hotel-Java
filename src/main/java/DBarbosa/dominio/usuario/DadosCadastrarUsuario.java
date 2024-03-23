package DBarbosa.dominio.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarUsuario(
        // >> DTO "Data Transfer Object". É um padrão de design usado para transferir dados
        @NotBlank
        String nome,
        @Email
        String email,
        @NotBlank
        String senha
) {
}
