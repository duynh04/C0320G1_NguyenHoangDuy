package com.example.exam.services.filters;

import com.example.exam.models.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class CustomerSpecification implements Specification<Customer> {

    private final SearchCriteria criteria;

    public CustomerSpecification(SearchCriteria searchCriteria) {
        criteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(criteria.getOperation().equalsIgnoreCase("like")) {
            return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
        }
        return null;
    }
}
