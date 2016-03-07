package com.gem.support.persistent.repository;

import com.gem.support.persistent.model.Feedback;
import com.mysema.query.Tuple;

import java.util.List;

/**
 * Created by VanHop on 3/8/2016.
 */
public interface FeedbackRepositoryCustom {
    List<Tuple> getCompanyWithTickick();
}
