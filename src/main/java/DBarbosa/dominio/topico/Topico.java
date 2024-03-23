package DBarbosa.dominio.topico;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")                            // >>> JPA -  "Java Persistence API"
public class Topico {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Mapeia a tabela topicos do banco de dados
    private Long id;
    private String titulo;
    private String mensagem;
    private String data;
    private Boolean status;
    private String autor;
    private String curso;

    public Topico(DadosAbrirTopico dados) {    // Atribui os dado recebido para colunas do banco de dados


        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = java.time.LocalDate.now().toString();
        this.status = true;
        this.autor = dados.autor();
        this.curso = dados.curso();


    }


    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {

        if(dados.titulo() != null){
            this.titulo = dados.titulo();
        }

        if(dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }

        if(dados.status() != null){
            this.status = dados.status();
        }

        if(dados.curso() != null){
            this.curso = dados.curso();
        }

    }
}
