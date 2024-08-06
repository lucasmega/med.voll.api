package med.voll.api.domains.DTOs;

import med.voll.api.domains.enums.Especialidade;
import med.voll.api.domains.models.Endereco;
import med.voll.api.domains.models.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
