package domain;

import java.util.List;

public class Trotinet {

    private Long trotinetID;
    private VrstaTrotinetaEnum vrstaTrotineta;
    private String karakteristike;
    private Status status;
    private int ocena;
    private List<Integer> sveOcene;

    public Trotinet(Long trotinetID, VrstaTrotinetaEnum vrstaTrotineta, String karakteristike, Status status) {
        this.trotinetID = trotinetID;
        this.vrstaTrotineta = vrstaTrotineta;
        this.karakteristike = karakteristike;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Trotinet{" +
                "trotinetID=" + trotinetID +
                ", vrstaTrotineta=" + vrstaTrotineta +
                ", karakteristike='" + karakteristike + '\'' +
                ", status=" + status +
                '}';
    }
}
