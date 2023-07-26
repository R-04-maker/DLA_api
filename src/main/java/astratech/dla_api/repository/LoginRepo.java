package astratech.dla_api.repository;

import astratech.dla_api.model.LoginModel;
import astratech.dla_api.model.msprodi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("LoginRepo")
public interface LoginRepo extends JpaRepository<LoginModel, Integer> {
    @Query(value = "SELECT u.*, p.deskripsi\n" +
            "FROM msuser u\n" +
            "JOIN msprodi p ON u.id_prodi = p.id_prodi\n" +
            "WHERE u.nomor = ?1 and u.password=?2",nativeQuery = true)
    LoginModel login(@Param("nomor")String nim, @Param("password") String password);


}
