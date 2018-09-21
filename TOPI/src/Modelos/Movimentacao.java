
package Modelos;

import Enums.EnumRepetirMovimentacao;
import java.util.Date;


public class Movimentacao {
    
    private Integer codigo;
    private String Descricao;
    private Integer cdTipoMovimentacao;
    private String situacao;
    private Date data;
    private Double valor;
    private EnumRepetirMovimentacao repetir;

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

    @Override
    public String toString() {
        return "Movimentacao{" + "codigo=" + codigo + ", Descricao=" + Descricao + ", cdTipoMovimentacao=" + cdTipoMovimentacao + ", situacao=" + situacao + ", data=" + data + ", valor=" + valor + ", repetir=" + repetir + '}';
    }
    
    

}
