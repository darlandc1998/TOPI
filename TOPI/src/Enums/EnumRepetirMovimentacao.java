package Enums;


public enum EnumRepetirMovimentacao {

    DIARIAMENTE(0,"D","Diariamente"),
    SEMANALMENTE(1,"S","Semanalmente"),
    MENSALMENTE(2,"M","Mensalmente"),
    ANUALMENTE(3,"A","Anualmente");
    
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
    
    
    
    
}
