package com.web.furama.repositories;

import com.web.furama.models.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

    @Transactional
    @Modifying
    @Query("update Facility f set f.status = false where f.id = ?1")
    void delFacility(long id);
}
