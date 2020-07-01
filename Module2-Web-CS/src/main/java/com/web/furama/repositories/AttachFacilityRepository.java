package com.web.furama.repositories;

import com.web.furama.models.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AttachFacilityRepository extends JpaRepository<AttachFacility, Long> {

    @Transactional
    @Modifying
    @Query("update AttachFacility a set a.status = false where a.id = ?1")
    void delAttachFacility(long id);
}
