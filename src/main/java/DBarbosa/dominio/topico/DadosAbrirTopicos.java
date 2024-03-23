package DBarbosa.dominio.topico;

import jakarta.validation.constraints.NotBlank;


public class DadosAbrirTopicos{
        // >> DTO "Data Transfer Object". É um padrão de design usado para transferir dados
        @NotBlank
        String titulo;
        @NotBlank
        String mensagem;
        @NotBlank
        String autor;
        @NotBlank
        String curso;
}
