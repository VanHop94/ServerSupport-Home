package com.gem.support.service.impl;

import com.gem.support.persistent.model.Feedback;
import com.gem.support.persistent.model.QFeedback;
import com.gem.support.persistent.repository.FeedbackRepository;
import com.gem.support.persistent.repository.FeedbackRepositoryCustom;
import com.gem.support.service.FeedbackService;
import com.gem.support.service.dto.CompanyTicketDTO;
import com.mysema.query.Tuple;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.NumberExpression;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    FeedbackRepositoryCustom feedbackRepositoryCustom;

    @Override
    public void create(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Override
    public void update(Feedback feedback) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Feedback findOne(String s) {
        return null;
    }

    @Override
    public Page<Feedback> findAll(Pageable pageable) {
        feedbackRepository.findAll(pageable);
        return null;
    }

    @Override
    public List<Tuple> getCompanyWithTicket() {

        List<Tuple> tuples = feedbackRepositoryCustom.getCompanyWithTickick();

        return tuples;
    }

    @Override
    public Page<Feedback> getTicketByCompany(String company,Pageable pageable) {

        Page<Feedback> page = feedbackRepository.findByCompany(company,pageable);

        return page.map(source -> {
            Feedback feedback = new Feedback();
            BeanUtils.copyProperties(source, feedback);
            return  feedback;
        });
    }
}
