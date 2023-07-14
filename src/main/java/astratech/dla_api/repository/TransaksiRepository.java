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
    List<trbooking> getUnconfirmedBooking();
}
