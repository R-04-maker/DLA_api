package astratech.dla_api.model;


import javax.persistence.*;

import java.util.Date;

@Entity
public class trpengunjung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pengunjung;
    private String nim ;
    private String nama ;
    private String prodi;
    private String creaby;
    private Date creadate;
    private String modiby;
    private Date modidate;

    public trpengunjung(int id_pengunjung, String nim, String nama, String prodi, String creaby, Date creadate, String modiby, Date modidate) {
        this.id_pengunjung = id_pengunjung;
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
    }

    public trpengunjung() {
    }

    public int getId_pengunjung() {
        return id_pengunjung;
    }

    public void setId_pengunjung(int id_pengunjung) {
        this.id_pengunjung = id_pengunjung;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
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
