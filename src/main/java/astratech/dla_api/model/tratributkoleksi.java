package astratech.dla_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class tratributkoleksi {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_koleksi")
    private mskoleksi id_koleksi;

    @ManyToOne
    @JoinColumn(name = "id_atribut")
    private msatribut id_atribut;
    private String deskripsi;

    public tratributkoleksi(mskoleksi id_koleksi, msatribut id_atribut, String deskripsi) {
        this.id_koleksi = id_koleksi;
        this.id_atribut = id_atribut;
        this.deskripsi = deskripsi;
    }


    public tratributkoleksi() {
    }

    public mskoleksi getId_koleksi() {
        return id_koleksi;
    }

    public void setId_koleksi(mskoleksi id_koleksi) {
        this.id_koleksi = id_koleksi;
    }

    public msatribut getId_atribut() {
        return id_atribut;
    }

    public void setId_atribut(msatribut id_atribut) {
        this.id_atribut = id_atribut;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
