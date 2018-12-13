package Enums;


public enum EnumRepetirMovimentacao {

    NAO_REPETE(0,"N","Não Repete"),
    DIARIAMENTE(1,"D","Diariamente"),
    SEMANALMENTE(2,"S","Semanalmente"),
    MENSALMENTE(3,"M","Mensalmente"),
    ANUALMENTE(4,"A","Anualmente");
    
    private Integer index;
    private String key, description;

    private EnumRepetirMovimentacao(Integer index, String key, String description) {
        this.index = index;
        this.key = key;
        this.description = description;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public static EnumRepetirMovimentacao getByKey(String key){
        for (EnumRepetirMovimentacao mov: EnumRepetirMovimentacao.values()){
            if (mov.key.equals(key)){
                return mov;
            }
        }
        return null;
    }
    
    
}
