package astratech.dla_api.model;


import javax.persistence.*;

@Entity
public class msrole {

    @Id
    private String id_role;
    private int status;
    private int maksbuku;
    private int makstempo;

    public msrole(String id_role, int status, int maksbuku, int makstempo) {
        this.id_role = id_role;
        this.status = status;
        this.maksbuku = maksbuku;
        this.makstempo = makstempo;
    }

    public String getId_role() {
        return id_role;
    }

    public void setId_role(String id_role) {
        this.id_role = id_role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMaksbuku() {
        return maksbuku;
    }

    public void setMaksbuku(int maksbuku) {
        this.maksbuku = maksbuku;
    }

    public int getMakstempo() {
        return makstempo;
    }

    public void setMakstempo(int makstempo) {
        this.makstempo = makstempo;
    }

    public msrole() {
    }
}
