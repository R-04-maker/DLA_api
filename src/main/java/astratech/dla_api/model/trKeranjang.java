package astratech.dla_api.model;

import javax.persistence.*;

@Entity
@Table(name = "trKeranjangPeminjaman")

public class trKeranjang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_keranjang;

    @ManyToOne
    @JoinColumn(name = "email")
    private msuser email;

    @ManyToOne
    @JoinColumn(name = "id_koleksi")
    private mskoleksi id_koleksi;

    public trKeranjang() {
    }

    public trKeranjang(int id_keranjang, msuser email, mskoleksi id_koleksi) {
        this.id_keranjang = id_keranjang;
        this.email = email;
        this.id_koleksi = id_koleksi;
    }

    public int getId_keranjang() {
        return id_keranjang;
    }

    public void setId_keranjang(int id_keranjang) {
        this.id_keranjang = id_keranjang;
    }

    public msuser getEmail() {
        return email;
    }

    public void setEmail(msuser email) {
        this.email = email;
    }

    public mskoleksi getId_koleksi() {
        return id_koleksi;
    }

    public void setId_koleksi(mskoleksi id_koleksi) {
        this.id_koleksi = id_koleksi;
    }
}
