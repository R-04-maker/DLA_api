package astratech.dla_api.repository;

import astratech.dla_api.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("LoginRepo")
public interface LoginRepo extends JpaRepository<LoginModel, Integer> {
    @Query(value = "SELECT * FROM msuser where nomor = ?1 and password = ?2",nativeQuery = true)
    LoginModel login(@Param("nomor")String nim, @Param("password") String password);
}
