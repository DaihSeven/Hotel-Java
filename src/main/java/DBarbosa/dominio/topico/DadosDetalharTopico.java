package DBarbosa.dominio.topico;

public record DadosDetalharTopico(
        Long id,
        String titulo,
        String mensagem,
        String data,
        Boolean status,
        String autor ,
        String curso ) {

    public DadosDetalharTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
