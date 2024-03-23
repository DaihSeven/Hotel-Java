package DBarbosa.controller;

import DBarbosa.dominio.usuario.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;

@RestController
@RequestMapping("usuario")
@SecurityRequirement(name = "bearer-key")
public class usuarioController {

    @Autowired
    private UsuarioRepository repository;


    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody @Validated DadosCadastrarUsuario dados,
                                           UriComponentsBuilder uriComponentsBuilder) {

        var usuario = new Usuario(dados);

        repository.save(usuario);


        var uri = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemUsuario(usuario));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemUsuario::new);

        return ResponseEntity.ok(page);

    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Validated DadosAtualizacaoUsuario dados) {

        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemUsuario(usuario));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){

        repository.deleteById(id);

        return  ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")

    public ResponseEntity detalhar(@PathVariable Long id){


        var usuario = repository.getReferenceById(id);

        return  ResponseEntity.ok(new DadosListagemUsuario(usuario));


    }

}
