package med.voll.api.domains.DTOs;

import med.voll.api.domains.models.Endereco;
import med.voll.api.domains.models.Paciente;

public record DadosListagemPaciente(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone,
        Endereco endereco
) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
