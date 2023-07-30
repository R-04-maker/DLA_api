package astratech.dla_api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mskoleksi")
public class mskoleksi {
    @Id
    private String id_koleksi;
    private String nama;
    private String deskripsi;
    @ManyToOne
    @JoinColumn(name = "id_kategori")
    @JsonIgnoreProperties("koleksi")
    private mskategori id_kategori;
    @ManyToOne
    @JoinColumn(name = "id_rak")
    @JsonIgnoreProperties("koleksi")
    private msrak id_rak;
    @ManyToOne
    @JoinColumn(name = "id_prodi")
    @JsonIgnoreProperties("koleksi")
    private msprodi id_prodi;
    private String gambar;
    private String tautan;
    private int status;
    private int statuspinjam;
    private int bisapinjam;
    private String creaby;
    private Date creadate;
    private String modiby;
    private Date modidate;
    private String tahun_terbit;
    private String penyumbang;
    private String pengarang;
    private String penerbit;

    public mskoleksi() {
    }

    public mskoleksi(String id_koleksi, String nama, String deskripsi, mskategori id_kategori, msrak id_rak, msprodi id_prodi, String gambar, String tautan, int status, int statuspinjam, int bisapinjam, String creaby, Date creadate, String modiby, Date modidate, String tahun_terbit, String penyumbang, String pengarang, String penerbit) {
        this.id_koleksi = id_koleksi;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.id_kategori = id_kategori;
        this.id_rak = id_rak;
        this.id_prodi = id_prodi;
        this.gambar = gambar;
        this.tautan = tautan;
        this.status = status;
        this.statuspinjam = statuspinjam;
        this.bisapinjam = bisapinjam;
        this.creaby = creaby;
        this.creadate = creadate;
        this.modiby = modiby;
        this.modidate = modidate;
        this.tahun_terbit = tahun_terbit;
        this.penyumbang = penyumbang;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
    }

    public String getId_koleksi() {
        return id_koleksi;
    }

    public void setId_koleksi(String id_koleksi) {
        this.id_koleksi = id_koleksi;
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

    public mskategori getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(mskategori id_kategori) {
        this.id_kategori = id_kategori;
    }

    public msrak getId_rak() {
        return id_rak;
    }

    public void setId_rak(msrak id_rak) {
        this.id_rak = id_rak;
    }

    public msprodi getId_prodi() {
        return id_prodi;
    }

    public void setId_prodi(msprodi id_prodi) {
        this.id_prodi = id_prodi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getTautan() {
        return tautan;
    }

    public void setTautan(String tautan) {
        this.tautan = tautan;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatuspinjam() {
        return statuspinjam;
    }

    public void setStatuspinjam(int statuspinjam) {
        this.statuspinjam = statuspinjam;
    }

    public int getBisapinjam() {
        return bisapinjam;
    }

    public void setBisapinjam(int bisapinjam) {
        this.bisapinjam = bisapinjam;
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

    public String getTahun_terbit() {
        return tahun_terbit;
    }

    public void setTahun_terbit(String tahun_terbit) {
        this.tahun_terbit = tahun_terbit;
    }

    public String getPenyumbang() {
        return penyumbang;
    }

    public void setPenyumbang(String penyumbang) {
        this.penyumbang = penyumbang;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
}
