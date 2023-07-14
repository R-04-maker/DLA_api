package astratech.dla_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "msklasifikasi")
public class msklasifikasi {

    @Id
    private String id_klasifikasi;
    private String nama;
    private String deskripsi;
    private int status;


    public String getId_klasifikasi() {
        return id_klasifikasi;
    }

    public void setId_klasifikasi(String id_klasifikasi) {
        this.id_klasifikasi = id_klasifikasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public msklasifikasi() {
    }

    public msklasifikasi(String id_klasifikasi, String nama, String deskripsi, int status) {
        this.id_klasifikasi = id_klasifikasi;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.status = status;
    }
}
