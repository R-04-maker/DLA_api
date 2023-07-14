package astratech.dla_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class trklasifikasikoleksi {


    @ManyToOne
    @Id
    @JoinColumn(name = "id_koleksi")
    private mskoleksi id_koleksi;

    @ManyToOne
    @Id
    @JoinColumn(name = "id_klasifikasi")
    private msklasifikasi id_klasifikasi;

    public trklasifikasikoleksi(mskoleksi id_koleksi, msklasifikasi id_klasifikasi) {
        this.id_koleksi = id_koleksi;
        this.id_klasifikasi = id_klasifikasi;
    }

    public trklasifikasikoleksi() {
    }

    public mskoleksi getId_koleksi() {
        return id_koleksi;
    }

    public void setId_koleksi(mskoleksi id_koleksi) {
        this.id_koleksi = id_koleksi;
    }

    public msklasifikasi getId_klasifikasi() {
        return id_klasifikasi;
    }

    public void setId_klasifikasi(msklasifikasi id_klasifikasi) {
        this.id_klasifikasi = id_klasifikasi;
    }
}
