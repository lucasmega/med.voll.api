package med.voll.api.domains.models;

import jakarta.persistence.*;
import med.voll.api.domains.DTOs.DadosAtualizacaoPaciente;
import med.voll.api.domains.DTOs.DadosCadastroPaciente;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Paciente implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private Boolean ativo;
    @Embedded
    private Endereco endereco;

    public Paciente() { }

    public Paciente(Long id, String nome, String email, String cpf, String telefone, Boolean ativo, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.ativo = ativo;
    }
    public Paciente(DadosCadastroPaciente dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.cpf = dto.cpf();
        this.telefone = dto.telefone();
        this.endereco = new Endereco(dto.endereco());
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                ", ativo=" +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Paciente paciente = (Paciente) object;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void atualizar(DadosAtualizacaoPaciente dto) {
        if (dto.nome() != null && !dto.nome().equals("")) {
            this.nome = dto.nome();
        }

        if (dto.telefone() != null && !dto.telefone().equals("")) {
            this.telefone = dto.telefone();
        }

        if (dto.ativo() != null) {
            this.ativo = dto.ativo();
        }

        if (dto.endereco() != null) {
            this.endereco.atualizar(dto.endereco());
        }
    }
}
