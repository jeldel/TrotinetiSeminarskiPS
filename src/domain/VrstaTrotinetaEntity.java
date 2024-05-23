package domain;

public class VrstaTrotinetaEntity {
    private Long vrstaTrotinetaID;
    private VrstaTrotinetaEnum vrstaEnum;

    public Long getVrstaTrotinetaID() {
        return vrstaTrotinetaID;
    }

    public void setVrstaTrotinetaID(Long vrstaTrotinetaID) {
        this.vrstaTrotinetaID = vrstaTrotinetaID;
    }

    public VrstaTrotinetaEnum getVrstaEnum() {
        return vrstaEnum;
    }

    public void setVrstaEnum(VrstaTrotinetaEnum vrstaEnum) {
        this.vrstaEnum = vrstaEnum;
    }
}
