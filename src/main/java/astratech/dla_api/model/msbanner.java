package astratech.dla_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class msbanner {
    @Id

    private String id_banner;
    private String nama;
    private String berkas;
    private int status;
    private String creaby;
    private Date creadate;
    private String modiby;
    private Date modidate;

    public msbanner() {
    }

    public msbanner(String id_banner, String nama, String berkas, int status, String creaby, Date creadate, String modiby, Date modidate) {
        this.id_banner = id_banner;
        this.nama = nama;
        this.berkas = berkas;
        this.status = status;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
    }

    public String getId_banner() {
        return id_banner;
    }

    public void setId_banner(String id_banner) {
        this.id_banner = id_banner;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBerkas() {
        return berkas;
    }

    public void setBerkas(String berkas) {
        this.berkas = berkas;
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
