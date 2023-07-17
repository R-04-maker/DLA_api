package astratech.dla_api.model;

import javax.persistence.*;

import java.util.Date;

@Entity
public class trklasifikasirak {
    @Id
    private int id_klasifikasirak;

    @ManyToOne
    @JoinColumn(name = "id_rak")
    private msrak id_rak;

    @ManyToOne
    @JoinColumn(name = "id_klasifikasi")
    private msklasifikasi id_klasifikasi;

    private String creaby;
    private Date creadate;
    private String modiby;
    private Date modidate;

    public trklasifikasirak() {
    }

    public trklasifikasirak(int id_klasifikasirak, msrak id_rak, msklasifikasi id_klasifikasi, String creaby, Date creadate, String modiby, Date modidate) {
        this.id_klasifikasirak = id_klasifikasirak;
        this.id_rak = id_rak;
        this.id_klasifikasi = id_klasifikasi;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
    }

    public int getId_klasifikasirak() {
        return id_klasifikasirak;
    }

    public void setId_klasifikasirak(int id_klasifikasirak) {
        this.id_klasifikasirak = id_klasifikasirak;
    }

    public msrak getId_rak() {
        return id_rak;
    }

    public void setId_rak(msrak id_rak) {
        this.id_rak = id_rak;
    }

    public msklasifikasi getId_klasifikasi() {
        return id_klasifikasi;
    }

    public void setId_klasifikasi(msklasifikasi id_klasifikasi) {
        this.id_klasifikasi = id_klasifikasi;
    }

    public String getCreaby() {
        return creaby;
    }

    public void setCreaby(String creaby) {
        this.creaby = creaby;
    }

    public Date getCreadate() {
        return creadate;
    }

    public void setCreadate(Date creadate) {
        this.creadate = creadate;
    }

    public String getModiby() {
        return modiby;
    }

    public void setModiby(String modiby) {
        this.modiby = modiby;
    }

    public Date getModidate() {
        return modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }
}
