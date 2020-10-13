package com.example.orm.services.filters;

import com.example.orm.models.Customer;
import com.example.orm.models.Province;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class CustomerSpecification implements Specification<Customer> {

    private final SearchCriteria criteria;

    public CustomerSpecification(SearchCriteria searchCriteria) {
        criteria = searchCriteria;
    }
    // where key like %value%.
    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(criteria.getOperation().equalsIgnoreCase("=")) { //equal, greater.
            return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else if(criteria.getOperation().equalsIgnoreCase("join")) {
            Join<Customer, Province> listJoin = root.join("province"); // inner join.
            return criteriaBuilder.like(listJoin.get(criteria.getKey()), "%" + criteria.getValue() + "%");
        }
        return null;
    }
}
