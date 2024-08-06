package med.voll.api.domains.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
    @NotNull Long id,
    String nome,
    String email,
    @NotBlank String cpf,
    String telefone,
    DadosEndereco endereco,
    Boolean ativo
) { }
