package DBarbosa.controller;

import DBarbosa.dominio.resposta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;


@RestController
@RequestMapping("respostas")
@ConditionalOnDefaultWebSecurity(name = "bearer-key")
public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @PostMapping
    public ResponseEntity criarResposta(@RequestBody @Validated DadosCriarRespota dados,
                                        UriComponentsBuilder uriComponentsBuilder){

        var resposta = new Resposta(dados);
        repository.save(resposta);

        var uri = uriComponentsBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemResposta(resposta));


    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemResposta>> listar(@PageableDefault(size = 10) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemResposta::new);

        return ResponseEntity.ok(page);

    }

    @PutMapping
    @QuartzTransactionManager
    public ResponseEntity atualizar(@RequestBody @Validated DadosAtualizacaoResposta dados) {

        var resposta = repository.getReferenceById(dados.id());
        resposta.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemResposta(resposta));

    }

    @DeleteMapping("/{id}")
    @QuartzTransactionManager
    public ResponseEntity excluir(@PathVariable Long id){

        repository.deleteById(id);

        return  ResponseEntity.noContent().build();


    }

    @GetMapping("/{id}")

    public ResponseEntity detalhar(@PathVariable Long id){


        var resposta = repository.getReferenceById(id);

        return  ResponseEntity.ok(new DadosListagemResposta(resposta));


    }


}
