package astratech.dla_api.repository;


import astratech.dla_api.model.msklasifikasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("KlasifikasiRepository")
public interface KlasifikasiRepository extends JpaRepository<msklasifikasi, Integer> {

    @Query("SELECT h FROM msuser h WHERE h.nama =:nama ")
    public msklasifikasi getklasifikasi(@Param("nama")String nama );

    @Query("SELECT h FROM msklasifikasi h")
    public List<msklasifikasi> getAllKlasifikasi();
}
