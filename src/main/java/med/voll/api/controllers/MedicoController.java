package med.voll.api.controllers;

import jakarta.validation.Valid;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import med.voll.api.domains.models.Medico;
import med.voll.api.services.MedicoService;
import med.voll.api.domains.DTOs.DadosListagemMedico;
import med.voll.api.domains.DTOs.DadosCadastroMedicoDTO;
import med.voll.api.domains.DTOs.DadosAtualizacaoMedico;
import med.voll.api.domains.DTOs.DadosDetalhamentoMedico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<DadosDetalhamentoMedico> cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        Medico medico = medicoService.cadastrar(dto);
        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Page<DadosListagemMedico>>  listar(Pageable pageable) {
        return ResponseEntity.ok(medicoService.listar(pageable));
    }

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<DadosDetalhamentoMedico> atualizar(@RequestBody @Valid DadosAtualizacaoMedico dto) {
         return ResponseEntity.ok(medicoService.atualizar(dto));
    }

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        medicoService.fisica(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicoService.logica(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/listar-ativos", method = RequestMethod.GET)
    public ResponseEntity<Page<DadosListagemMedico>> listarAtivos(Pageable pageable) {
        return ResponseEntity.ok(medicoService.listarAtivos(pageable));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DadosDetalhamentoMedico> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.detalhar(id));
    }
}
