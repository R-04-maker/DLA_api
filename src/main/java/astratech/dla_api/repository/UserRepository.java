package astratech.dla_api.repository;


import astratech.dla_api.model.msuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<msuser, Integer> {
    @Query("SELECT h FROM msuser h WHERE h.nama =:nama ")
    public msuser getmahasiswaUser(@Param("nama")String nama );

    @Query("SELECT h FROM msuser h")
    public List<msuser> getAllUser();

    @Query(value = "SELECT * FROM msuser WHERE id_role =:idRole", nativeQuery = true)
    List<msuser> getUserByRole(@Param("idRole") String idRole);

    @Transactional
    @Modifying
    @Query(value = "UPDATE msuser SET token =:token WHERE email =:email", nativeQuery = true)
    void updateToken(@Param("token") String token, @Param("email") String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE msuser SET token = NULL WHERE email =:email", nativeQuery = true)
    void deleteToken(@Param("email") String email);
}
