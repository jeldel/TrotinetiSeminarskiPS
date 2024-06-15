package domain;

public class Trotinet {

    private Long trotinetID;
    private VrstaTrotinetaEnum vrstaTrotineta;
    private String karakteristike;

    public Trotinet(Long trotinetID, VrstaTrotinetaEnum vrstaTrotineta, String karakteristike) {
        this.trotinetID = trotinetID;
        this.vrstaTrotineta = vrstaTrotineta;
        this.karakteristike = karakteristike;
    }

    public Long getTrotinetID() {
        return trotinetID;
    }

    public void setTrotinetID(Long trotinetID) {
        this.trotinetID = trotinetID;
    }

    public Trotinet() {
    }

    public VrstaTrotinetaEnum getVrstaTrotineta() {
        return vrstaTrotineta;
    }

    public void setVrstaTrotineta(VrstaTrotinetaEnum vrstaTrotineta) {
        this.vrstaTrotineta = vrstaTrotineta;
    }

    public String getKarakteristike() {
        return karakteristike;
    }

    public void setKarakteristike(String karakteristike) {
        this.karakteristike = karakteristike;
    }


    @Override
    public String toString() {
        return "Trotinet{" +
                "trotinetID=" + trotinetID +
                ", vrstaTrotineta=" + vrstaTrotineta +
                ", karakteristike='" + karakteristike +
                '}';
    }
}
