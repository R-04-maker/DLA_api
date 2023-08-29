package astratech.dla_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import astratech.dla_api.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdiRepository extends JpaRepository<msprodi,Integer> {

    @Query(value = "SELECT * FROM msprodi WHERE status = 1",nativeQuery = true)
    List<msprodi> getbyStatus();
}
