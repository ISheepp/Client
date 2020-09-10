package com.codelin.service;

import com.codelin.entity.Plan;

import java.util.List;

/**
 * @author lin
 * @create 2020-09-10 15:06
 */
public interface PlanService {

    List<Plan> findByClientName(String clientname);

}
