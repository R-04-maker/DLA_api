package astratech.dla_api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class trbooking {
    @Id
    private String id_transaction;
    private String email;
    private int bookingonline;
    private String status;
    private String creaby;
    private String creadate;
    private String modiby;
    private String modidate;

    public trbooking() {
    }

    public trbooking(String id_transaction, String email, int bookingonline, String status, String creaby, String creadate, String modiby, String modidate) {
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
