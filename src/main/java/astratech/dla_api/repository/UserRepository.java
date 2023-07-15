package astratech.dla_api.repository;


import astratech.dla_api.model.msuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<msuser, Integer> {



    @Query("SELECT h FROM msuser h WHERE h.nama =:nama ")
    public msuser getmahasiswaUser(@Param("nama")String nama );

    @Query("SELECT h FROM msuser h")
    public List<msuser> getAllUser();
}
