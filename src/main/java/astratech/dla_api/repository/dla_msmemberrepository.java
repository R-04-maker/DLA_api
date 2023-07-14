package astratech.dla_api.repository;


import astratech.dla_api.model.msmember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dla_msmemberRepository")
public interface dla_msmemberrepository extends JpaRepository<msmember, Integer> {
    @Query("select a from msmember a where  a.mbr_nim=:nim")
    List<dla_msmemberrepository> findAllByMember_nim(String nim);


    @Query(value = "SELECT * FROM msmember where mbr_username = ?1 and mbr_password = ?2",nativeQuery = true)
    msmember login(@Param("username")String username, @Param("password") String password);

    @Query("SELECT h FROM msmember h WHERE h.mbr_nim =:nim")
    public msmember getmahasiswaByid(@Param("nim")String nim );
    @Query("SELECT h FROM msmember h WHERE h.mbr_username =:username ")
    public msmember getmahasiswaByUser(@Param("username")String username );

    @Query("SELECT h FROM msmember h")
    public List<msmember> getMahasiswas();
}
