package astratech.dla_api.repository;


import astratech.dla_api.model.trdenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DendaRepository")
public interface DendaRepository extends JpaRepository<trdenda, Integer> {


    @Query("SELECT h FROM trdenda h")
    public List<trdenda> getAllDenda();

}
