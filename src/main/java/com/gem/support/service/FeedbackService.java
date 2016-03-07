package com.gem.support.service;

import com.gem.support.persistent.model.Feedback;
import com.gem.support.service.dto.CompanyTicketDTO;
import com.mysema.query.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface FeedbackService extends BaseService<Feedback,String> {

    public List<Tuple> getCompanyWithTicket();
    public Page<Feedback> getTicketByCompany(String company, Pageable pageable);
}
