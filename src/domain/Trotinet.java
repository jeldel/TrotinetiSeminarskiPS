package domain;

public class Trotinet {

    private Long trotinetID;
    private VrstaTrotinetaEntity vrstaTrotineta;
    private String karakteristike;
    private Status status;


    public Long getTrotinetID() {
        return trotinetID;
    }

    public void setTrotinetID(Long trotinetID) {
        this.trotinetID = trotinetID;
    }

    public VrstaTrotinetaEntity getVrstaTrotineta() {
        return vrstaTrotineta;
    }

    public void setVrstaTrotineta(VrstaTrotinetaEntity vrstaTrotineta) {
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
}
