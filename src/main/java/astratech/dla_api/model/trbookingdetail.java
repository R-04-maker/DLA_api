package astratech.dla_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class trbookingdetail {

    @Id
    private int id_transactiondetail;

    @ManyToOne
    @JoinColumn(name = "id_transaction")
    private trbooking id_transaction;

    @ManyToOne
    @JoinColumn(name = "id_koleksi")
    private mskoleksi id_koleksi;

    private Date tanggalpinjam;
    private Date tanggalkembali;

    private int status;
    private String creaby;
    private Date creadate;
    private String modiby;
    private Date modidate;

    public trbookingdetail(int id_transactiondetail, trbooking id_transaction, mskoleksi id_koleksi, Date tanggalpinjam, Date tanggalkembali, int status, String creaby, Date creadate, String modiby, Date modidate) {
        this.id_transactiondetail = id_transactiondetail;
        this.id_transaction = id_transaction;
        this.id_koleksi = id_koleksi;
        this.tanggalpinjam = tanggalpinjam;
        this.tanggalkembali = tanggalkembali;
        this.status = status;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
    }

    public trbookingdetail() {
    }

    public int getId_transactiondetail() {
        return id_transactiondetail;
    }

    public void setId_transactiondetail(int id_transactiondetail) {
        this.id_transactiondetail = id_transactiondetail;
    }

    public trbooking getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(trbooking id_transaction) {
        this.id_transaction = id_transaction;
    }

    public mskoleksi getId_koleksi() {
        return id_koleksi;
    }

    public void setId_koleksi(mskoleksi id_koleksi) {
        this.id_koleksi = id_koleksi;
    }

    public Date getTanggalpinjam() {
        return tanggalpinjam;
    }

    public void setTanggalpinjam(Date tanggalpinjam) {
        this.tanggalpinjam = tanggalpinjam;
    }

    public Date getTanggalkembali() {
        return tanggalkembali;
    }

    public void setTanggalkembali(Date tanggalkembali) {
        this.tanggalkembali = tanggalkembali;
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
