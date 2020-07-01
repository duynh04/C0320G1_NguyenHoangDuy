package com.web.furama.services;

import com.web.furama.models.Facility;
import com.web.furama.models.FacilityType;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FacilityService {
    List<Facility> getAllFacilities();
    Page<Facility> getAllFacilities(int page);
    List<FacilityType> getAllFacilityType();

    Facility getFacilityById(long id);
    void addNewFacility(Facility facility);

    void updateFacility(Facility facility);

    void delFacility(long id);
}
