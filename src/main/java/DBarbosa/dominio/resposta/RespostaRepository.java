package DBarbosa.dominio.resposta;

import org.springframework.data.jpa.repository.JpaRepository;
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    void save(Resposta resposta);
}
