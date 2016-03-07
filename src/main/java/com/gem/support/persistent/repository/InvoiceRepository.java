package com.gem.support.persistent.repository;

import com.gem.support.persistent.model.Invoice;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends
        PagingAndSortingRepository<Invoice, String>, QueryDslPredicateExecutor<Invoice>, InvoiceRepositoryCustom {

}
