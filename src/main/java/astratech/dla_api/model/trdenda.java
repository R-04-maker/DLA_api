package astratech.dla_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class trdenda {

    @Id
    private int id_denda;
    private String bulan;
    private String email;
    @ManyToOne
    @JoinColumn(name = "id_transactiondetail")
    private  trbooking id_transactiondetail;
    private String creaby;
    private Date creadate;
    private String modiby;
    private Date modidate;

    public trdenda() {
    }

    public trdenda(int id_denda, String bulan, String email, trbooking id_transactiondetail, String creaby, Date creadate, String modiby, Date modidate) {
        this.id_denda = id_denda;
        this.bulan = bulan;
        this.email = email;
        this.id_transactiondetail = id_transactiondetail;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
    }

    public int getId_denda() {
        return id_denda;
    }

    public void setId_denda(int id_denda) {
        this.id_denda = id_denda;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public trbooking getId_transactiondetail() {
        return id_transactiondetail;
    }

    public void setId_transactiondetail(trbooking id_transactiondetail) {
        this.id_transactiondetail = id_transactiondetail;
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
