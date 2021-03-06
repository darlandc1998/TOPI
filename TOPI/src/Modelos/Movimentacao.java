
package Modelos;

import Enums.EnumRepetirMovimentacao;
import java.util.Date;
import java.util.Objects;


public class Movimentacao {
    
    private Integer codigo;
    private String Descricao;
    private Integer cdTipoMovimentacao;
    private Integer cdUsuario;
    private String situacao;
    private Date data;
    private Double valor;
    private EnumRepetirMovimentacao repetir;
    private String tipoMovimentacaoDescricao;

    public Movimentacao() {
    }

    public Movimentacao(Integer codigo) {
        this.codigo = codigo;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Integer getCdTipoMovimentacao() {
        return cdTipoMovimentacao;
    }

    public void setCdTipoMovimentacao(Integer cdTipoMovimentacao) {
        this.cdTipoMovimentacao = cdTipoMovimentacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public EnumRepetirMovimentacao getRepetir() {
        return repetir;
    }

    public void setRepetir(EnumRepetirMovimentacao repetir) {
        this.repetir = repetir;
    }

    public Integer getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Integer cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getTipoMovimentacaoDescricao() {
        return tipoMovimentacaoDescricao;
    }

    public void setTipoMovimentacaoDescricao(String tipoMovimentacaoDescricao) {
        this.tipoMovimentacaoDescricao = tipoMovimentacaoDescricao;
    }
    
    @Override
    public String toString() {
        return "Movimentacao{" + "codigo=" + codigo + ", Descricao=" + Descricao + ", cdTipoMovimentacao=" + cdTipoMovimentacao + ", situacao=" + situacao + ", data=" + data + ", valor=" + valor + ", repetir=" + repetir + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codigo);
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
        final Movimentacao other = (Movimentacao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    

}
