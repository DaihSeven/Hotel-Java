package DBarbosa.dominio.topico;


// >> DTO "Data Transfer Object". É um padrão de design usado para transferir dados
public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        String data,
        Boolean status,
        String autor,
        String curso
) {

    public DadosListagemTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getStatus(), topico.getAutor(), topico.getCurso());

    }

}
