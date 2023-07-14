package astratech.dla_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class msmember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String mbr_nim;
    private String mbr_username;
    private String mbr_notel;
    private String mbr_jk;
    private String mbr_password;
    private String mbr_status;
    private Date mbr_created_date;
    private String mbr_modf_by;
    private Date mbr_modif_date;

    public msmember() {
    }

    public msmember(String mbr_nim, String mbr_username, String mbr_notel, String mbr_jk, String mbr_password, String mbr_status, Date mbr_created_date, String mbr_modf_by, Date mbr_modif_date) {
        this.mbr_nim = mbr_nim;
        this.mbr_username = mbr_username;
        this.mbr_notel = mbr_notel;
        this.mbr_jk = mbr_jk;
        this.mbr_password = mbr_password;
        this.mbr_status = mbr_status;
        this.mbr_created_date = mbr_created_date;
        this.mbr_modf_by = mbr_modf_by;
        this.mbr_modif_date = mbr_modif_date;
    }

    public String getMbr_nim() {
        return mbr_nim;
    }

    public void setMbr_nim(String mbr_nim) {
        this.mbr_nim = mbr_nim;
    }

    public String getMbr_username() {
        return mbr_username;
    }

    public void setMbr_username(String mbr_username) {
        this.mbr_username = mbr_username;
    }

    public String getMbr_notel() {
        return mbr_notel;
    }

    public void setMbr_notel(String mbr_notel) {
        this.mbr_notel = mbr_notel;
    }

    public String getMbr_jk() {
        return mbr_jk;
    }

    public void setMbr_jk(String mbr_jk) {
        this.mbr_jk = mbr_jk;
    }

    public String getMbr_password() {
        return mbr_password;
    }

    public void setMbr_password(String mbr_password) {
        this.mbr_password = mbr_password;
    }

    public String getMbr_status() {
        return mbr_status;
    }

    public void setMbr_status(String mbr_status) {
        this.mbr_status = mbr_status;
    }

    public Date getMbr_created_date() {
        return mbr_created_date;
    }

    public void setMbr_created_date(Date mbr_created_date) {
        this.mbr_created_date = mbr_created_date;
    }

    public String getMbr_modf_by() {
        return mbr_modf_by;
    }

    public void setMbr_modf_by(String mbr_modf_by) {
        this.mbr_modf_by = mbr_modf_by;
    }

    public Date getMbr_modif_date() {
        return mbr_modif_date;
    }

    public void setMbr_modif_date(Date mbr_modif_date) {
        this.mbr_modif_date = mbr_modif_date;
    }
}
