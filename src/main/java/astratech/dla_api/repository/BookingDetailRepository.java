package astratech.dla_api.repository;


import astratech.dla_api.model.trbookingdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BookingDetailRepository")
public interface BookingDetailRepository extends JpaRepository<trbookingdetail, Integer> {

    @Query("SELECT h FROM trbookingdetail h")
    public List<trbookingdetail> getBookdet();
}
