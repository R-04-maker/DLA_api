package astratech.dla_api.repository;

import astratech.dla_api.model.trklasifikasirak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("KlasifikasiRakRepository")
public interface KlasifikasiRakRepository extends JpaRepository<trklasifikasirak, Integer> {
    @Query("SELECT h FROM trklasifikasirak h")
    public List<trklasifikasirak> getKlasifikasiRak();
}
