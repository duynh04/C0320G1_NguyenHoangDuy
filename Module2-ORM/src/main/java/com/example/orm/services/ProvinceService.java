package com.example.orm.services;

import com.example.orm.dtos.FilterProvince;
import com.example.orm.models.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProvinceService {
    Province findProvinceById(long id);
    Page<Province> findAllProvinces(Pageable pageable);

    List<Province> findAddProvinces();
    void updateProvince(Province province);

    void saveProvince(Province province);

    void deleteProvince(long id);

    Page<Province> findProvinceByFirstName(String firstName, Pageable pageable);

    Specification<Province> getFilter(FilterProvince filterProvince);
    Page<Province> findProvinceByCriteria(Specification<Province> spec, Pageable pageable);
}
