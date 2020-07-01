package com.web.furama.services.impl;

import com.web.furama.models.Facility;
import com.web.furama.models.FacilityType;
import com.web.furama.repositories.FacilityTypeRepository;
import com.web.furama.services.FacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeServiceImpl implements FacilityTypeService {

    @Autowired
    FacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> getAllFacilityType() {
        return facilityTypeRepository.findAll();
    }
}
