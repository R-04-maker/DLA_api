package astratech.dla_api.repository;

import astratech.dla_api.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("KeranjangRepository")
public interface trKeranjangRepository extends JpaRepository<trKeranjang, Integer> {

    @Query(value = "select * from trKeranjangPeminjaman where email=?1",nativeQuery = true)
    List<trKeranjang> getAllKeranjangById(String email);

}
