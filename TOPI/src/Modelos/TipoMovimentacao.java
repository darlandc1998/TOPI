package Modelos;

import java.util.Objects;


public class TipoMovimentacao {
    
    private Integer codigo;
    private String descricao;
    private String observacao;
    private Integer cdUsuario;

    public TipoMovimentacao() {
    }

    public TipoMovimentacao(Integer codigo) {
        this.codigo = codigo;
    }
    
    public TipoMovimentacao(Integer codigo, String descricao, String observacao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.observacao = observacao;
    }

    public TipoMovimentacao(Integer codigo, String descricao, String observacao, Integer cdUsuario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.observacao = observacao;
        this.cdUsuario = cdUsuario;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Integer cdUsuario) {
        this.cdUsuario = cdUsuario;
    }
    

    @Override
    public String toString() {
        return "TipoMovimentacao{" + "codigo=" + codigo + ", descricao=" + descricao + ", observacao=" + observacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoMovimentacao other = (TipoMovimentacao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
    
}
