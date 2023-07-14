package astratech.dla_api.repository;

import astratech.dla_api.model.mskategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KategoriRepository extends JpaRepository<mskategori, Integer> {

    @Query("SELECT h FROM mskategori h WHERE h.nama =:nama ")
    public mskategori getkategoriNama(@Param("nama")String nama );

    @Query("SELECT h FROM mskategori h")
    public List<mskategori> getAllKategori();
}