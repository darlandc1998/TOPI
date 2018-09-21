package Modelos;

import java.util.Date;


public class Usuario {
    
    private Integer codigo;
    private String nome;
    private String sobrenome;
    private String email;
    private Date dtNascimento;
    private String sexo;
    private String cpf;
    private String estadoCivil;
    private String Profissao;
    private Double rendaMensal;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfissao() {
        return Profissao;
    }

    public void setProfissao(String Profissao) {
        this.Profissao = Profissao;
    }

    public Double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(Double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", dtNascimento=" + dtNascimento + ", sexo=" + sexo + ", cpf=" + cpf + ", estadoCivil=" + estadoCivil + ", Profissao=" + Profissao + ", rendaMensal=" + rendaMensal + '}';
    }
    
    
    
}
