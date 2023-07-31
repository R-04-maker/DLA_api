package astratech.dla_api.repository;

import astratech.dla_api.model.mskoleksi;
import astratech.dla_api.model.tratributkoleksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("dla_mskoleksiRepository")
public interface KoleksiRepository extends JpaRepository<mskoleksi, Integer> {
/*    @Query(value = "select a.*, b.deskripsi as pengarang from mskoleksi as a, tratributkoleksi as b, msatribut as c where a.id_koleksi = b.id_koleksi and b.id_atribut = c.id_atribut and c.id_atribut = 'IT001' and a.status = 1", nativeQuery = true)
    List<mskoleksi> findAllByBrg_status();    */
    @Query(value = "select * from mskoleksi where status = 1", nativeQuery = true)
    List<mskoleksi> findAllByBrg_status();

    // Newest Collection
//    @Query("select a from mskoleksi a where  a.status=1 ORDER BY a.creadate DESC LIMIT 10")
    @Query(value = "select TOP 10 * from mskoleksi where status = 1 order by creadate DESC", nativeQuery = true)
    List<mskoleksi> getNewestbyCreadate();


    // Newest Released
//    @Query("select a from mskoleksi a where  a.status=1 ORDER BY a.tahun_terbit DESC LIMIT 10")
    @Query(value = "SELECT TOP 10 * from mskoleksi where status = 1 ORDER BY tahun_terbit DESC", nativeQuery = true)
    List<mskoleksi> getNewestbyTahunterbit();

    @Query(value = "SELECT TOP 10 k.id_koleksi, b.nama, b.deskripsi, b.id_kategori, b.id_rak, b.id_prodi, b.gambar, b.tautan, b.status, b.statuspinjam, b.bisapinjam, b.creaby, b.creadate, b.modiby, b.modidate, b.tahun_terbit, b.penyumbang\n" +
            "FROM trbookingdetail k\n" +
            "INNER JOIN mskoleksi b ON k.id_koleksi = b.id_koleksi\n" +
            "GROUP BY k.id_koleksi, b.nama, b.deskripsi, b.id_kategori, b.id_rak, b.id_prodi, b.gambar, b.tautan, b.status, b.statuspinjam, b.bisapinjam, b.creaby, b.creadate, b.modiby, b.modidate, b.tahun_terbit, b.penyumbang\n" +
            "ORDER BY COUNT(*) DESC;",nativeQuery = true)
    List<mskoleksi> getPopularBook();

    @Query(value = "SELECT " +
            "(SELECT COUNT(*) FROM mskoleksi) AS jumlah_buku," +
            "(SELECT COUNT(*) FROM trpengunjung WHERE CONVERT(date, creadate) = CONVERT(date, GETDATE())) AS jumlah_pengunjung,\n" +
            "(SELECT COUNT(*) FROM trbooking WHERE MONTH(creadate) = MONTH(GETDATE())) AS jumlah_history",nativeQuery = true)
    List<Object[]> getDataDashboard();
    @Query(value = "SELECT \n" +
            "    (SELECT COUNT(*) FROM trbooking WHERE email = ?1 AND status = 'Selesai') AS count_booking_selesai,\n" +
            "    (SELECT COUNT(id_koleksi) FROM trbookingdetail a, trbooking as b WHERE a.id_transaction = b.id_transaction AND b.status = 'Dipinjam' AND b.email = ?1) AS count_buku_dipinjam,\n" +
            "    (SELECT COUNT(*) FROM trKeranjangPeminjaman WHERE email = ?1) AS count_keranjang",nativeQuery = true)
    List<Object[]> getDataDashboardMember(String email);

    @Query(value = "select id_koleksi, nama, deskripsi, id_rak, id_prodi, gambar, tautan, status, statuspinjam,\n" +
            "(select nama from mskategori where mskategori.id_kategori = mskoleksi.id_kategori) as kategori,\n" +
            "(select id_rak + ' - ' + nama from msrak where msrak.id_rak = mskoleksi.id_rak) as rak,\n" +
            "(select deskripsi from msprodi where msprodi.id_prodi = mskoleksi.id_prodi) as prodi,\n" +
            "bisapinjam, penyumbang, tahun_terbit\n" +
            "from mskoleksi\n" +
            "where id_koleksi = ?1",nativeQuery = true)
    List<Object[]> getDetailKoleksi(int id);

    @Query(value = "select a.id_atribut, a.id_koleksi, a.deskripsi, b.nama\n" +
            "from tratributkoleksi as a, msatribut as b\n" +
            "where a.id_atribut = b.id_atribut and\n" +
            "a.id_koleksi = ?1",nativeQuery = true)
//    List<Object[]> getAtributDetail(@Param("id") Integer id);
    List<Object[]> getAtributDetail(int id);

    @Query(value = "select a.id_koleksi, a.id_klasifikasi, b.nama " +
            "from trklasifikasikoleksi as a, msklasifikasi as b " +
            "where a.id_klasifikasi = b. id_klasifikasi and " +
            "a.id_koleksi = ?1",nativeQuery = true)
    List<Object[]> getKlasifikasiDetail(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE mskoleksi set statuspinjam =:status WHERE id_koleksi=:idKoleksi", nativeQuery = true)
    void updateStatusPinjam(@Param("idKoleksi") String idKoleksi, @Param("status") int status);

}
