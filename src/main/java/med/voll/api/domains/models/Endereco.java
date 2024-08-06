package med.voll.api.domains.models;

import java.io.Serial;
import java.io.Serializable;
import jakarta.persistence.Embeddable;
import med.voll.api.domains.DTOs.DadosEndereco;

@Embeddable
public class Endereco implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco() { }

    public Endereco(String logradouro, String bairro, String cep, String numero, String complemento, String cidade, String uf) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.uf = endereco.uf();
        this.numero = endereco.numero();
        this.cidade = endereco.cidade();
        this.complemento = endereco.complemento();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }

    public void atualizar(DadosEndereco dto) {
        if (dto.logradouro() != null && !dto.logradouro().isBlank()) {
            this.logradouro = dto.logradouro();
        }

        if (dto.bairro() != null && !dto.bairro().isBlank()) {
            this.bairro = dto.bairro();
        }

        if (dto.cep() != null && !dto.cep().isBlank()) {
            this.cep = dto.cep();
        }

        if (dto.cidade() != null && !dto.cidade().isBlank()) {
            this.cidade = dto.cidade();
        }

        if (dto.uf() != null && !dto.uf().isBlank()) {
            this.uf = dto.uf();
        }

        if (dto.complemento() != null && !dto.complemento().isBlank()) {
            this.complemento = dto.complemento();
        }

        if (dto.numero() != null && !dto.numero().isBlank()) {
            this.numero = dto.numero();
        }
    }
}
