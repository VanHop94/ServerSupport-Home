package com.gem.support.api;

import com.gem.support.persistent.model.Feedback;
import com.gem.support.persistent.model.QFeedback;
import com.gem.support.service.FeedbackService;
import com.gem.support.service.dto.CompanyTicketDTO;
import com.mysema.query.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody Feedback feedback){
        feedbackService.create(feedback);
    }

    @RequestMapping("/company")
    public List<CompanyTicketDTO> getCompanyWithTicket(){

        List<Tuple> tuples = feedbackService.getCompanyWithTicket();
        List<CompanyTicketDTO> companyTicketDTOs = new ArrayList<CompanyTicketDTO>();
        for(Tuple tuple : tuples){
            companyTicketDTOs.add(new CompanyTicketDTO(tuple.get(QFeedback.feedback.company),tuple.get(QFeedback.feedback.count())));
        }
        return companyTicketDTOs;
    }

    @RequestMapping("/company/{name}")
    public Page<Feedback> getTicketByCompanyName(@PathVariable("name") String name, Pageable pageable){
        return feedbackService.getTicketByCompany(name,pageable);
    }
}
