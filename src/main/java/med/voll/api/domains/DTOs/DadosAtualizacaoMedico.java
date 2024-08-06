package med.voll.api.domains.DTOs;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull Long id,
        String nome,
        String email,
        String crm,
        String telefone,
        Boolean ativo,
        DadosEndereco endereco
) { }
