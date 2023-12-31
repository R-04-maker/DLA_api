package astratech.dla_api.model;

import javax.persistence.*;

@Entity
public class LoginModel {
    @Id
    private String email;
    private String nomor;
    private String nama;
    private String id_role;
    private String id_prodi;
    private String deskripsi;
    private String hp;

    public LoginModel() {
    }

    public LoginModel(String email, String nomor, String nama, String id_role, String id_prodi, String deskripsi, String hp) {
        this.email = email;
        this.nomor = nomor;
        this.nama = nama;
        this.id_role = id_role;
        this.id_prodi = id_prodi;
        this.deskripsi = deskripsi;
        this.hp = hp;
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

    public String getId_role() {
        return id_role;
    }

    public void setId_role(String id_role) {
        this.id_role = id_role;
    }

    public String getId_prodi() {
        return id_prodi;
    }

    public void setId_prodi(String id_prodi) {
        this.id_prodi = id_prodi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNo_hp() {
        return hp;
    }

    public void setNo_hp(String hp) {
        this.hp = hp;
    }
}
