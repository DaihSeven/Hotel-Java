package DBarbosa.dominio.topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    void save(Topico topico);    // Repository para herdar métodos que possuem SQL para executar operações CRUD

}
