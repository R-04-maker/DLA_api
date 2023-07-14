package astratech.dla_api.repository;

import astratech.dla_api.model.tratributkategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AtributKategoriRepository")
public interface AtributKategoriRepository extends JpaRepository<tratributkategori, Integer> {

    @Query("SELECT h FROM tratributkategori h")
    public List<tratributkategori> getAtKategori();
}
