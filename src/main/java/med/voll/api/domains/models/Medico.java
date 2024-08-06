package med.voll.api.domains.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.util.Objects;
import java.io.Serializable;

import med.voll.api.domains.DTOs.DadosAtualizacaoMedico;
import med.voll.api.domains.DTOs.DadosCadastroMedicoDTO;
import med.voll.api.domains.enums.Especialidade;
@Entity
public class Medico implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;
    public Medico() { }
    public Medico(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Medico(DadosCadastroMedicoDTO dto) {
        this.ativo = true;
        this.crm = dto.crm();
        this.nome = dto.nome();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.especialidade = dto.especialidade();
        this.endereco = new Endereco(dto.endereco());
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", crm='" + crm + '\'' +
                ", especialidade=" + especialidade +
                ", endereco=" + endereco +
                ", telefone=" + telefone +
                ", ativo=" + ativo +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Medico medico = (Medico) object;
        return Objects.equals(id, medico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void atualizar(DadosAtualizacaoMedico dto) {

        if (dto.nome() != null && !dto.nome().equals("")) {
            this.nome = dto.nome();
        }

        if (dto.email() != null && !dto.email().equals("")) {
            this.email = dto.email();
        }

        if (dto.crm() != null && !dto.crm().equals("")) {
            this.crm = dto.crm();
        }

        if(dto.telefone() != null && !dto.telefone().equals("")) {
            this.telefone = dto.telefone();
        }

        if (dto.endereco() != null) {
            this.endereco.atualizar(dto.endereco());
        }

        if(dto.ativo() != null) {
            this.ativo = dto.ativo();
        }

    }

}
