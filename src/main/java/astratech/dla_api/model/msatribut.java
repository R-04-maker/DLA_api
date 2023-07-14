package astratech.dla_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class msatribut {
    @Id

    private String id_atribut;

    private String nama;
    private String deskripsi;
    private int status;
    private String creaby;
    private Date creadate;
    private String modiby;
    private Date modidate;

    public msatribut() {
    }

    public msatribut(String id_atribut, String nama, String deskripsi, int status, String creaby, Date creadate, String modiby, Date modidate) {
        this.id_atribut = id_atribut;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.status = status;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
    }

    public String getId_atribut() {
        return id_atribut;
    }

    public void setId_atribut(String id_atribut) {
        this.id_atribut = id_atribut;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
