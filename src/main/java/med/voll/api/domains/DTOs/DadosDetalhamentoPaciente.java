package med.voll.api.domains.DTOs;

import med.voll.api.domains.models.Endereco;
import med.voll.api.domains.models.Paciente;

public record DadosDetalhamentoPaciente(
        String nome,
        String email,
        String cpf,
        String telefone,
        Endereco endereco
) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
