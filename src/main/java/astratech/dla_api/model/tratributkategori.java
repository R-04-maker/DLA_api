package astratech.dla_api.model;

import javax.persistence.*;

import java.util.Date;

@Entity
public class tratributkategori {

    @Id
    private int id_atributkategori;

    @ManyToOne
    @JoinColumn(name = "id_kategori")
    private mskategori id_kategori;
    @ManyToOne
    @JoinColumn(name = "id_atribut")
    private msatribut id_atribut;

    private String creaby;
    private Date creadate;
    private String modiby;
    private Date modidate;

    public tratributkategori(int id_atributkategori, mskategori id_kategori, msatribut id_atribut, String creaby, Date creadate, String modiby, Date modidate) {
        this.id_atributkategori = id_atributkategori;
        this.id_kategori = id_kategori;
        this.id_atribut = id_atribut;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
    }

    public tratributkategori() {
    }

    public int getId_atributkategori() {
        return id_atributkategori;
    }

    public void setId_atributkategori(int id_atributkategori) {
        this.id_atributkategori = id_atributkategori;
    }

    public mskategori getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(mskategori id_kategori) {
        this.id_kategori = id_kategori;
    }

    public msatribut getId_atribut() {
        return id_atribut;
    }

    public void setId_atribut(msatribut id_atribut) {
        this.id_atribut = id_atribut;
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
