package astratech.dla_api.model;


import com.sun.istack.NotNull;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "msuser")
public class msuser {
    @Id
    @NotNull
    private String email;
    private String nomor;
    private String nama;
    private String alamat;
    private String hp;
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private msrole id_role;
    @ManyToOne
    @JoinColumn(name = "id_prodi")
    private msprodi id_prodi;
    private int status;
    private String creaby;
    private String creadate;
    private String modiby;
    private String modidate;

    public msuser() {
    }

    public msuser(String email, String nomor, String nama, String alamat, String hp, String password, msrole id_role, msprodi id_prodi, int status, String creaby, String creadate, String modiby, String modidate) {
        this.email = email;
        this.nomor = nomor;
        this.nama = nama;
        this.alamat = alamat;
        this.hp = hp;
        this.password = password;
        this.id_role = id_role;
        this.id_prodi = id_prodi;
        this.status = status;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public msrole getId_role() {
        return id_role;
    }

    public void setId_role(msrole id_role) {
        this.id_role = id_role;
    }

    public msprodi getId_prodi() {
        return id_prodi;
    }

    public void setId_prodi(msprodi id_prodi) {
        this.id_prodi = id_prodi;
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
