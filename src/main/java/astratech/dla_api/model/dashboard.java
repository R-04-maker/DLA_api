package astratech.dla_api.model;


import javax.persistence.*;

@Entity
public class dashboard {
    @Id
    private int jumlah_buku;
    private int jumlah_pengunjung;
    private int jumlah_history;

    public dashboard() {
    }
    public dashboard(int jumlah_buku, int jumlah_pengunjung, int jumlah_history) {
        this.jumlah_buku = jumlah_buku;
        this.jumlah_pengunjung = jumlah_pengunjung;
        this.jumlah_history = jumlah_history;
    }

    public int getJumlah_buku() {
        return jumlah_buku;
    }

    public void setJumlah_buku(int jumlah_buku) {
        this.jumlah_buku = jumlah_buku;
    }

    public int getJumlah_pengunjung() {
        return jumlah_pengunjung;
    }

    public void setJumlah_pengunjung(int jumlah_pengunjung) {
        this.jumlah_pengunjung = jumlah_pengunjung;
    }

    public int getJumlah_history() {
        return jumlah_history;
    }

    public void setJumlah_history(int jumlah_history) {
        this.jumlah_history = jumlah_history;
    }
}
