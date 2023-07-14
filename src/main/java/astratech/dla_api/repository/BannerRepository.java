package astratech.dla_api.repository;

import astratech.dla_api.model.msbanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BannerRepository")
public interface BannerRepository extends JpaRepository<msbanner, Integer> {
    @Query("SELECT h FROM msbanner h WHERE h.nama =:nama ")
    public msbanner getBannerbyName(@Param("nama")String nama );

    @Query("SELECT h FROM msbanner h")
    public List<msbanner> getBanners();
}
