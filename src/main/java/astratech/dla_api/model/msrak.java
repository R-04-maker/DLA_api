package astratech.dla_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class msrak {
    @Id
    private String id_rak;
    private String nama;
    private String deskripsi;
    private String status;
    private String creaby;
    private Date creadate;
    private String modiby;
    private Date modidate;

    public msrak() {
    }

    public msrak(String id_rak, String nama, String deskripsi, String status, String creaby, Date creadate, String modiby, Date modidate) {
        this.id_rak = id_rak;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.status = status;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
    }

    public String getId_rak() {
        return id_rak;
    }

    public void setId_rak(String id_rak) {
        this.id_rak = id_rak;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getdeskripsi() {
        return deskripsi;
    }

    public void setdeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
