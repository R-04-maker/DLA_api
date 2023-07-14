package astratech.dla_api.repository;


import astratech.dla_api.model.trpengunjung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PengunjungRepository")
public interface PengunjungRepository extends JpaRepository<trpengunjung, Integer> {

    @Query("SELECT h FROM trpengunjung h")
    public List<trpengunjung> getAllPengunjung();
}
