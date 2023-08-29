package astratech.dla_api.repository;

import astratech.dla_api.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("KeranjangRepository")
public interface KeranjangRepository extends JpaRepository<trKeranjang, Integer> {

    @Query(value = "select * from trKeranjangPeminjaman where email=?1",nativeQuery = true)
    List<trKeranjang> getAllKeranjangById(String email);

    @Query(value = "select * from trKeranjangPeminjaman where email=?1 and id_koleksi=?2",nativeQuery = true)
    trKeranjang cekKeranjang(String email, String idKoleksi);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM trKeranjangPeminjaman where email=?1 and id_koleksi=?2",nativeQuery = true)
    void deleteKeranjang(String email, String idKoleksi);
}
