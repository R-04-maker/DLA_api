package astratech.dla_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import astratech.dla_api.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface msprodiRepository extends JpaRepository<msprodi,Integer> {


}
