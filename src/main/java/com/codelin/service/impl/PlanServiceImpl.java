package com.codelin.service.impl;

import com.codelin.dao.PlanDao;
import com.codelin.entity.Plan;
import com.codelin.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lin
 * @create 2020-09-10 15:06
 */

@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanDao planDao;

    @Override
    public List<Plan> findByClientName(String clientname) {
        return planDao.findByClientName(clientname);
    }
}
