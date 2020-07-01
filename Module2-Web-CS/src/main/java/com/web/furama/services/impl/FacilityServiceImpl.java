package com.web.furama.services.impl;

import com.web.furama.models.Facility;
import com.web.furama.models.FacilityType;
import com.web.furama.repositories.FacilityRepository;
import com.web.furama.services.FacilityService;
import com.web.furama.services.FacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    FacilityTypeService facilityTypeService;

    @Autowired
    FacilityRepository facilityRepository;

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @Override
    public List<FacilityType> getAllFacilityType() {
        return facilityTypeService.getAllFacilityType();
    }

    @Override
    public void addNewFacility(Facility facility) {
        facility.setStatus(true);
        facilityRepository.save(facility);
    }

    @Override
    public Page<Facility> getAllFacilities(int page) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        return facilityRepository.findAll(pageable);
    }

    @Override
    public Facility getFacilityById(long id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public void updateFacility(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void delFacility(long id) {
        facilityRepository.delFacility(id);
    }
}
