package com.web.furama.services;

import com.web.furama.models.AttachFacility;
import com.web.furama.models.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AttachFacilityService {

    List<AttachFacility> getAllAttachFacilities();

    Page<AttachFacility> getAllAttachFacilities(int page);

    AttachFacility findAttachFacilityById(long id);
    void addNewAttachFacility(AttachFacility attachFacility);
    void updateAttachFacility(AttachFacility attachFacility);
    void deleteAttachFacility(long id);
}
