package med.voll.api.services;

import med.voll.api.domains.DTOs.DadosDetalhamentoMedico;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.beans.factory.annotation.Autowired;

import med.voll.api.domains.models.Medico;
import med.voll.api.repositories.MedicoRepository;
import med.voll.api.domains.DTOs.DadosListagemMedico;
import med.voll.api.domains.DTOs.DadosCadastroMedicoDTO;
import med.voll.api.domains.DTOs.DadosAtualizacaoMedico;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public Medico cadastrar(DadosCadastroMedicoDTO dto) {
        Medico medico = new Medico(dto);
        medicoRepository.save(medico);
        return medico;
    }

    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    public Page<DadosListagemMedico> listarAtivos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    public DadosDetalhamentoMedico atualizar(DadosAtualizacaoMedico dto) {
        Medico medico = medicoRepository.getReferenceById(dto.id());
        medico.atualizar(dto);
        return new DadosDetalhamentoMedico(medico);
    }

    public void logica(Long id) {
        medicoRepository.getReferenceById(id).setAtivo(false);
    }

    public void fisica(Long id) {
        medicoRepository.deleteById(id);
    }

    public DadosDetalhamentoMedico detalhar(Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        return new DadosDetalhamentoMedico(medico);
    }
}
