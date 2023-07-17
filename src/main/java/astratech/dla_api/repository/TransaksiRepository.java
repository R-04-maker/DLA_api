package astratech.dla_api.repository;

import astratech.dla_api.model.mskoleksi;
import astratech.dla_api.model.trbooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TransaksiRepository")
public interface TransaksiRepository extends JpaRepository<trbooking, Integer> {
    @Query("SELECT h FROM trbooking h")
    public List<trbooking> getBoking();

    @Query(value = "select a.*,b.nama,b.nomor from trbooking as a, msuser as b where a.status = 'Pengajuan' AND a.email = b.email", nativeQuery = true)
    List<Object[]> getUnconfirmedBooking();

    @Query(value = "select TOP 1 a.id_transaction, a.bookingonline, a.status, b.tanggalpinjam, b.tanggalkembali, c.nomor, c.nama, c.id_prodi, d.deskripsi, c.hp" +
            " from trbooking as a, trbookingdetail as b, msuser as c, msprodi as d where a.id_transaction = b.id_transaction and a.email = c.email " +
            "and c.id_prodi = d.id_prodi and a.bookingonline = ?1", nativeQuery = true)
    Object[] getDetailBooking(int idBooking);

    @Query(value = "SELECT c.bookingonline, a.id_koleksi, b.nama, b.gambar," +
            "(SELECT nama FROM mskategori WHERE mskategori.id_kategori = b.id_kategori) AS kategori" +
            " FROM trbookingdetail AS a" +
            " JOIN mskoleksi AS b ON a.id_koleksi = b.id_koleksi" +
            " JOIN trbooking AS c ON a.id_transaction = c.id_transaction" +
            " WHERE c.bookingonline = ?1",nativeQuery = true)
    List<Object[]> getBukuDetailBooking(int idBooking);
}
