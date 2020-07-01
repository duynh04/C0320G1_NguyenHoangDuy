package com.web.furama.searches.specs;

import com.web.furama.models.Customer;
import com.web.furama.models.CustomerType;
import com.web.furama.services.CustomerService;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDate;

public class CustomerSpecifications implements Specification<Customer> {

    private final SearchCriteria searchCriteria;

    public CustomerSpecifications(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (searchCriteria.getOperation().equalsIgnoreCase("name")) {
            return criteriaBuilder.like(root.get(searchCriteria.getKey()), "%" + searchCriteria.getValues().get(0) + "%");
        } else if (searchCriteria.getOperation().equalsIgnoreCase("type")) {
            Join<Customer, CustomerType> customers = root.join("customerType");
            return criteriaBuilder.equal(customers.get(searchCriteria.getKey()), searchCriteria.getValues().get(0));
        } else if (searchCriteria.getOperation().equalsIgnoreCase("date")) {
            return criteriaBuilder.between(root.get(searchCriteria.getKey()), criteriaBuilder.literal(LocalDate.parse(searchCriteria.getValues().get(0))), criteriaBuilder.literal(LocalDate.parse(searchCriteria.getValues().get(1))));
        }
        return null;
    }
}
