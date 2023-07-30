package astratech.dla_api.model;


import javax.persistence.*;

import java.util.Date;

@Entity
public class trbookingdetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transactiondetail;

    @ManyToOne
    @JoinColumn(name = "id_transaction")
    private trbooking id_transaction;

    @ManyToOne
    @JoinColumn(name = "id_koleksi")
    private mskoleksi id_koleksi;

    private String tanggalpinjam;
    private String tanggalkembali;

    private int status;
    private String creaby;
    private String creadate;
    private String modiby;
    private String modidate;

    public trbookingdetail() {
    }

    public trbookingdetail(int id_transactiondetail, trbooking id_transaction, mskoleksi id_koleksi, String tanggalpinjam, String tanggalkembali, int status, String creaby, String creadate, String modiby, String modidate) {
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

    public String getTanggalpinjam() {
        return tanggalpinjam;
    }

    public void setTanggalpinjam(String tanggalpinjam) {
        this.tanggalpinjam = tanggalpinjam;
    }

    public String getTanggalkembali() {
        return tanggalkembali;
    }

    public void setTanggalkembali(String tanggalkembali) {
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

    public String getCreadate() {
        return creadate;
    }

    public void setCreadate(String creadate) {
        this.creadate = creadate;
    }

    public String getModiby() {
        return modiby;
    }

    public void setModiby(String modiby) {
        this.modiby = modiby;
    }

    public String getModidate() {
        return modidate;
    }

    public void setModidate(String modidate) {
        this.modidate = modidate;
    }
}
