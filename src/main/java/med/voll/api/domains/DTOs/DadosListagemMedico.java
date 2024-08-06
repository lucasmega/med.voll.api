package med.voll.api.domains.DTOs;

import med.voll.api.domains.enums.Especialidade;
import med.voll.api.domains.models.Medico;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedico(Medico medico) {
            this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }


}
