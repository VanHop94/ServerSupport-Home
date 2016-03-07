package com.gem.support.persistent.repository;

import com.gem.support.persistent.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FeedbackRepository extends PagingAndSortingRepository<Feedback,String>,QueryDslPredicateExecutor<Feedback> {

    Page<Feedback> findByCompany(String company, Pageable pageable);

}
