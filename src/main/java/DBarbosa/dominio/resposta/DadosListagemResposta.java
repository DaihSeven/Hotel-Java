package DBarbosa.dominio.resposta;

public record DadosListagemResposta(
        Long id,
        String mensagem,
        Long id_usuario
) {

    public DadosListagemResposta(Res resposta){
        this(resposta.getId(), resposta.getMensagem(), resposta.getId_usuario());

    }


}
