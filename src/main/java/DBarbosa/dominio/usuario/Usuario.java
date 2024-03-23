package DBarbosa.dominio.usuario;

import jakarta.*;
import lombok.EqualsAndHashCode;
import lombok.getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Mapeia a tabela topicos do banco de dados
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String data_abertura_conta;

    public Usuario(DadosCadastrarUsuario dados) {    // Atribui os dado recebido para colunas do banco de dados


        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.data_abertura_conta = java.time.LocalDate.now().toString();



    }

    public void atualizarInformacoes(DadosAtualizacaoUsuario dados) {

        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.email() != null){
            this.email = dados.email();
        }

        if(dados.senha() != null){
            this.senha = dados.senha();
        }

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
