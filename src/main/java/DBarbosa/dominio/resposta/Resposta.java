package DBarbosa.dominio.resposta;

@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Mapeia a tabela topicos do banco de dados
    private Long id;
    private String mensagem;
    private Long id_usuario;

    public Resposta(DadosCriarRespota dados){

        this.mensagem = dados.mensagem();
        this.id_usuario = dados.id_usuario();

    }

    public void atualizarInformacoes(DadosAtualizacaoResposta dados) {

        if(dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }

        if(dados.id_usuario() != null){
            this.id_usuario = dados.id_usuario();
        }

    }



}
