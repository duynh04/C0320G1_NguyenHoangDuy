package com.web.furama.services.impl;

import com.web.furama.models.AttachFacility;
import com.web.furama.repositories.AttachFacilityRepository;
import com.web.furama.services.AttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityServiceImpl implements AttachFacilityService {
    @Autowired
    AttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> getAllAttachFacilities() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public Page<AttachFacility> getAllAttachFacilities(int page) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        return attachFacilityRepository.findAll(pageable);

    }

    @Override
    public void addNewAttachFacility(AttachFacility attachFacility) {
        attachFacility.setStatus(true);
        attachFacilityRepository.save(attachFacility);
    }

    @Override
    public void deleteAttachFacility(long id) {
        attachFacilityRepository.delAttachFacility(id);
    }

    @Override
    public AttachFacility findAttachFacilityById(long id) {
        return attachFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAttachFacility(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }
}
