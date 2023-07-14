package astratech.dla_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class trbooking {
    @Id
    private String id_transaction;
    private String email;
    private int bookingonline;
    private String status;
    private String creaby;
    private Date creadate;
    private String modiby;
    private Date modidate;
    private String nama;
    private String nomor;

    public trbooking() {
    }

    public trbooking(String id_transaction, String email, int bookingonline, String status, String creaby, Date creadate, String modiby, Date modidate) {
        this.id_transaction = id_transaction;
        this.email = email;
        this.bookingonline = bookingonline;
        this.status = status;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
    }

    public String getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(String id_transaction) {
        this.id_transaction = id_transaction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBookingonline() {
        return bookingonline;
    }

    public void setBookingonline(int bookingonline) {
        this.bookingonline = bookingonline;
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
}