package med.voll.api.services;

import med.voll.api.domains.DTOs.DadosAtualizacaoPaciente;
import med.voll.api.domains.DTOs.DadosDetalhamentoPaciente;
import med.voll.api.domains.DTOs.DadosListagemPaciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import med.voll.api.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import med.voll.api.domains.models.Paciente;
import med.voll.api.domains.DTOs.DadosCadastroPaciente;


@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public Paciente cadastrar(DadosCadastroPaciente dto) {
        Paciente paciente = new Paciente(dto);
        pacienteRepository.save(paciente);
        return paciente;
    }

    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return pacienteRepository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    public DadosDetalhamentoPaciente atualizar(DadosAtualizacaoPaciente dto) {
        Paciente paciente = pacienteRepository.getReferenceById(dto.id());
        paciente.atualizar(dto);
        return new DadosDetalhamentoPaciente(paciente);
    }

    public void logica(Long id) {
        pacienteRepository.getReferenceById(id).setAtivo(false);
    }

    public void fisica(Long id) {
        pacienteRepository.deleteById(id);
    }

    public DadosDetalhamentoPaciente detalhar(Long id) {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        return new DadosDetalhamentoPaciente(paciente);
    }
}
