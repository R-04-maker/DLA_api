package astratech.dla_api.repository;

import astratech.dla_api.model.msatribut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AtributRepository")
public interface AtributRepository extends JpaRepository<msatribut, Integer> {

    @Query("SELECT h FROM msatribut h WHERE h.nama =:nama ")
    public msatribut getAtributbyName(@Param("nama")String nama );

    @Query("SELECT h FROM msatribut h")
    public List<msatribut> getAtributs();
}
