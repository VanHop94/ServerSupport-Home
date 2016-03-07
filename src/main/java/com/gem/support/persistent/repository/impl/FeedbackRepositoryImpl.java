package com.gem.support.persistent.repository.impl;

import com.gem.support.persistent.model.QFeedback;
import com.gem.support.persistent.repository.FeedbackRepositoryCustom;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.hibernate.HibernateQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by VanHop on 3/8/2016.
 */
@Repository
public class FeedbackRepositoryImpl implements FeedbackRepositoryCustom {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Tuple> getCompanyWithTickick() {

        JPQLQuery query = new HibernateQuery(sessionFactory.openSession());
        return query.from(QFeedback.feedback).groupBy(QFeedback.feedback.company).list(QFeedback.feedback.company, QFeedback.feedback.count());
    }
}
