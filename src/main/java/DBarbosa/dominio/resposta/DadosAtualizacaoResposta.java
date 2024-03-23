package DBarbosa.dominio.resposta;


import org.jetbrains.annotations.NotNull;

public record DadosAtualizacaoResposta(
        @NotNull
        Long id,
        String mensagem,
        Long id_usuario
) {
}
