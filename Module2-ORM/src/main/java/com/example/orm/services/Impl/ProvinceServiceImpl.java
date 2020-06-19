package com.example.orm.services.Impl;

import com.example.orm.dtos.FilterProvince;
import com.example.orm.models.Province;
import com.example.orm.repositories.ProvinceRepository;
import com.example.orm.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public Province findProvinceById(long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Province> findAllProvinces(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public List<Province> findAddProvinces() {
        return provinceRepository.findAll();
    }

    @Override
    public void updateProvince(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void saveProvince(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void deleteProvince(long id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public Page<Province> findProvinceByFirstName(String firstName, Pageable pageable) {
        return null;
    }

    @Override
    public Specification<Province> getFilter(FilterProvince filterProvince) {
        return null;
    }

    @Override
    public Page<Province> findProvinceByCriteria(Specification<Province> spec, Pageable pageable) {
        return null;
    }
}
