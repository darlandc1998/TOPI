package Modelos;


public class TipoMovimentacao {
    
    private String codigo;
    private String descricao;
    private String observacao;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    @Override
    public String toString() {
        return "TipoMovimentacao{" + "codigo=" + codigo + ", descricao=" + descricao + ", observacao=" + observacao + '}';
    }
    
    
}
