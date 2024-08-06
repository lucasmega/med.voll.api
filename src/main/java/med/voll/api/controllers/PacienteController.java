package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import med.voll.api.domains.models.Paciente;
import med.voll.api.services.PacienteService;
import med.voll.api.domains.DTOs.DadosCadastroPaciente;
import med.voll.api.domains.DTOs.DadosListagemPaciente;
import med.voll.api.domains.DTOs.DadosAtualizacaoPaciente;
import med.voll.api.domains.DTOs.DadosDetalhamentoPaciente;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<DadosDetalhamentoPaciente> cadastrar(@RequestBody @Valid DadosCadastroPaciente dto, UriComponentsBuilder uriComponentsBuilder) {
        Paciente paciente = pacienteService.cadastrar(dto);
        var uri = uriComponentsBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Page<DadosListagemPaciente>> listar(Pageable pageable) {
        return ResponseEntity.ok(pacienteService.listar(pageable));
    }

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<DadosDetalhamentoPaciente> atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dto) {
        return ResponseEntity.ok(pacienteService.atualizar(dto));
    }

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pacienteService.fisica(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pacienteService.logica(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DadosDetalhamentoPaciente> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.detalhar(id));
    }
}
