package med.voll.api.domains.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domains.models.Paciente;

public record DadosCadastroPaciente(
        @NotBlank  String nome,
        @NotBlank String email,
        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String cpf,
        @NotBlank String telefone,
        @NotNull @Valid DadosEndereco endereco
) {

}
